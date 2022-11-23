package main.nintynineproblems.easy

/*
  http://aperiodic.net/phil/scala/s-99/

  P02 (*) Find the last but one element of a list.
  Example:
  scala> penultimate(List(1, 1, 2, 3, 5, 8))
  res0: Int = 5
 */

object P02 extends App {
  def lastButOneElement1[A](list: List[A]): A = {
    if (list.length < 2) throw new NoSuchElementException
    else list(list.length - 2) // subtract total - 2
  }

  def lastButOneElement2[A](list: List[A]): A = {
    if (list.length < 2) throw new NoSuchElementException
    else list.init.last // list.init = List(1,2,3,4) and .last will extract 4
  }

  def lastButOneElement3[A](list: List[A]): A = {
    if (list.length < 2) throw new NoSuchElementException
    else list.takeRight(2).head // List("lastButOneElement2 last but one", 4) and it's head is lastButOneElement2 last but one
  }

  def lastButOneElement4[A](list: List[A]): A = list match {
    case head :: _ :: Nil => list.head
    case tail => lastButOneElement4(list.tail)
    case _ => throw new NoSuchElementException
  }



//  println(List("head",1,2,3,"lastButOneElement1 last but one", 4).length) // length is 6 but indexed from 0 like Array
//  println(List("head",1,2,3,"lastButOneElement1 last but one", 4)(0)) // head
//  println(List("head",1,2,3,"lastButOneElement1 last but one", 4)(4)) // lastButOneElement1 last but one

//  println(lastButOneElement1(List("head",1,2,3,"lastButOneElement1 last but one", 4)))
//  println(lastButOneElement1(List("lastButOneElement1", 1)))
//  println(lastButOneElement1(List("negative test case lastButOneElement1")))

//  println(lastButOneElement2(List("head",1,2,3,"lastButOneElement2 last but one", 4)))
//  println(lastButOneElement2(List("lastButOneElement2", 2)))
//  println(lastButOneElement2(List("negative test case lastButOneElement2")))

//  println(lastButOneElement3(List("head",1,2,3,"lastButOneElement3 last but one", 4)))
//  println(lastButOneElement3(List("lastButOneElement3", 3)))
//  println(lastButOneElement3(List("negative test case lastButOneElement3")))

//  println(lastButOneElement4(List("head",1,2,3,"lastButOneElement4 last but one",4)))
//  println(lastButOneElement4(List("lastButOneElement4", 4)))
//  println(lastButOneElement4(List("negative test case lastButOneElement4")))

}
