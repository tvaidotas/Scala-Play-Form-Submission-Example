import play.libs.F.Tuple

import scala.collection.mutable.ArrayBuffer

/***
def favouriteBeer(): String = "Guinness"
println(s"My favourite beer is ${favouriteBeer()}") // will be evaluated to -> My favourite beer is Guinness

def favouriteJuice() = "Apple" // type inference infers the return type
println(s"My favourite juice is ${favouriteJuice()}") // will be evaluated to -> My favourite juice is Apple
***/

// TODO - 1 code example from collections

/***
def priceOfGuinness(qountity: Int): Double = qountity * 3.5
println(s"Three pints of Guinness will be ${priceOfGuinness(3)}") // will be evaluated to -> Three pints of Guinness will be 10.5

def priceOfOrangeJuice(qountity: Int = 0): Double = qountity * 2.5
println(s"One glass of orange juice will be ${priceOfOrangeJuice(1)}") // will be evaluated to -> One glass of orange juice will be 2.5
println(s"No glasses of orange juice will be ${priceOfOrangeJuice()}") // will be evaluated to -> No glasses of orange juice will be 0.0
***/

// TODO - 2 code example from collections

/***
def favouriteBeerPrice(qountity: Int, discountCode: Option[String]): Double = {
  discountCode match {
    case Some(discount) => (qountity * 3.5) * 0.9
    case None => qountity * 3.5
  }
}
println(s"Five pints of Guinness with discount code will be ${favouriteBeerPrice(5, Some("Buy 5 pints get 10% off"))}") // will be evaluated to -> Five pints of Guinness with discount code will be 15.75
println(s"Three pints of Guinness without the discount code will be ${favouriteBeerPrice(3, None)}") // will be evaluated to -> Three pints of Guinness without the discount code will be 10.5
***/

// TODO - 3 code example from collections

/***
def favouriteBeerPrice(qountity: Int, discountCode: Option[String] = None): Double = {
  discountCode match {
    case Some(discount) => (qountity * 3.5) * 0.9
    case None => qountity * 3.5
  }
}
println(s"Five pints of Guinness with discount code will be ${favouriteBeerPrice(5, Some("Buy 5 pints get 10% off"))}") // will be evaluated to -> Five pints of Guinness with discount code will be 15.75
println(s"Three pints of Guinness without the discount code will be ${favouriteBeerPrice(3)}") // now we don't need to pass a second value if we don't want to so will be evaluated to -> Three pints of Guinness without the discount code will be 10.5
***/

// TODO - 4 code example from collections

/***
def dailyCoupon(): Option[String] = {
  Some("Coupon value that we retrieved from DB")
}

println(s"The coupon for today is ${dailyCoupon().get}") // will be evaluated to -> The coupon for today is Coupon value that we retrieved from DB
***/

// TODO - 5 code example from collections

/***
def dailyCoupon(): Option[String] = {
  Some("Coupon value that we retrieved from DB")
}

// we use getOrElse and provide a default value if there wouldn't be one for us to use
println(s"The coupon for today is ${dailyCoupon().getOrElse("There are no coupons for today")}") // will be evaluated to -> The coupon for today is Coupon value that we retrieved from DB

// another way to deal with optionals is to use map function which is going to ignore non existent values
dailyCoupon() map {value => s"The coupon for today is $value"}

// another way to deal with optionals is to use pattern matching
dailyCoupon() match {
  case Some(value) => println(s"The coupon for today is $value")
  case None => println("There are no coupons for today")
}
***/

// TODO - 7 code example from collections

/***
// Tuples can hold values of different types
val tuple = ('a', "b", 3, 4.56)

// to access the members of the tuples you need to use the notation _.nth member of the tuple, starting from 1 and not from 0
tuple._1 // will be evaluated to -> a
tuple._2 // will be evaluated to -> b
tuple._3 // will be evaluated to -> 3
tuple._4 // will be evaluated to -> 4.56
***/

// TODO - 8 code example from collections

/***
val tuple = ('a', "b", 3, 4.56)

// this example would print each value of the tuple on the new line
tuple.productIterator.foreach(value => println(value))
***/

// TODO - 9 code example from collections

/***
val tuple = ('a', "b", 3)
val longerTuple = ('a', "b", 3, 4.56)

def matchTuple(tuple: Any): Unit = tuple match {
  case (a, b, c) => println(s"We got a tuple with three elements: $a $b $c")
  case (a, b, c, d) => println(s"We got a tuple with three elements: $a $b $c $d")
  case _ => println("Unrecognised tuple")
}

matchTuple(tuple) // will be evaluated to -> We got a tuple with three elements: a b 3
matchTuple(longerTuple) // will be evaluated to -> We got a tuple with three elements: a b 3 4.56
matchTuple(5) // will be evaluated to -> Unrecognised tuple
***/

// TODO - 10 code example from collections

/**
implicit val discount: Double = 0.1 // implicit values can be defined anywhere in the code base

def totalPrice(qountity: Int, price: Double)(implicit discount: Double): Double = qountity * price * ( 1 - discount )

totalPrice(10, 3.5) // we can call the function with the first set of arguments and the discount value will be picked up
// as the implicit value we defined somewhere in the code base therefore this will be evaluated to -> 31.5

totalPrice(10, 3.5)(0.5) // if we want to pass a discount value explicitly instead of using the implicit value we can
// pass it directly therefore this will be evaluated to -> 17.5
**/

// TODO - 11 code example from collections

/**
case class Beer (beerName: String, price: Double, productCode: Option[Long])

object BeerImplicits {
  implicit class ImprovingBeer(beer: Beer) {
    def uuid: String = {
      s"Name: ${beer.beerName}, price: ${beer.price}, code: ${beer.productCode.getOrElse("no code found")}"
    }
  }
}

import BeerImplicits._
val guinness: String = Beer("Guinness", 2.5, None).uuid
val stella: String = Beer("Stella", 2.5, Some(321)).uuid

println(guinness) // will be evaluated to -> Name: Guinness, price: 2.5, code: no code found
println(stella) // will be evaluated to -> Name: Stella, price: 2.5, code: 321
**/

// TODO - 12 code example from collections

/**
def applyDiscount(discount: String): Unit = println(s"You will receive the discount of $discount")

def applyDiscount(discount: Double): Unit = println(s"You will receive the discount of $discount")

applyDiscount("0.5") // will be evaluated to -> You will receive the discount of 0.5
applyDiscount(0.5) // will be evaluated to -> You will receive the discount of 0.5
**/

// TODO - 13 code example from collections

/**
def applyDiscount[T](discount: T): Unit = {
    discount match {
      case disc: String => println(s"You will receive the discount of $discount")
      case disc: Double => println(s"You will receive the discount of $discount")
      case _ => println(s"Unrecognised discount")
    }
}

applyDiscount("10%") // will be evaluated to -> You will receive the discount of 10%
applyDiscount(0.1) // will be evaluated to -> You will receive the discount of 0.1
applyDiscount(10) // will be evaluated to -> Unrecognised discount
**/

// TODO - 14 code example from collections

/**
def applyDiscount[T](discount: T): List[T] = {
  discount match {
    case disc: String => List[T](discount)
    case disc: Double => List[T](discount)
    case _ => List[T](discount)
  }
}

applyDiscount("10%") // will be evaluated to -> List(10%)
applyDiscount(0.1) // will be evaluated to -> List(0.1)
applyDiscount(10) // will be evaluated to -> List(10)
**/

// TODO - 15 code example from collections

/**
// by adding the * symbol next to the type of the argument, we can now pass more than one value
def giveListBack[T](items: T*): Unit = items.foreach(print(_))
giveListBack("H", 3, "ll", 'o') // will be evaluated to -> H3llo
**/

// TODO - 16 code example from collections

/**
class BeerPrice{
  val price: Double = 3.5
  def substractFromPrice(discount: Double) = price - price * discount
}

val beerPrice = new BeerPrice
println(f"Your total after the discount comes to: ${beerPrice.substractFromPrice(0.1)}") // will be evaluated to -> Your total after the discount comes to: 3.15
**/

// TODO - 17 code example from collections

/**
class BeerPrice{
  val price: Double = 3.5
  def -(discount: Double) = price - price * discount
}

val beerPrice = new BeerPrice
println(f"Your total after the discount comes to: ${beerPrice - 0.1}") // will be evaluated to -> Your total after the discount comes to: 3.15
**/

// TODO - 17 code example from collections








