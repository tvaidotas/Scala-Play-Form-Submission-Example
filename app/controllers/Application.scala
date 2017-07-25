package controllers

import javax.inject.Inject

import models.CD
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

import scala.concurrent.Future

class Application @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def listCDs = Action { implicit request =>
    Ok(views.html.listCDs(CD.cds, CD.createCDForm.fill(CD.cds.head)))
  }

  def createCD = Action { implicit request =>
    val formValidationResult = CD.createCDForm.bindFromRequest
    formValidationResult.fold({ formWithErrors =>
      BadRequest(views.html.listCDs(CD.cds, formWithErrors))
    }, { widget =>
      CD.cds.append(widget)
      Redirect(routes.Application.listCDs)
    })
  }






}


