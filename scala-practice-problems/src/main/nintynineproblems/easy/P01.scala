package main.nintynineproblems.easy


/*
    http://aperiodic.net/phil/scala/s-99/

    P01 (*) Find the last element of a list.
    Example:
    scala> last(List(1, 1, 2, 3, 5, 8))
    res0: Int = 8
 */


object P01 extends App {
  def getLastElementFromList[A](list: List[A]): A = {
    if (list.tail.isEmpty) list.head
    else getLastElementFromList(list.tail)
  }
  println(getLastElementFromList(List(1, 2, 3, 4, 5)))
  println(getLastElementFromList(List("head", 1, 2, 3, "tail")))
}
