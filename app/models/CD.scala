package models

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class CD(name: String, price: Int)

object CD {

  val createCDForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> number(min = 0, max = 100)
    )(CD.apply)(CD.unapply)
  )

  val cds = ArrayBuffer(
    CD("CD 1", 123),
    CD("CD 2", 456),
    CD("CD 3", 789)
  )

}