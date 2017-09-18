/***
// an example function
def welcomeUser(name:String): Unit = println("Hello " + name)
welcomeUser("John") // here we're calling our example function welcomeUser and pass the name as an argument
// will print out
// Hello John

// another example function
def isEven(number: Int): Boolean =
  if (number % 2 == 0)
    true
  else
    false

isEven(2) // calling the function will return true
isEven(3) // calling the function will return false
***/

// TODO - first code example from introduction
/***
class Person(var name: String, var age: Int)

object Main extends App {

    def showEvaluationOnCall() : Unit = {
        def person = new Person("John", 36)

        // we evaluate the value when we call the method
        // this example will print out -> Persons age is: 36
        println("Persons age is: " + person.age)

        // we reasign the value of the persons age
        person.age = 32

        // and then we call the method to get the persons age again
        // this example will print out -> Persons age is: 36
        // the age doesn't change because every time we try to get the age
        // we re-evaluate it, meaning that it will one again be 36
        println("Persons age is: " + person.age)

    }

    showEvaluationOnCall()

}
***/

// TODO - second code example from introduction
/***
class Person(var name: String, var age: Int)

object Main extends App {

    def showEvaluationOnDefine() : Unit = {
        val person = new Person("John", 36)

        // the value is evaluated on the definition therefore even without us calling it first
        // it will automatically have that value assigned to the variable
        // this example will print out -> Persons age is: 36
        println("Persons age is: " + person.age)

        // we reasign the value of the persons age
        person.age = 32

        // and then we call the val to get the persons age again
        // this example will print out -> Persons age is: 32
        // the age change because we're able to reassign the value of persons age
        println("Persons age is: " + person.age)

    }

    showEvaluationOnDefine()

}
***/
// TODO - third code example from introduction

/*
 * This is an example of a multiline comment
 */

// this is a single line comment

// TODO - fourth code example from introduction

/***

def main(args: Array[String]): Unit = {

}

***/

// TODO - fifth code example from introduction

/***
1 == 1 // is evaluated to -> true
1 != 2 // is evaluated to -> true

// works with objects
List(1,2,3) == List(1,2,3) // is evaluated to -> true
List(1,2,3) == List(4,5,6) // is evaluated to -> false

// works with different data types
1 == 1.0 // even though one is of type Int and the other is of type Double it's evaluated to -> true
List(1,2,3) == "Hello" // as it's different values and types the expression is evaluated to -> false

// can compare against null
List(1,2,3) == null // is evaluated to -> true
List(1,2,3) != null // is evaluated to -> false
***/

// TODO - sixth code example from introduction

/***
val x = new String("abc")
val y = new String("abc")

x == y // the values are equal therefore expression is evaluated to -> true
x eq y // the references are not equal therefore expression is evaluated to -> false
x ne y // the references are not equal therefore expression is evaluated to -> true

val list1 = List(1,2,3)
val list2 = list1
val list3 = List(1,2,3)

list1 == list2 // is evaluated to -> true
list1 eq list2 // is evaluated to -> true
list1 ne list2 // is evaluated to -> false

list2 == list3 // is evaluated to -> true
list2 eq list3 // is evaluated to -> false
list2 ne list3 // is evaluated to -> true
***/

// TODO - seventh code example from introduction

/***
var day = "Friday"
if ("Friday" == day){
    println("Yay it's Friday")
}

val whatDayItIs = if (!day.isEmpty) day // Check that the variable is not empty and if so return its value
println(whatDayItIs) // will print out -> Friday


// another example using if, else if, else

if (day.isEmpty){ // check that the value is not there and then execute code block
    println("Unable to figure out what day it is...")
} else if ("Friday" == day) {
    // the value will be there at this point as we made a check whether it's empty or not before
    println("Yay it's Friday")
} else {
    // lastly if the first two checks are not evaluated to true then this code block will be invoked
    println("It's still not Friday...")
}
***/

// TODO - eighth code example from introduction

/***
def myFullName(firstName: String = "", lastName: String = ""): Unit = {
    if (!firstName.isEmpty && !lastName.isEmpty) {
        println(firstName + " " + lastName)
    } else if (!firstName.isEmpty) {
        println(firstName)
    } else {
        println(lastName)
    }
}
myFullName("John") // will print out John as the value we are passing will be considered to be the firstName and for the
// last name the value will be taken as empty string by default if no value is passed
myFullName("John", "Smith") // will print out John Smith as we're passing both values that are expected
myFullName(lastName = "Smith", firstName = "John") // will print out John Smith as we passed the values by name and not by order
***/

// TODO - ninth code example from introduction

/***
package p1 {
    class A
}
object B {
    val x = new p1.A
    import p1.A
    val y = new A
}
***/

// TODO - tenth code example from introduction

/***
val mediumRareSteak: Option[String] = Some("tasty")
println(s"Medium-Rare steak tastes ${mediumRareSteak.get}")
// we're trying to get the value without checking if it exists, therefore we're producing so called code smell, this example will work and will print out the statement with the word "tasty" inserted into it

val rareSteak: Option[String] = None
println(s"Rare steak tastes ${rareSteak.get}")
// in this example we're trying to get an element which is not there, therefore we would get a NoSuchElementException

val mediumSteak: Option[String] = Some("tasty")
println(s"Medium steak tastes ${mediumRareSteak.getOrElse("nice")}")
// this is a safer way to access optional values, where we try to get the value, but if it's not there we provide a default value to be used

mediumRareSteak match {
    case None => println("No value found")
    case Some(value) => println(s"The value found is: $value")
}
// we can also do pattern matching like this example to deal with optionals
***/

// TODO - eleventh code example from introduction

/***
// by default the number for both to and until will be incremented by 1

// by using the keyword to the upper bound of the number is included in the loop
for (i <- 1 to 10 by 2) println(i) // will print every second number starting from 1 and up to 10
for (i <- 10 to 1 by -1 ) println(i) // will print every member from 10 to 1

// by using the keyword until the upper bound of the number is not included in the loop
for (i <- 1 until 10 by 2) println(i) // will print every second number starting from 1 and up to 10

for (i <- 1 to 5; j <- 1 to 10) println(i + " " + j) // we can have multiple ranges in one statement

val intList = List(1,2,3,4)
for (item <- intList) println(item) // we can directly pass the list into the loop to be iterated over
***/

// TODO - twelfth code example from introduction

/***
for (i <- 1 to 10
     if i > 2 // notice that parentheses are not needed
     if i < 8
) println(i) // we can add conditional checks directly into the for loop

for (i <- 1 to 3) yield i // will give you a Vector(1, 2, 3)

for (i <- 1 to 3; j <- 1 to 3) yield (i, j) // will give you a Vector((1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3))

(for (i <- 1 to 3) yield i + 1).toList // will give you a List(2, 3, 4)
***/

// TODO - thirteenth code example from introduction

/***
var pushUp = 4

while (pushUp > 0)
{
    println("Doing a push up!")
    pushUp -= 1 // at the end of each loop we take one away so that the loop would stop when the condition doesn't evaluate to true any more
}

do {
    println("Doing a push up!")
    pushUp += 1
} while (pushUp < 6) // this way our println statement will be executed at least once if the condition won't evaluate to true
***/

// TODO - fourteenth code example from introduction