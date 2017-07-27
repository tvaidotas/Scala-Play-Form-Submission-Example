package controllers

import javax.inject.Inject

import scala.concurrent.Future
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

  // TODO - keep in mind you need to have mongod.exe running before attempting to play around

  def collection: Future[JSONCollection] = database.map(
    _.collection[JSONCollection]("persons"))

  def create: Action[AnyContent] = Action.async {
    val user = User(29, "FirstName", "Lastname", List(Feed("BBC news", "http://www.bbc.co.uk")))
    val futureResult = collection.flatMap(_.insert(user))
    futureResult.map(_ => Ok)
  }

  def findByName: Action[AnyContent] = Action.async {
    val cursor: Future[Cursor[User]] = collection.map {
      _.find(Json.obj("lastName" -> "Lastname")).
        sort(Json.obj("created" -> -1))
        .cursor[User]
    }
    val futureUsersList: Future[List[User]] = cursor.flatMap(_.collect[List]())
    futureUsersList.map { persons =>
      Ok(persons.head.toString)
    }
  }

}