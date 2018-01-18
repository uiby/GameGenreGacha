package controllers

import models._
import services._
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.mvc.RequestHeader
import play.api.data._
import play.api.data.Forms._


@Singleton
class GachaController @Inject()(gachaService: GachaService, mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def list() = Action { implicit request: Request[AnyContent] =>
    val items: Seq[Jenres] = gachaService.list()
    Ok(views.html.list(items))
  }
}
