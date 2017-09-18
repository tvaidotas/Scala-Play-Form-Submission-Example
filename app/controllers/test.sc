class Person(var name: String, var age: Int)

object Main extends App {

  def showEvaluationOnCall = {
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

  showEvaluationOnCall

}