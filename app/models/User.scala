package models

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class LoginDetails(password: String, field3: Option[Int], field4: String)
case class User(username: String, loginDetails: LoginDetails)

object User {

  // custom mapping example, will add more comments later on
  val oldForm = Form(
    mapping(
      "username" -> email,
      "password" -> text,
      "field3" -> optional(number)
    )(
      (username, password, field3) =>
        User(username, LoginDetails(password, field3, (10 + 16).toString))
    )(
      (user: User) =>
        Option(user.username, user.loginDetails.password, user.loginDetails.field3)
    )
  )


  def findByUsername(username: String) = {
      userList.find( user => user.username == username)
  }

  val userList = ArrayBuffer(
    User("Jack", LoginDetails("Password", Some(2), "asas"))
  )

}
