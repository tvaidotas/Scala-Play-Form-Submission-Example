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
import reactivemongo.bson.BSONDocument

class MongoApplicationController @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends Controller
  with MongoController with ReactiveMongoComponents {

  def collection: Future[JSONCollection] = database.map(_.collection[JSONCollection]("persons"))

  def create: Action[AnyContent] = Action.async {
    val user = User(None, "Tom", "Jefferson", List(Feed("BBC news", "http://www.bbc.co.uk")))
    val futureResult = collection.flatMap(_.insert(user))
    futureResult.map(_ => Ok("Added user " + user.firstName + " " + user.lastName))
  }

  def findByName: Action[AnyContent] = Action.async {
    val cursor: Future[Cursor[User]] = collection.map {
      //_.find(Json.obj("lastName" -> "Lastname"))  // searching by a particular field
      _.find(Json.obj())                            // getting averything from the collection
        .sort(Json.obj("created" -> -1))
        .cursor[User]
    }
    val futureUsersList: Future[List[User]] = cursor.flatMap(_.collect[List]())
    futureUsersList.map { persons =>
      Ok(persons.mkString(" "))
    }
  }

  def update: Action[AnyContent] = Action.async {
    val user = User(Some(40), "Jack", "Johnes", List(Feed("BBC news", "http://www.bbc.co.uk")))
    val selector = BSONDocument("firstName" -> "Tom") // looking for the record based on some field
    val futureResult = collection.map(_.findAndUpdate(selector,user))
    futureResult.map(_ => Ok("Updated user"))
  }

  def remove: Action[AnyContent] = Action.async {
    // deleteting a record based on some field
    val futureResult = collection.map{_.findAndRemove(Json.obj("firstName"->"Tom"))}
    futureResult.map(_ => Ok("Deleted user"))
  }

}
