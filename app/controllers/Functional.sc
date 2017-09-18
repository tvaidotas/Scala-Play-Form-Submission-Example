import play.libs.F.Tuple

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




