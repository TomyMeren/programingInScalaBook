package chapter10

import chapter10.ElementNew.elem

object Spiral {

  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): ElementNew = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)

      def verticalBar = elem('|', 1, sp.height)

      def horizontalBar = elem('-', sp.width, 1)

      if (direction == 0) //Primera y ultima linea sine l + final y espacios en blanco de la col 2
      (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2) {
        //println((space beside sp) above (horizontalBar beside corner))
        (space beside sp) above (horizontalBar beside corner)
      }
      else { // todas las "|" de la izquierda y el + de abajo y a la derecha un
        //println("tomy:" + ((verticalBar above corner) beside (space above sp)).contents.toList)
        (verticalBar above corner) beside (space above sp)
      }
    }
  }
}