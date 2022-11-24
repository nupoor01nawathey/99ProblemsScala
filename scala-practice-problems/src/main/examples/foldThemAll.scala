package main.examples

/*
  fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1
  foldLeft[B](z: B)(f: (B, A) => B): B
  foldRight[B](z: B)(f: (A, B) => B): B
*/

object foldThemAll extends App {
  val list = List(1,2,3,4,5)
  val sum = list.fold(0)((x, y) => x + y) // list.fold(0)(_+_)
  println("Sum of all elements of a list  " + sum)
  /*
    Step 1: x(0) + y(1) = 1
    Step 2: x(1) + y(2) = 3
    Step 3: x(3) + y(3) = 6
    Step 4: x(6) + y(4) = 10
    Step 5: x(10) + y(5) = 15
   */

  case class People(name: String, gender: String)
  val people = List(People("Thomas", "male"), People("Sowell", "male"), People("Liz", "female"))
  val foldLeftResult = people.foldLeft(List[String]()) {(accumulator, person) => // !!! different for foldRight !!!
    val title = person.gender match {
      case "male" => "Mr."
      case "female" => "Ms."
    }
    accumulator :+ s"$title ${person.name}"
  }
  println(foldLeftResult) // foldLeft associates to the left. An accumulator will be initialized, and elements will be added to it in left-to-right orde
  // List(Mr. Thomas, Mr. Sowell, Ms. Liz)

  val foldRightResult = people.foldRight(List[String]()) {(person, accumulator ) => // !!! different for foldLeft !!!
    val title = person.gender match {
      case "male" => "Mr."
      case "female" => "Ms."
    }
    accumulator :+ s"$title ${person.name}"
  }
  println(foldRightResult) // List(Ms. Liz, Mr. Sowell, Mr. Thomas)

}
