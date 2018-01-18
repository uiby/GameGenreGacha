package controllers

import models._
import services._
import play.api.libs.json._
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.mvc.RequestHeader
import play.api.routing._

import play.api.data._
import play.api.data.Form
import play.api.data.Forms._

import play.filters.csrf.CSRF


@Singleton
class GachaController @Inject()(gachaService: GachaService, mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {
  implicit val JenreWrites = new Writes[Jenres] {
    def writes(jenres: Jenres) = Json.obj(
      "id" -> jenres.id.toString,
      "name" -> jenres.name,
      "sentence" -> jenres.sentence,
    )
  }
  def list = Action { implicit request: Request[AnyContent] =>
    val items: Seq[Jenres] = gachaService.list
    Ok(views.html.list(items))
  }

  case class ResultJenres(jenreList: Seq[Jenres])
  def pickup = Action {implicit request: MessagesRequest[AnyContent] =>
    val item = gachaService.pickupByRandom
    implicit val ResultJenreWrites = new Writes[ResultJenres] {
      def writes(resultJenre: ResultJenres) = Json.obj(
        "result" -> resultJenre.jenreList
        )
    }

    val jsonObject = Json.toJson(ResultJenres(item))
    Ok(jsonObject)
  }

  def javascriptRoutes = Action {implicit request: MessagesRequest[AnyContent] =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.GachaController.pickup,
        )
      ).as("text/javascript")
  }

}
