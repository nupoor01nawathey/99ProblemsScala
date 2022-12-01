package main.nintynineproblems.easy

/*
  http://aperiodic.net/phil/scala/s-99/p05.scala
  P05 (*) Reverse a list.
  Example:
  scala> reverse(List(1, 1, 2, 3, 5, 8))
  res0: List[Int] = List(8, 5, 3, 2, 1, 1)
*/

object P05 extends App {
  def reverseList1[A](list: List[A]): List[A] = {
    def helper(result: List[A], currentList: List[A]): List[A] = currentList match {
      case Nil => result
      case head :: tail => helper(head :: result, tail)
    }
    helper(Nil, list)
  }
  println(reverseList1(List(1,2,3,4,5)))
  println(reverseList1(List(1, 1, 2, 3, 5, 8)))

  def reverseList2[A](list: List[A]): List[A] = list.foldLeft(List[A]()) { (x, y) => y :: x }
  println(reverseList2(List(1,2,3,4,5)))
  println(reverseList2(List(1, 1, 2, 3, 5, 8)))
}
/*
reverseList1
  list = List(1,2,3,4,5)
  helper(Nil, list)
    list match {
        helper(1 :: Nil, List(2,3,4,5))
        helper(2 :: 1 :: Nil, List(3,4,5))
        helper(3 :: 2 :: 1 :: Nil, List(4, 5))
        helper(4 :: 3 :: 2 :: 1 :: Nil, List(5))
        helper(5 :: 4 :: 3 :: 2 :: 1 :: Nil, List(Nil)/Nil)
        return 5::4::3::2::1
      }
      List(5,4,3,2,1)
    }


reverseList2
  list = List(1,2,3,4,5)
  !!! List() because this is declared when foldLeft was initiated to a base value x = List[A]!!!
  x,y => List()  :: 1       => y :: x => 1 :: List()
  x,y => List(1) :: 2       => y :: x => 2 :: List(1)
  x,y => List(2,1) :: 3     => y :: x => 3 :: List(2, 1)
  x,y => List(3,2,1) :: 4   => y :: x => 4 :: List(3, 2, 1)
  x,y => List(4,3,2,1) :: 5 => y :: x => 5 :: List(4, 3, 2, 1)
 */
