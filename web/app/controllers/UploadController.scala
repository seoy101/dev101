package controllers

import javax.inject.Inject
import play.api.mvc._
import play.api.i18n.I18nSupport 
import play.api.i18n.MessagesApi


class UploadController @Inject() (val messagesApi:MessagesApi) extends Controller with I18nSupport{
    def uploadFile =Action{
      Ok("sdafasdf")
    }
}