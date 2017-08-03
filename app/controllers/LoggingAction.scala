package controllers

import play.api.mvc._
import play.api.Logger

import scala.concurrent.Future

object LoggingAction extends ActionBuilder[Request] {
  def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    Logger.info("Calling action")
    block(request)
  }
}


