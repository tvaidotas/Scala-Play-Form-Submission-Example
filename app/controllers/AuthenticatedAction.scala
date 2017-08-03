package controllers

import scala.concurrent.Future
import play.api.mvc._
import models.User

object AuthenticatedAction extends ActionBuilder[AuthenticatedRequest] {
  def invokeBlock[A](request: Request[A], block: AuthenticatedRequest[A] => Future[Result]): Future[Result] = {
    request.session.get("username")
      .flatMap(User.findByUsername(_))
      .map(user => block(new AuthenticatedRequest(user, request)))
      .getOrElse(Future.successful(Results.Forbidden))
  }
}
