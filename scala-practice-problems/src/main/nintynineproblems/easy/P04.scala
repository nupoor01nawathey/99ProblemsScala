package main.nintynineproblems.easy

import scala.annotation.tailrec

/*
  http://aperiodic.net/phil/scala/s-99/p04.scala

  P04 (*) Find the number of elements of a list.
  Example:
  scala> length(List(1, 1, 2, 3, 5, 8))
  res0: Int = 6
*/

object P04 extends App {
  def lengthOfList1[A](list: List[A]): Int = list.length

  def lengthOfList2[A](list: List[A]): Int = {
    if (list == Nil) 0
    else lengthOfList2(list.tail) + 1 // The recursive call is made and THEN 1 is added to the result !!! NOT a tailrec what a bummer ...
  }

  def lengthOfList3[A](list: List[A]): Int = {
    @tailrec
    def helper(list: List[A], len: Int): Int = {
      if (list == Nil) len
      else helper(list.tail, len+1)
    }
    helper(list, 0)
  }

  def lengthOfList4[A](list: List[A], len: Int = 0): Int = {
    if (list.isEmpty) len
    else lengthOfList4(list.tail, len+1)
  }

  def lengthOfList5[A](list: List[A]): Int = list.foldLeft(0){ (accumulator, dummyVar) => accumulator + 1 }

  println(lengthOfList1(List(1, 1, 2, 3, 5, 8))) // 6
  println(lengthOfList2(List(1, 1, 2, 3, 5, 8))) // 6
  println(lengthOfList3(List(1, 1, 2, 3, 5, 8))) // 6
  println(lengthOfList4(List(1, 1, 2, 3, 5, 8))) // 6
  println(lengthOfList5(List(1, 1, 2, 3, 5, 8))) // 6
}
