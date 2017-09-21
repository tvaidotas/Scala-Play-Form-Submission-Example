import play.libs.F.Tuple

import scala.collection.mutable.ArrayBuffer
import scala.util.control.TailCalls.TailRec

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

/**
// we can seperate the arguments a function expects into groups
def totalPrice(qountity: Int)(discount: Double)(beerType: String) = {
  val price = 3.5
  price * qountity - discount
}

println(s"The final price is: ${totalPrice(7)(2.25)("Guinness")}") // will be evaluated to -> The final price is: 22.25
**/

// TODO - 18 code example from collections

/**
def totalPrice(qountity: Int)(discount: Double)(beerType: String) = {
  val price = 3.5
  price * qountity - discount
}

// creating a partially applied function where we pass only the first argument
val stella = totalPrice(9) _

// we pass the rest of the parameters the function is expecting
stella(0.1)("Stella") // will be evaluated to -> 31.4
**/

// TODO - 19 code example from collections

/**
var militaryAge = 16
val isOfMilitaryAge = (age: Int) => age >= militaryAge

// we call the function with the age argument
isOfMilitaryAge(14) // will be evaluated to -> false
isOfMilitaryAge(19) // will be evaluated to -> true

// a function that takes in a function as an argument for the first expected argumentm and the age for the second expected argument
def printResult(function: Int => Boolean, age: Int): Unit = {
  println(s"The person is above the military age of $militaryAge, " + function(age)) // we pass the age as an argument to the function that was passed and get the result of it
}

// we pass a function as an argument and a value of age
printResult(isOfMilitaryAge, 15) // will be evaluated to -> The person is above the military age of 16, false

// change the militaryAge threshold in the scope
militaryAge = 18

// the change of the militaryAge threshold affects the results
printResult(isOfMilitaryAge, 19) // will be evaluated to -> The person is above the military age of 18, true
// the value which is needed by the function is entangled with it, therefore the value reasignment will affect the results of the function
**/

// TODO - 20 code example from collections

/**
// we create a list with elements from one to ten
val oneToTen = List.range(1, 10)

// (i: Int) = i % 2 == 0
// the code above is known as annonymous function or a function literal

// we assign all even number to variable evenNumbers by applying the filter function which will leave only those elements in the list that satisfy the condition
val evenNumbers = oneToTen.filter( (i: Int) => i % 2 == 0) // will be evaluated to -> List(2, 4, 6, 8)
**/

// TODO - 21 code example from collections

/**
var multiply = (x: Int, y: Int) => x * y
multiply(2, 20) // will be evaluated as -> 40
multiply(11, 11) // will be evaluated as -> 121
**/

// TODO - 22 code example from collections

/**
// discount now is a function that takes in a Double and returns a Double
def totalPrice(qountity: Int)(beerType: String)(discount: Double => Double) = {
  val price = 3.5
  discount(price * qountity)
}

// passing an annonymous function as an argument
println(s"The final price is: ${totalPrice(7)("Guinness")(
  totalCost => {
    val discount = 1.25
    totalCost - discount
  }
)}") // will be evaluated to -> The final price is: 23.25
**/

// TODO - 23 code example from collections

/**
// discount now is a function that takes in a Double and returns a Double
def totalPrice(qountity: Int)(beerType: String)(discount: Double => Double) = {
  val price = 3.5
  discount(price * qountity)
}

val applyDiscount = (totalCost: Double) => {
  val discount = 0.1
  totalCost - totalCost * discount
}

// passing a named function as an argument and use the underscore to act as a wildcard which allows to pass any number
println(s"The final price is: ${totalPrice(10)("Guinness")(applyDiscount(_))}") // will be evaluated to -> The final price is: 31.5
**/

// TODO - 24 code example from collections

/**
// an example list of Tuples with 3 elements
val beerList = List(
  ("Guinness", 10, 2.75),
  ("Stella", 5, 2.46),
  ("Fosters", 15, 2.0)
)

// a curried function that takes in a list of beers and for the second group of arguments a double as an exchange rate
def placeDrinkOrder(items: List[(String, Int, Double)])(exchangeRate: Double): Double = {
  var totalCost: Double = 0
  items.foreach( item => {
    val itemCost = item._2 * item._3 * exchangeRate
    println(f"The price for ${item._1} is £$itemCost%5.2f")
    totalCost += itemCost
  })
  totalCost
}

// running our implementation
println(f"Your order comes to: £${placeDrinkOrder(beerList)(1.06)}%5.2f")
// will be evaluated to:
// The price for Guinness is £29.15
// The price for Stella is £13.04
// The price for Fosters is £31.80
// Your order comes to: £73.99

**/

// TODO - 25 code example from collections

/**
import scala.util.Random

// an example list of Tuples with 3 elements
val beerList = List(
  ("Guinness", 10, 2.75),
  ("Stella", 5, 2.46),
  ("Fosters", 15, 2.0)
)

val randomRate = new Random(10)

def usdToGbp: Double = {
  val exchangeRate = randomRate.nextDouble()
  println(s"The exchange rate for USD to GBP is: $exchangeRate")
  exchangeRate
}

// a curried function that takes in a list of beers and for the second group of arguments a double as an exchange rate
def placeDrinkOrder(items: List[(String, Int, Double)])(exchangeRate: Double): Double = {
  var totalCost: Double = 0
  items.foreach( item => {
    val itemCost = item._2 * item._3 * exchangeRate
    println(f"The price for ${item._1} is £$itemCost%5.2f")
    totalCost += itemCost
  })
  totalCost
}

// running our implementation
println(f"Your order comes to: £${placeDrinkOrder(beerList)(1.06)}%5.2f")
// will be evaluated to different amount each time due to the exchange rate being random:
// The price for Guinness is £29.15
// The price for Stella is £13.04
// The price for Fosters is £31.80
// Your order comes to: £73.99

**/

// TODO - 26 code example from collections

/**
// discount now is a function that takes in a Double and returns a Double
def totalPrice(qountity: Int)(beerType: String)(discount: Double => Double) = {
  val price = 3.5
  discount(price * qountity)
}

val applyDiscount = (totalCost: Double) => {
  val discount = 0.1
  totalCost - totalCost * discount
}

// passing a named function as an argument and use the underscore to act as a wildcard which allows to pass any number
println(f"The final price is: ${totalPrice(10)("Guinness")(applyDiscount(_))}%5.2") // will be evaluated to -> The final price is: 31.5
**/

// TODO - 27 code example from collections

/**
// defining a function that takes a callback parameter
def printReceit(sendReceitCallBack: () => Unit): Unit = {
  println("Starting printing")
  // assume that we print out all the merchandise data on it here
  println("Ending printing")
  sendReceitCallBack()
}

// calling the function
printReceit( () => {
  println("Finished printing")
}) // would be evaluated to:

// Starting printing
// Ending printing
// Finished printing

**/

// TODO - 28 code example from collections

/**
// defining a function that takes a callback parameter
def printReceit(sendReceitCallBack: () => Unit): Unit = {
  println("Starting printing")
  // assume that we print out all the merchandise data on it here
  println("Ending printing")
  sendReceitCallBack()
}

printReceit( () => {}) // calling the function and passing an annonymous function that does nothing will evaluate to ->
// Starting printing
// Ending printing

// not passing a function that is of Unit type will result in the code not compiling
printReceit() // would result in an error
**/

// TODO - 29 code example from collections

/**
// defining a function that takes a callback parameter
def printReceit(sendReceitCallBack: Option[() => Unit] = None): Unit = {
  println("Starting printing")
  // assume that we print out all the merchandise data on it here
  println("Ending printing")
  sendReceitCallBack map (callback => callback)
}

printReceit( Some(() => {})) // calling the function and passing an optional annonymous function that does nothing will evaluate to ->
// Starting printing
// Ending printing

printReceit() // not passing a function that is of optional Unit type will now be evaluated to ->
// Starting printing
// Ending printing
**/

// TODO - 30 code example from collections

/**
import scala.util.Random

def randomInt = Random.nextInt()

println(randomInt) // will be evaluated to a new value each time like: -1503480485
println(randomInt) // will be evaluated to a new value each time like: 1295895529
println(randomInt) // will be evaluated to a new value each time like: -951915374

val randomDouble = Random.nextDouble()

println(randomDouble) // will be evaluate to the same value each time like : 0.05763428656827829
println(randomDouble) // will be evaluate to the same value each time like : 0.05763428656827829
println(randomDouble) // will be evaluate to the same value each time like : 0.05763428656827829

lazy val randomLazyLong = Random.nextLong()

println(randomLazyLong) // will be evaluated on the first call and then the value won't change like: 1686381307780112820
println(randomLazyLong) // will be evaluated on the first call and then the value won't change like: 1686381307780112820
println(randomLazyLong) // will be evaluated on the first call and then the value won't change like: 1686381307780112820
**/

// TODO - 31 code example from collections

/**
// a fake total cost of shopping
val totalCost = 10.58

// a function that takes a double and then returns a double
val applyDiscount = (amount: Double) => {
  println("Applying discount")
  val discount = 0.1
  amount - amount * discount
}
// a function that takes a double and then returns a double
val applyTax = (amount: Double) => {
  println("Applying Tax")
  val tax = 0.2
  amount + amount * tax
}

println(f"The total after tax is ${(applyDiscount andThen applyTax)(totalCost)}%5.2f") // would be evaluated to ->
// Applying discount
// Applying Tax
// The total after tax is 11.43
**/

// TODO - 32 code example from collections

/**
// a fake total cost of shopping
val totalCost = 10.58

// a function that takes a double and then returns a double
val applyDiscount = (amount: Double) => {
  println("Applying discount")
  val discount = 0.1
  amount - amount * discount
}
// a function that takes a double and then returns a double
val applyTax = (amount: Double) => {
  println("Applying Tax")
  val tax = 0.2
  amount + amount * tax
}

println(f"The total after tax is ${(applyTax compose applyDiscount)(totalCost)}%5.2f") // would be evaluated to ->
// Applying discount
// Applying Tax
// The total after tax is 11.43
**/

// TODO - 33 code example from collections

/**
val arrayOfBeers = Array("Guinness", "Stella", "Fosters", "Corona")

// TODO - WHEN PUTTING THIS EXAMPLE INTO THE HANDOUT THE LINE ABOVE SHOULD NOT HAVE THE TWO FORWARD SLASHED IN FRONT
//@annotation.tailrec
def searchBeer(beername: String, beers: Array[String], index: Int = 0): Option[Boolean] = {
  if (beers.length == index) { // check to see if we reached the end of the list
    None
  } else if (beers(index) == beername) { // check if the value stored at this index is the one we're looking for
    Some(true)
  } else {
    val nextIndex = index + 1 // increment the index by one
    searchBeer(beername, beers, nextIndex) // the function calls itself with an incremented index
  }
}

// initial call to the function
searchBeer("Fosters", arrayOfBeers).getOrElse("Nothing found") // will be evaluated to -> true
searchBeer("Desperados", arrayOfBeers).getOrElse("Nothing found") // will be evaluated to -> Nothing found
**/

// TODO - 34 code example from collections

/**
import scala.util.control.TailCalls._

val arrayOfBeers = Array("Guinness", "Stella", "Fosters", "Corona")

def searchBeer(beername: String, beers: Array[String], index: Int = 0): TailRec[Option[Boolean]] = {
  if (beers.length == index) { // check to see if we reached the end of the list
    done(None)
  } else if (beers(index) == beername) { // check if the value stored at this index is the one we're looking for
    done(Some(true))
  } else {
    val nextIndex = index + 1 // increment the index by one
    tailcall(searchBeer(beername, beers, nextIndex)) // the function calls itself with an incremented index
  }
}

// initial call to the function
searchBeer("Fosters", arrayOfBeers).result.getOrElse("Nothing found") // will be evaluated to -> true
searchBeer("Desperados", arrayOfBeers).result.getOrElse("Nothing found") // will be evaluated to -> Nothing found
**/

// TODO - 35 code example from collections

/**
val beerList = List("Guinness", "Stella", "Fosters", "Corona")

def checkBeerAvailability(beerName: String): Boolean = {
  beerName.nonEmpty && beerList.contains(beerName) // we check that the beerlist we're using isn't empty and that it contains the beer we're looking for
}

checkBeerAvailability("Fosters") // will be evaluated to -> true
checkBeerAvailability("Desperados") // will be evaluated to -> false
**/

// TODO - 36 code example from collections

/**
val beerList = List("Guinness", "Stella", "Fosters", "Corona")

def checkBeerAvailability(beerName: String): Boolean = {

  val validateName = (beerName: String) => beerName.nonEmpty && beerName.length < 50

  validateName(beerName) && beerList.contains(beerName) // we check that the beerlist we're using isn't empty and that it contains the beer we're looking for
}

checkBeerAvailability("Fosters") // will be evaluated to -> true
checkBeerAvailability("Desperados") // will be evaluated to -> false
**/

// TODO - 37 code example from collections

/**
val fizzBuzz: (Int) => Unit = (i) => {
  if (i % 3 == 0 && i % 5 == 0)
    println("FizzBuzz")
  else if (i % 3 == 0)
    println("Fizz")
  else if (i % 5 == 0)
    println("Buzz")
  else
    println(i)
}

for (i <- 1 to 15) fizzBuzz(i) // would be evaluated to:
//1
//2
//Fizz
//4
//Buzz
//Fizz
//7
//8
//Fizz
//Buzz
//11
//Fizz
//13
//14
//FizzBuzz
**/

// TODO - 38 code example from collections

/**
// a function that will chech if the number modulus another number will be equal to 0
val modulusCheck: (Int, Int) => Boolean = (num, mod) => num % mod == 0

// a function that checks if the number modulus 3 is equal to 0
val modulus3Check: (Int) => Boolean = modulusCheck(_, 3)

// a function that checks if the number modulus 5 is equal to 0
val modulus5Check: (Int) => Boolean = modulusCheck(_, 5)

// a function that for a given number checks what to print based on the pattern matching conditions
val fizzBuzz: Int => Unit = {
  case number if modulus3Check(number) && modulus5Check(number) => println("FizzBuzz")
  case number if modulus3Check(number) => println("FizzBuzz")
  case number if modulus5Check(number) => println("FizzBuzz")
  case number  => println(number)
}

for (i <- 1 to 15) fizzBuzz(i) // would be evaluated to:
//1
//2
//FizzBuzz
//4
//FizzBuzz
//FizzBuzz
//7
//8
//FizzBuzz
//FizzBuzz
//11
//FizzBuzz
//13
//14
//FizzBuzz
**/

// TODO - 39 code example from collections

/**
sealed abstract class FizzBuzzADT(i: Int) {
  override def toString: String = i.toString
}

case class Fizz(i: Int) extends FizzBuzzADT(i){
  override def toString: String = "Fizz"
}

case class Buzz(i: Int) extends FizzBuzzADT(i){
  override def toString: String = "Buzz"
}

case class FizzBuzz(i: Int) extends FizzBuzzADT(i){
  override def toString: String = "FizzBuzz"
}

case class JustInt(i: Int) extends FizzBuzzADT(i)
**/

// TODO - 40 code example from collections

/**
sealed abstract class FizzBuzzADT(i: Int) {
  override def toString: String = i.toString
}

case class Fizz(i: Int) extends FizzBuzzADT(i){
  override def toString: String = "Fizz"
}

case class Buzz(i: Int) extends FizzBuzzADT(i){
  override def toString: String = "Buzz"
}

case class FizzBuzz(i: Int) extends FizzBuzzADT(i){
  override def toString: String = "FizzBuzz"
}

case class JustInt(i: Int) extends FizzBuzzADT(i)

// a function that will chech if the number modulus another number will be equal to 0
val modulusCheck: (Int, Int) => Boolean = (num, mod) => num % mod == 0

// a function that checks if the number modulus 3 is equal to 0
val modulus3Check: (Int) => Boolean = modulusCheck(_, 3)

// a function that checks if the number modulus 5 is equal to 0
val modulus5Check: (Int) => Boolean = modulusCheck(_, 5)

// companion object that implements the apply method and using pattern matching then return an appropriate object
object FizzBuzzADT {
  def apply(i: Int): FizzBuzzADT = i match {
    case _ if modulus3Check(i) && modulus5Check(i) => FizzBuzz(i)
    case _ if modulus3Check(i) => Fizz(i)
    case _ if modulus5Check(i) => Buzz(i)
    case _ => JustInt(i)
  }
}

var numbers = 1 to 15 // creating a list of numbers to use

// using the map function to go over the list of number where by creating the FizzBuzzADT the apply method will be returning the appropriate object created
val fizzBuzzed = numbers map ( number => FizzBuzzADT(number)) // fizzBuzzed will be now equal to -> Vector(1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz)

**/

// TODO - 41 code example from collections

/**
// a function to check if the number is less than 35
def lessThan35(i: Int): Boolean = {
  println(s"$i less than 35?")
  i < 35
}

// a function to check if the number is more than 25
def moreThan25(i: Int): Boolean = {
  println(s"$i more than 25?")
  i > 25
}

// sample list
val sampleList = List(3, 29, 45, 32, 21)
val firstFilterList = sampleList.withFilter(lessThan35) // first time applying the filter to the list
val secondFilterList = firstFilterList.withFilter(moreThan25) // second time applying the filter to the list that already had the first filter applied

// going through the collection after the two filters were applied
secondFilterList.foreach(println(_))
**/

// TODO - 42 code example from collections

// TODO - THIS IS JUST SOME PLAIN TEXT THAT DOESN'T NEED COLOURING
/**
3 less than 35?
3 more than 25?

29 less than 35?
29 more than 25?
29

45 less than 35?

32 less than 35?
32 more than 25?
32

21 less than 35?
21 more than 25?
**/

// TODO - 43 code example from collections

/**
// a function to check if the number is less than 35
def lessThan35(i: Int): Boolean = {
  println(s"$i less than 35?")
  i < 35
}

// a function to check if the number is more than 25
def moreThan25(i: Int): Boolean = {
  println(s"$i more than 25?")
  i > 25
}

// sample list
val sampleList = List(3, 29, 45, 32, 21)
val firstFilterList = sampleList.filter(lessThan35) // first time applying the filter to the list
val secondFilterList = firstFilterList.filter(moreThan25) // second time applying the filter to the list that already had the first filter applied

// going through the collection after the two filters were applied
secondFilterList.foreach(println(_))
**/

// TODO - 44 code example from collections

// TODO - THIS IS JUST SOME PLAIN TEXT THAT DOESN'T NEED COLOURING

/**
3 less than 35?
29 less than 35?
45 less than 35?
32 less than 35?
21 less than 35?
firstFilterList: List[Int] = List(3, 29, 32, 21)
3 more than 25?
29 more than 25?
32 more than 25?
21 more than 25?
secondFilterList: List[Int] = List(29, 32)


29
32
**/

// TODO - 45 code example from collections
