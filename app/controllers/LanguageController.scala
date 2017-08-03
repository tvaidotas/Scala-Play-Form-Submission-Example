package controllers

import javax.inject.Inject

import play.api.i18n._
import play.api.mvc._

class LanguageController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def switchToLanguage(language: String, uri: String) = Action { implicit request =>
    Redirect(uri).withLang(Lang(language))
  }

}
