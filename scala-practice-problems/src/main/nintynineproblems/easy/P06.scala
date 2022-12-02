package main.nintynineproblems.easy

/*
  http://aperiodic.net/phil/scala/s-99/p06.scala
    P06 (*) Find out whether a list is a palindrome.
    Example:
    scala> isPalindrome(List(1, 2, 3, 2, 1))
    res0: Boolean = true
*/

object P06 extends App {

  val list1 = List(1, 2, 3, 2, 1)
  val list2 = List(1, 2, 3, 3, 2, 1)
  val list3 = List(1, 2, 3, 3, 2, 4)

  def checkPaliandromeList(list: List[Int]): Boolean = {
    (
      for ( x <- 0 to list.length/2)
        yield list(x) == list(list.length - x - 1) // Vector(Boolean, Boolean, Boolean .....)
      )
      .reduce(_ && _) // check Boolean values
  }

  println(checkPaliandromeList(list1)) // true
  println(checkPaliandromeList(list2)) // true
  println(checkPaliandromeList(list3)) // false
}
