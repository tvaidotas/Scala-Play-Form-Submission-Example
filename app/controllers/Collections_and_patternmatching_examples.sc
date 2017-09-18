

/***
// initialize the list
val list: List[String] = List(
  "Corona",
  "Stella",
  "Guinness"
)

println(s"Getting the element from the list by the index: ${list(0)}") // will be print out -> Getting the first element from the list: Corona
// although the recommended way to get the first element from the list would be
println(s"Getting the first element from the list: ${list.head}") // will be print out -> Getting the first element from the list: Corona
println(s"Getting the last element from the list: ${list.last}") // will be print out -> Getting the first element from the list: Guinness
println(s"Ignoring the first element and returning the rest of the list: ${list.tail}") // will be print out -> Ignoring the first element and returning the rest of the list: List(Stella, Guinness)

// appending an element at the end of the list
val list2 = list :+ "Fosters" // list2 will now be evaluated to -> List(Corona, Stella, Guinness, Fosters)
list2 :+ "Peroni" // we're adding Peroni to the end of the list thus creating a new list as the list2 is immutable and we cannot reasign value to it
list2 // therefore list2 will still be evaluated to -> List(Corona, Stella, Guinness, Fosters)

// adding an element to the start of the list and creating new list out of it
val list3 = "Fosters" +: list

// to add two lists together
val combinedList = list ::: list2 // will be evaluated to -> List(Corona, Stella, Guinness, Corona, Stella, Guinness, Fosters)

// to initialize an empty list
val emptyList = List.empty
***/

// TODO - first code example from collections

/***
// we define a variable which is going to be a ListBuffer collection initialized to be empty and contain elements of type Int
val listBuffer = scala.collection.mutable.ListBuffer.empty[Int]

listBuffer += 1 // adding an item to the list buffer, it will now be evaluated to -> ListBuffer(1)
listBuffer += 33 // adding an item to the list buffer, it will now be evaluated to -> ListBuffer(1, 33)
listBuffer.toList // converting ListBuffer to List, it will now be evaluated to -> List(1, 33)
***/

// TODO - second code example from collections

/***
// initializing a variable which is going to be an Array with some elements
val array = Array(
  "Corona",
  "Stella",
  "Guinness"
)

// accessing elements can be done by index or functions like previously seen ones
array(0) // will be evaluated to -> Corona
array.head // will be evaluated to -> Corona
array.last // will be evaluated to -> Guinness
array.tail // will be evaluated to -> Array(Stella, Guinness)

// to create a dimensional array
val dimensionalArray = Array.ofDim[Int](2, 2) // we define the dimensions for the array, where you can think of them as .ofDim[TypeOfItemsToBeStored](Rows, Columns)

// to add element into a dimensional array
dimensionalArray(0)(0) = 1
dimensionalArray(0)(1) = 2
dimensionalArray(1)(0) = 3
dimensionalArray(1)(1) = 4

// creating a collection using range
val rangedArray = (1 to 10).toArray[Int] // will be evaluated to -> Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
***/

// TODO - third code example from collections

/***
// we define a variable which is going to be a ArrayBuffer collection initialized to be empty and contain elements of type Int
val arrayBuffer = scala.collection.mutable.ArrayBuffer.empty[Int]

arrayBuffer += 1 // adding an item to the array buffer, it will now be evaluated to -> ArrayBuffer(1)
arrayBuffer += 33 // adding an item to the array buffer, it will now be evaluated to -> ArrayBuffer(1, 33)
arrayBuffer.toArray // converting ArrayBuffer to Array, it will now be evaluated to -> Array(1, 33)
***/

// TODO - fourth code example from collections

/***
// initializing a variable which is going to be an Vector with some elements
val vector = Vector(1,2,3)

// updating the value in the collection
vector updated(1, 5) // as the collection is immutable we get a local updated collection but we are not reassigning the value of vector to the new one, therefore this expression is evaluated to Vector(1,5,3)
vector // if we look at the vector again it will be Vector(1,2,3) as we initially initialized it
***/

// TODO - fifth code example from collections
/***
// initializing two variables which are going to be a Set with some elements
val set = Set(1,2,3,4,5)
val subSet = Set(1,2,3)

// doing the tests on the collections
set contains 2 // is the same as set(2), where both of them would be evaluated to -> true
subSet subsetOf set // as subSet's elements are all part of set it's a subset of set therefore this expression will be evaluated to -> true
***/
// TODO - sixth code example from collections
/***
// initializing two variables which are going to be a Set with some elements
val set = Set(1,2,3,4,5)
val subSet = Set(8,9,3)

// adding elements to the collection
set + 22 // as the collection is immutable we get a local updated collection but we are not reassigning the value of set to the new one, therefore this expression is evaluated to Set(5, 1, 2, 22, 3, 4)
subSet ++ set // as the collection is immutable we get a local updated collection but we are not reassigning the value of set to the new one, remember set doesn't contain duplicates this expression is evaluated to Set(5, 1, 9, 2, 3, 8, 4)
***/
// TODO - seventh code example from collections

/***
// initializing two variables which are going to be a Set with some elements
val set = Set(1,2,3,4,5)
val subSet = Set(8,9,3)

// taking away elements from the collection
set - 2 // as the collection is immutable we get a local updated collection but we are not reassigning the value of set to the new one, therefore this expression is evaluated to Set(5, 1, 3, 4)
subSet -- set // as the collection is immutable we get a local updated collection but we are not reassigning the value of set to the new one, remember set doesn't contain duplicates this expression is evaluated to Set(8, 9)
***/
// TODO - 8th code example from collections
/***
// initializing two variables which are going to be a Set with some elements
val set = Set(1,2,3,4,5)
val subSet = Set(8,9,3)

set | subSet // will be evaluated to -> Set(5, 1, 9, 2, 3, 8, 4)
set & subSet // will be evaluated to -> Set(3)
set &~ subSet // will be evaluated to -> Set(5, 1, 2, 4)
***/
// TODO - 9th code example from collections
/***
// initializing two variables which are going to be a Set with some elements
val set = scala.collection.mutable.Set(1,2,3,4,5)
val subSet = Set(8,9,3)

set += 9 // will be evaluated to -> Set(9, 1, 5, 2, 3, 4)
set ++= subSet // will be evaluated to -> Set(9, 1, 5, 2, 3, 4, 8)
set add 666 // we get a boolean back to know whether the element was previously in the set or not, will be evaluated to -> true
set add 0 // we get a boolean back to know whether the element was previously in the set or not, will be evaluated to -> true
set // with all the elements added the set will be evaluated to -> Set(0, 9, 1, 5, 2, 666, 3, 4, 8)
***/
// TODO - 10h code example from collections

/***
// initializing two variables which are going to be a Set with some elements
val set = scala.collection.mutable.Set(1,2,3,4,5)
val subSet = Set(8,9,3)

set -= 1 // will be evaluated to -> Set(5, 2, 3, 4)
set --= subSet // will be evaluated to -> Set(5, 2, 4)
set remove 666  // removing an item in this way will return a boolean to tell whether that element was in the list and then it will be evaluated to -> false
set retain (x => x > 3) // will keep all the elements higher than 3 in the set
set // will be evaluated to -> Set(5, 4)
***/

// TODO - 11h code example from collections

/***
// initializing a variable which are going to be a Set with some elements
val set = scala.collection.mutable.Set(1,2,3,4,5)
set.clone() // will produce Set(1,2,3,4,5)
***/

// TODO - 12h code example from collections

/***
// initializing a variable which are going to be a Set with some elements
val set = scala.collection.mutable.Set(1,2,3,4,5)

set.update(
  666,
  if (set.nonEmpty)
    true
  else
    false
) // element 666 will be added to the set if the collection is not empty, otherwise it won't be added

set // will produce Set(1, 5, 2, 666, 3, 4)
***/

// TODO - 13h code example from collections

/***
// initializing a variable which are going to be a Map with some elements
val map = Map(1 -> "a", 2 -> "b")

map(1) // will be evaluated to -> a
map.get(1) // using .get will result in the value being returned as an optional, this expression will be evaluated to -> Some(a)
map.getOrElse(9, "No value found") // will be evaluated to -> No value found
***/

// TODO - 14h code example from collections

/***
// initializing a variable which are going to be a Map with some elements
val map = Map(1 -> "a", 2 -> "b")

map contains 2 // contains checks if there is a value binded to this key, will be evaluated to -> true
map isDefinedAt 6 // essentially the same as contains, will be evaluated to -> false
***/

// TODO - 15h code example from collections

/***
// initializing variables that are going to be a Map with some elements
val map = Map(1 -> "a", 2 -> "b")
val map2 = Map(3 -> "c")

map + (5 -> "e") // as the collection is immutable we get a local updated collection but we are not reassigning the value of set to the new one, therefore this expression is evaluated to Map(1 -> a, 2 -> b, 5 -> e)
map ++ map2 // will be evaluated to -> Map(1 -> a, 2 -> b, 3 -> c)
map updated(1, "z") // will be evaluated to -> Map(1 -> z, 2 -> b)
***/

// TODO - 16h code example from collections

/***
// initializing variables that are going to be a Map with some elements
var map = Map(1 -> "a", 2 -> "b", 3 -> "c", 9 -> "z")
val map2 = Map(1 -> "d", 2 -> "e", 3 -> "f", 4 -> "h")

map - 1 // will be evaluated to -> Map(2 -> b, 3 -> c)
map -- map2.keys // all the keys from map2 that exist in map will be removed along with the values, this will be evaluated to -> Map(9 -> z)
***/

// TODO - 17h code example from collections

/***
// initializing a variable which are going to be a Map with some elements
val map = Map(1 -> "a", 2 -> "b")

map.keys // will be evaluated to -> Set(1, 2)
map.keySet // will be evaluated to -> Set(1, 2)
map.keysIterator // will be evaluated to -> non-empty iterator
map.values // will be evaluated to -> MapLike(a, b)
map.valuesIterator // will be evaluated to -> non-empty iterator
***/

// TODO - 18th code example from collections

/***
// initializing a variable which are going to be a Map with some elements
val map = Map(1 -> "a", 2 -> "b", 3 -> "c")

map.filterKeys(key => key > 1)  // will be evaluated to -> Map(2 -> b, 3 -> c)
map mapValues(value => value * 2) // will be evaluated to -> Map(1 -> aa, 2 -> bb, 3 -> cc)
***/

// TODO - 19th code example from collections

/***
// initializing variables that are going to be a Map with some elements
val map = scala.collection.mutable.Map(1 -> "a", 2 -> "b", 3 -> "c", 9 -> "z")
val map2 = Map(6 -> "d", 7 -> "e", 8 -> "f", 4 -> "h")

map(1) = "d"   // changing the value to a new one
map   // will be evaluated to -> Map(2 -> b, 1 -> d, 9 -> z, 3 -> c)

map += (4 -> "d")  // will be evaluated to -> Map(2 -> b, 4 -> d, 1 -> d, 9 -> z, 3 -> c)

map ++= map2  // will be evaluated to -> Map(8 -> f, 2 -> b, 4 -> h, 7 -> e, 1 -> d, 9 -> z, 3 -> c, 6 -> d)

map.put(10,"h")  // as there is no such key and value in the map expression will be evaluated to -> None

map.getOrElseUpdate(1, "l")  // if there is no value take l as a new value by default and return it
map   // will be evaluated to -> Map(8 -> f, 2 -> b, 4 -> h, 7 -> e, 10 -> h, 1 -> d, 9 -> z, 3 -> c, 6 -> d)
***/

// TODO - 20th code example from collections

/***
// initializing variables that are going to be a Map with some elements
val map = scala.collection.mutable.Map(1 -> "a", 2 -> "b", 3 -> "c", 9 -> "z")
val map2 = scala.collection.mutable.Map(6 -> "d", 7 -> "e", 8 -> "f", 9 -> "h")

map -= 1   // will be evaluated to -> Map(2 -> b, 9 -> z, 3 -> c)
map --= map2.keysIterator   // will be evaluated to -> Map(2 -> b, 3 -> c)

map remove 2   // will be evaluated to -> Some(b)

map2.retain(
  (key,value) => key > 1
) // will be evaluated to -> Map(8 -> f, 7 -> e, 9 -> h, 6 -> d)

map2.clear() // will delete everything from the collection
map2   // will be evaluated to -> Map()
***/

// TODO - 20th code example from collections

/***
// initializing a variable which are going to be a Map with some elements
val map = Map(1 -> "a", 2 -> "b", 3 -> "c")

map.transform((key,value) => value * key) // will be evaluated to -> Map(1 -> a, 2 -> bb, 3 -> ccc)
***/

// TODO - 21th code example from collections

/***
// initializing a variable which are going to be a Vector with some elements
val numbers = Vector(1, 2, 3)

0 +: numbers // will be evaluated to -> Vector(0, 1, 2, 3)

numbers // will be evaluated to -> Vector(1, 2, 3)
***/

// TODO - 22th code example from collections

/***
val beerType = "Lager"

beerType match {
  case "Lager" => println("It may be pale, golden, amber or dark")
  case "Ale" => println("Mostly dark brown")
  case _ => println("Some other colour")
} // will be evaluated to -> It may be pale, golden, amber or dark

val whatBeerAmIDrinking = beerType match {
  case "Lager" => "It may be pale, golden, amber or dark"
  case "Ale" => "Mostly dark brown"
  case _ => "Some other colour"
} // will be evaluated to -> "It may be pale, golden, amber or dark"

println(s"I'm drinking $beerType which is $whatBeerAmIDrinking colour") // will be evaluated to -> I'm drinking Lager which is It may be pale, golden, amber or dark colour
***/

// TODO - 23th code example from collections

/***
val crispsImEating: Any = "Salt and vinegar"

crispsImEating match {
  case crisps:String if crisps.toLowerCase.contains("vinegar") => "I don't like them"
  case crisps:String if !crisps.toLowerCase.contains("vinegar") => "I like them"
  case _ => "I can't recognise the taste"
} // will be evaluated to -> I don't like them
***/

// TODO - 24th code example from collections

/***
def whatTimeIsIt(time: Any): String = time match {
  case _ => s"$time Is no time"
}
whatTimeIsIt("9:30") // will be evaluated to -> 9:30 Is no time
whatTimeIsIt(9,30) // will be evaluated to -> (9,30) Is no time
  ***/

// TODO - 25th code example from collections

/***
def whatTimeIsIt(time: Any): String = time match {
  case x => s"$x Is no time"
}
whatTimeIsIt("9:30") // will be evaluated to -> 9:30 Is no time
whatTimeIsIt(9,30) // will be evaluated to -> (9,30) Is no time
***/

// TODO - 26th code example from collections

/***
case class Time(hours:Int, minutes:Int)

def whatTimeIsIt(time: Any): String = time match {
  case time:Time => s"It's ${time.hours}:${time.minutes}"
  case x => s"$x Is no time"
}
whatTimeIsIt(Time(9,30)) // will be evaluated to -> It's 9:30
***/

// TODO - 27th code example from collections

/***
def whatTimeIsIt(time: Any): String = time match {
  case "12:00" => s"It's high noon"
  case _ => s"$time Is no time"
}
whatTimeIsIt("12:00") // will be evaluated to -> It's high noon
whatTimeIsIt("11:31") // will be evaluated to -> 11:31 Is no time
***/

// TODO - 27th code example from collections

/***
def whatTimeIsIt(time: Any): String = time match {
  case (x,"12:00") => s"From $x to high noon"
  case _ => s"$time Is no time"
}
whatTimeIsIt("8","12:00") // will be evaluated to -> From 8 to high noon
whatTimeIsIt("11:31") // will be evaluated to -> 11:31 Is no time
***/

// TODO - 28th code example from collections

/***
case class Time(hours:Int, minutes:Int)

def whatTimeIsIt(time: Any): String = time match {
  case Time(12, 0) => s"High noon"
  case Time(12, minutes) => s"It's $minutes past noon"
  case _ => s"$time Is no time"
}
whatTimeIsIt(Time(12,0)) // will be evaluated to -> High noon
whatTimeIsIt(Time(12,25)) // will be evaluated to -> It's 25 past noon

***/

// TODO - 29th code example from collections

/***
def whatTimeIsIt(time: Any): String = time match {
  case "12:00" | "00:00" => s"High noon or midnight"
  case _ => s"$time Is no time"
}
whatTimeIsIt("12:00") // will be evaluated to -> High noon or midnight
whatTimeIsIt("00:00") // will be evaluated to -> High noon or midnight
whatTimeIsIt("00:01") // will be evaluated to -> 00:01 Is no time
***/

// TODO - 30th code example from collections

/***
case class Time(hours:Int, minutes:Int)

def whatTimeIsIt(time: Any): String = time match {
  case timeObject @ Time(_, _) => s"It's ${timeObject.hours}:${timeObject.minutes} "
  case _ => s"$time Is no time"
}
whatTimeIsIt(Time(12,0)) // will be evaluated to -> It's 12:0
whatTimeIsIt(Time(12,25)) // will be evaluated to -> It's 12:25
***/

// TODO - 31th code example from collections

/***
case class Time(hours:Int, minutes:Int)

def whatTimeIsIt(time: Any): String = time match {
  case timeObject @ Time(_, _) if timeObject.hours > 12 =>
    s"It's ${timeObject.hours}:${timeObject.minutes} "
  case _ => s"$time Is no time"
}
whatTimeIsIt(Time(12,0)) // will be evaluated to -> It's 12:0
whatTimeIsIt(Time(12,25)) // will be evaluated to -> It's 12:25
***/
// TODO - 32th code example from collections

/***
val optionalVariable = Some("Hello world")

optionalVariable match {
  case value: Some[String] => println(value)
  case _ => println("Unrecognised value")
}
***/

// TODO - 33th code example from collections

/***
val list = List(1,2,3,4,5)

list map (value => value * 10) // will be evaluated to -> List(10, 20, 30, 40, 50)
***/

// TODO - 34th code example from collections

/***
val list = List("Hello", "World")

list map (_.toList)  // will be evaluated to -> List(List(H, e, l, l, o), List(W, o, r, l, d))

list flatMap (_.toList)  // will be evaluated to -> List(H, e, l, l, o, W, o, r, l, d)
***/

// TODO - 35th code example from collections

/***
var sum = 0
val list = List (1,2,3,4,5)

list foreach (element => sum += element)
sum // will be evaluated to -> 15
***/

// TODO - 36th code example from collections
