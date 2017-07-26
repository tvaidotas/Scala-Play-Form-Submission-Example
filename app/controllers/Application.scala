package controllers

import java.io.{ByteArrayOutputStream, File}
import javax.imageio.ImageIO
import javax.inject.Inject

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64
import models.CD
import play.api.i18n.{I18nSupport, MessagesApi}

import akka.stream.Materializer
import play.api.http.ContentTypes
import play.api.libs.Comet
import play.api.mvc._

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import akka.stream.scaladsl.Source
import play.api.libs.json._

import scala.concurrent.duration._


class Application @Inject()(val messagesApi: MessagesApi, val materializer: Materializer) extends Controller with I18nSupport {

//  def index = Action {
//    Ok(views.html.index(returnBytedImage))
//  }

  def index() = Action {
    Ok(views.html.comet())
  }

  def listCDs = Action { implicit request =>
    // we return a view file which expects two arguments passed to it
    // The first argument is the Seq[CD] which contains all the CDs we want to display
    // The second argument is the Form[CD], where we pass the form we have created
    Ok(views.html.listCDs(CD.cds, CD.createCDForm))
  }

  def createCD = Action { implicit request =>
    // we create a value to which we assign the form and bind the values that were submitted and are in the response
    val formValidationResult = CD.createCDForm.bindFromRequest
    // we then fold over the form where fold is a method that belongs to Form and what it does is
    // takes in two functions, where the first one has to handle the form with errors
    // and the second one has to handle the successful form submission
    // you could look at fold like this .fold({ Function for error}, { Function for success })
    // the first function of folding is the one where the data passed for the form was incorrect
    // therefore our form with the errors on it is binded to the formWithErrors
    // And we then return a BadRequest to signify that it wasn't correct and for the BadRequest we then pass
    // the same view file, as the view file requires an argument of Seq[CD] we pass that from the CD object
    // as well as the form with errors, where passing the form with errors is going to display the errors on the page
    formValidationResult.fold({ formWithErrors =>
      BadRequest(views.html.listCDs(CD.cds, formWithErrors))
    }, { cd =>
      // the second case is the good one were the data is of the correct type therefore the cd will hold the value
      // of CD, which we then add to the list of the CDs that we have inside the CD object
      // and lastly we return a Redirect response where we take the person to the same page but list all the CDs out
      // as we're using the reverse route of .listCDs, therefore after adding a CD and submitting the form
      // we will see the CD come up on the page
      CD.cds.append(cd)
      Redirect(routes.Application.listCDs)
    })
  }

  def upload = Action(parse.multipartFormData) { implicit request =>
    val uploadService: UploadService = UploadService
    val result = uploadService.uploadFile(request)
    Redirect(routes.Application.index)
  }


  def returnBytedImage: String = {
    try {
      val image = ImageIO.read(new File("C:/Users/tadas/Desktop/toUploadTo/1.jpg"))
      val baos = new ByteArrayOutputStream
      ImageIO.write(image, "png", baos)
      val res = baos.toByteArray
      val encodedImage = Base64.encode(baos.toByteArray)
      System.out.println("encoded image " + encodedImage)
      return encodedImage
    } catch {
      case e: Exception =>
        e.printStackTrace()
        System.out.println("Error occured")
    }
    "Byting failed"
  }

  def cometString = Action {
    implicit val m = materializer
    def stringSource: Source[String, _] = Source(List("kiki", "foo", "bar"))
    Ok.chunked(stringSource via Comet.string("parent.cometMessage")).as(ContentTypes.HTML)
  }

  def cometJson = Action {
    implicit val m = materializer
    def jsonSource: Source[JsValue, _] = Source(List(JsString("jsonString")))
    Ok.chunked(jsonSource via Comet.json("parent.cometMessage")).as(ContentTypes.HTML)
  }

  def streamClock() = Action {
    Ok.chunked(stringSource via Comet.string("parent.clockChanged")).as(ContentTypes.HTML)
  }

  def stringSource: Source[String, _] = {
    val df: DateTimeFormatter = DateTimeFormatter.ofPattern("HH mm ss")
    val tickSource = Source.tick(0 millis, 100 millis, "TICK")
    val s = tickSource.map((tick) => df.format(ZonedDateTime.now()))
    s
  }

}


