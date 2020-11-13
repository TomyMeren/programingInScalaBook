package chapter10

import chapter10.ElementNew.elem

object main extends App {

  val result = Spiral.spiral(5,0)
  println(result.contents.toList)
  println(result)
  println(" ")

  println(SpiralOld.spiral(6,0))
  println(" ")

  println(elem("+") beside elem('-', 2, 1) )

  println(" ")

 /* println(elem('|', 2, 4) beside elem('#', 1, 3) )
  println(elem('|', 2, 4) above elem('#', 1, 3) )*/
}
