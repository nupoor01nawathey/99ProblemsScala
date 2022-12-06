package main.nintynineproblems.medium


import scala.annotation.tailrec

/*
  http://aperiodic.net/phil/scala/s-99/p07.scala

  P07 (**) Flatten a nested list structure.
  Example:
  scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
*/

object P07 extends App {
 val list1 = List(List(1, 2), 3, List(), List(List(List(4, 5)), 6))
 val list2 = List(List(1, 1), 2, List(3, List(5, 8)))

  // this is a RECURSIVE but NOT TR !!! note the last expr we are appending head and then calling function recursively
  def flatten1(list: List[Any]): List[Any] = list match {
    case Nil => List()
    case (head: List[Any]) :: tail => flatten1(head) ::: flatten1(tail)
    case head :: tail => head :: flatten1(tail)
  }


//  In general:
//    ::  -> adds an element at the beginning of a list and returns a list with the added element
//    ::: -> concatenates two lists and returns the concatenated list

  def flatten2(list: List[Any]): List[Any] = {
    @tailrec
    def helper(result: List[Any], list: List[Any]): List[Any] = list match {
      case Nil => result
      case (head: List[Any]) :: tail => helper(result, head ::: tail)
      case head :: tail => helper(result ::: List(head), tail)
    }
    helper(List(), list)
  }

  def flatten3(ls: List[Any]): List[Any] = ls flatMap {
    case e: List[Any] => flatten3(e)
    case element => List(element)
  }

  println(flatten1(list1))
  println(flatten1(list2))

  println(flatten2(list1))
  println(flatten2(list2))

  println(flatten3(list1))
  println(flatten3(list2))
}
