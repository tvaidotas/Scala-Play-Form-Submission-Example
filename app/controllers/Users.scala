package controllers

import javax.inject.Inject

import scala.concurrent.Future

import play.api.Logger
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.functional.syntax._
import play.api.libs.json._

import reactivemongo.api.Cursor
import reactivemongo.api.ReadPreference

import play.modules.reactivemongo.{
MongoController,
ReactiveMongoApi,
ReactiveMongoComponents
}

import reactivemongo.play.json._
import reactivemongo.play.json.collection._


class Users @Inject()(val reactiveMongoApi: ReactiveMongoApi)
  extends Controller with MongoController with ReactiveMongoComponents {


  def collection: Future[JSONCollection] =
    database.map(_.collection[JSONCollection]("persons"))

  def index = Action { Ok("works") }

  def create = Action.async {
    val json = Json.obj(
      "name" -> "Tadas",
      "age" -> "25",
      "created" -> new java.util.Date().getTime()
    )

    collection.flatMap(_.insert(json)).map(lastError =>
      Ok("Mongo LastError: %s".format(lastError)))
  }

  def createFromJson = Action.async(parse.json) { request =>
    import play.api.libs.json.Reads._

    val transformer: Reads[JsObject] =
      Reads.jsPickBranch[JsString](__ \ "firstName") and
        Reads.jsPickBranch[JsString](__ \ "lastName") and
        Reads.jsPickBranch[JsNumber](__ \ "age") reduce

    request.body.transform(transformer).map { result =>
      collection.flatMap(_.insert(result)).map { lastError =>
        Logger.debug(s"Successfully inserted with LastError: $lastError")
        Created
      }
    }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def findByName(name: String) = Action.async {
    val cursor: Future[Cursor[JsObject]] = collection.map {
      _.find(Json.obj("name" -> name)).
        sort(Json.obj("created" -> -1)).
        cursor[JsObject](ReadPreference.primary)
    }

    val futurePersonsList: Future[List[JsObject]] =
      cursor.flatMap(_.collect[List]())

    val futurePersonsJsonArray: Future[JsArray] =
      futurePersonsList.map { persons => Json.arr(persons) }

    futurePersonsJsonArray.map { persons =>
      Ok(persons)
    }
  }
}
