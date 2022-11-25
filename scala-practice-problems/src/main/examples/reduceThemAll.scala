package main.examples

/*
  reduce[A1 >: B](op: (A1, A1) ⇒ A1): A1
  reduceLeft[B >: B](op: (B, B) ⇒ B): B
  reduceRight[B >: B](op: (B, B) ⇒ B): B
*/

object reduceThemAll extends App {
  val list = List(1,2,3,4,5)
  println(list.reduce(_ + _)) // 15

  println (list.reduceLeft(_ - _))
  /*
    reduceLeft => 1 - 2
    reduceLeft => -1 - 3
    reduceLeft => -4 - 4
    reduceLeft => -8 - 5
    -13
   */

  println(list.reduceRight(_ - _))
  /*
    reduceRight => 4 - 5
    reduceRight => 3 - -1
    reduceRight => 2 - 4
    reduceRight => 1 - -2
    3
   */

  println((0 to 1000000000).reduceLeft(_ - _)) // 243309312
  println((0 to 1000000000).reduceRight(_ - _)) // 500000000
}
