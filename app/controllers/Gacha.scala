package services
import models._
import javax.inject.Inject
import org.joda.time.{DateTime, DateTimeZone}

import anorm.SqlParser._ //parser API select結果をパース
import anorm._
import play.api.db.DBApi

import scala.language.postfixOps


@javax.inject.Singleton
class GachaService @Inject() (dbapi: DBApi) {
  private val db = dbapi.database("default");

  var JenresMapper = {
    get[BigInt]("jenres.id")~
    get[String]("jenres.name")~
    get[String]("jenres.sentence") map {
      case id ~ name ~ sentence => Jenres(id, name, sentence)
    }
  }

  def list(): Seq[Jenres] = {
    db.withConnection { implicit connection =>
      SQL("""SELECT * FROM jenres""").as(JenresMapper *)
    }
  }
}