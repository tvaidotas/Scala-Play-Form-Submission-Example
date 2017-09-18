package controllers

import util.control.Breaks._

class Person(var name: String, var age: Int)

object Main extends App {


  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break
    }
  }

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

  //showEvaluationOnDefine()

}