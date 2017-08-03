package controllers

import play.api.mvc.{Request, WrappedRequest}
import models.User

class AuthenticatedRequest[A](val user: User, val request: Request[A]) extends WrappedRequest[A](request)
