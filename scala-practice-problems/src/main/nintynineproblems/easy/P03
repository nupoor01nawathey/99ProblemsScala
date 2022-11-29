package main.nintynineproblems.easy

/*
  http://aperiodic.net/phil/scala/s-99/

  P03 (*) Find the Kth element of a list.
  By convention, the first element in the list is element 0.

  Example:
  scala> nth(2, List(1, 1, 2, 3, 5, 8))
  res0: Int = 2
*/

object P03 extends App {
  def findNthElement1[A](n: Int, list: List[A]): A = {
    if (n >= 0 && list.length >= n) list(n)
    else throw new NoSuchElementException
  }

  def findNthElement2[A](n: Int, list:List[A]): A = (n, list) match {
    case (0, head :: _) => list.head
    case (n, _ :: tail) => findNthElement2(n-1, list.tail)
    case _ => throw new NoSuchElementException
  }

  println(findNthElement1(4, List("head",1,2,3,"lastButOneElement1 last but one", 4)))
  println(findNthElement2(4, List("head",1,2,3,"lastButOneElement1 last but one", 4)))
  println(findNthElement1(2, List(1, 1, 2, 3, 5, 8)))
  println(findNthElement2(2, List(1, 1, 2, 3, 5, 8)))

}
