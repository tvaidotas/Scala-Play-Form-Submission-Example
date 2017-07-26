package models

case class User(
 age: Int,
 firstName: String,
 lastName: String,
 feeds: List[Feed]
)

case class Feed(
 name: String,
 url: String
)

object JsonFormats {
  import play.api.libs.json.Json
  implicit val feedFormat = Json.format[Feed]
  implicit val userFormat = Json.format[User]
}