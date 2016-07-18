package controllers

import javax.inject.Inject
import play.api.mvc._
import play.api.i18n.I18nSupport 
import play.api.i18n.MessagesApi
import play.api.data.Forms._
import play.api.data._
import model._




class PageController @Inject()(val messagesApi:MessagesApi) extends Controller with I18nSupport{
  
   private val inputForm =Form[Input](mapping("input1" -> nonEmptyText,
                                                    "input2" -> nonEmptyText,
                                                            "input3" -> longNumber)(Input.apply)(Input.unapply)
                                                            ) 
                                                            
    
  def firstPage= Action{
    implicit request =>
      Ok(views.html.page1())
  }
  def inputPage = Action{
    implicit request =>
      val form= inputForm
      Ok(views.html.inputPage(form))
  }
  def input =Action {
    implicit request =>
   
      inputForm.bindFromRequest().fold(formWithErrors=>Redirect(routes.PageController.inputPage()),value=> Ok(views.html.show(value) ))
  }
  
  def uploadPage =Action{
    implicit request =>
      Ok(views.html.uploadPage())
  }

 
  
}