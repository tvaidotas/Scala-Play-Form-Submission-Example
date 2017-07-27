package models

case class User(
 age: Int,
 firstName: String,
 lastName: String,
 feeds: Seq[Feed]
)

case class Feed(
 name: String,
 url: String
)

object JsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val feedFormat = Json.format[Feed]
  implicit val userFormat = Json.format[User]
}
