package main.examples

/*
  foldLeft[B](z: B)(op: (B, A) ⇒ B): B
  reduceLeft[B >: A](op: (B, A) ⇒ B): B

  https://www.baeldung.com/scala/foldleft-vs-reduceleft
 */

object foldLeftVsreduceLeft extends App {
  case class Person(name: String, age: Int)

  val users: Map[Int, Person] = Map(1 -> Person("Tom", 10), 2 -> Person("Gillian", 13), 3 -> Person("Sarah", 17), 4 -> Person("David", 20))

  // Transform the Map[Int, Person] to a List[Person]
  def getAllPeople(people: Map[Int, Person]): List[Person] =  {
    people.foldLeft(List.empty[Person])((accumulator, current) => {
      accumulator :+ current._2
    })
  }
  println(getAllPeople(users))

  println(
    users.foldLeft(List.empty[Person])((accumulator, current) => {
      accumulator :+ current._2
  }))


  val people = users.foldLeft(List.empty[Person])((accumulator, current) => {
    accumulator :+ current._2
  })

  // get the youngest Person from people
  println(people.reduceLeft((youngestPerson, currentPerson) => {
    if (youngestPerson.age > currentPerson.age) {
      currentPerson
    } else {
      youngestPerson
    }
  }))
}
