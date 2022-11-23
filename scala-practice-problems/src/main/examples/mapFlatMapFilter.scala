package main.examples

/*
    map
    flatMap
    filter
*/

object mapFlatMapFilter extends App {

  // map and flatMap(map followed by flatten)
  val fruits = List("apple", "banana", "orange", "melon")
  println(fruits.map(_.toUpperCase)) // List(APPLE, BANANA, ORANGE, MELON)
  println(fruits.flatMap(_.toUpperCase)) // List(A, P, P, L, E, B, A, N, A, N, A, O, R, A, N, G, E, M, E, L, O, N)

  // filter = predicate
  val x = List.range(1, 10)
  val randomListElements: List[Any] = "apple" :: "banana" :: 1 :: 2 :: Nil // Nil is mandat for this type of list declaration
  println(x.filter(_ % 2 == 0)) // List(2, 4, 6, 8)
  println(fruits.filter(_.startsWith("o"))) // List(orange)
  println(fruits.filter(_.length > 5)) // List(banana, orange)

  // mix filter with pattern matching for extracting required values
  val filterStrings = randomListElements.filter {
    case s: String => true
    case _ => false
  }
  val filterIntegers = randomListElements.filter {
    case n: Int => true
    case _ => false
  }
  println(filterStrings) // List(apple, banana)
  println(filterIntegers) // List(1, 2)


}
