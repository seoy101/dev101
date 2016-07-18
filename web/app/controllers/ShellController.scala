package controllers

import javax.inject.Inject
import play.api.mvc._
import play.api.i18n.I18nSupport 
import play.api.i18n.MessagesApi
import scala.sys.process._
import scala.io.Source



class ShellController @Inject() (val messagesApi:MessagesApi) extends Controller with I18nSupport{
   
  def shell(input1:String) = Action{
    implicit request =>
      //val cmd ="hello.sh asdfavadf"
      val cmd =Seq("hello.sh", input1)
      val output= Process(cmd).lines
      
       Ok(views.html.shell(output))
  }
  
}