package controllers

import javax.inject.Inject

import scala.concurrent.Future
import play.api.Logger
import play.api.mvc.{Action, AnyContent, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._
import reactivemongo.api.Cursor
import models._
import models.JsonFormats._
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json._
import collection._

class MongoApplicationController @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends Controller
  with MongoController with ReactiveMongoComponents {

  def collection: Future[JSONCollection] = database.map(
    _.collection[JSONCollection]("persons"))

  def create: Action[AnyContent] = Action.async {
    val user = User(29, "FirstName", "Lastname", List(Feed("BBC news", "http://www.bbc.co.uk")))
    val futureResult = collection.flatMap(_.insert(user))
    futureResult.map(_ => Ok)
  }

  def createFromJson: Action[JsValue] = Action.async(parse.json) { request =>
    request.body.validate[User].map { user =>
      collection.flatMap(_.insert(user)).map { lastError =>
        Logger.debug(s"Successfully inserted with LastError: $lastError")
        Created
      }
    }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def findByName: Action[AnyContent] = Action.async {
    val cursor: Future[Cursor[User]] = collection.map {
      _.find(Json.obj("lastName" -> "SomeLastName")).
        sort(Json.obj("created" -> -1))
        .cursor[User]
    }
    val futureUsersList: Future[List[User]] = cursor.flatMap(_.collect[List]())
    futureUsersList.map { persons =>
      Ok(persons.head.toString)
    }
  }

}