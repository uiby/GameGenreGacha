package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject()(mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}
