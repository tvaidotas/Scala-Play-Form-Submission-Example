package controllers

object LoggingWithAuthentication {
  val loggingWithAuthentication = LoggingAction andThen AuthenticatedAction
}
