/*
package chapter10

import Element.elem

object SpiralTomy {
  val blank = " "
  val guion = "-"
  val plus = "+"

  def create(n: Int): Element = {
    def blankLines(line: Int): Element = {
      val numElemeUp = line / 2
      val numEleDown = (n - line + 1) / 2
      val cond = line <= (n + 1) / 2

      val left = if (cond) elem(1, numElemeUp, "| ")
      else elem(1, numEleDown, "| ")

      val right = if (cond) elem(1, numElemeUp - 1, " |")
      else elem(1, numEleDown, "| ")

      val numBlank = left.width * 2 - right.width * 2 - 1

      left beside elem(1, numBlank, blank) beside right
    }

    def pluslines(line: Int): Element = {
      val condlus = line <= (n + 1) / 2
      val numEle = (n - line + 1) / 2
      val numElemeUp = line / 2

      val left = if (condlus) elem(1, numElemeUp, "| ")
      else elem(1, numEle, "| ")

      val right = if (condlus) elem(1, numElemeUp - 1, " |")
      else elem(1, numEle, " |")

      if (condlus) {
        left beside elem(plus) beside
          elem(1, n - left.width * 2 - right.width * 2 - 3, guion) beside
          elem(plus) beside right
      }
      else {
        val numGuiones = n - left.width * 2 - right.width * 2 - 3

        left beside elem(plus) beside
          elem(1, numGuiones, guion) beside
          (if (numGuiones <= 0 && n % 2 == 0) elem("") else elem(plus)) beside right
      }
    }

    val firstLine: Element = elem("+") beside elem(1, n - 1, "-")
    val secondLine: Element = elem("|") beside elem(1, n - 1, " ")

    def loop(line: Int): Element = {
      if (line > n) elem("")

      else if (n % 2 == 1) {
        if (line % 2 == 1) pluslines(line) above loop(line + 1)
        else blankLines(line) above loop(line + 1)
      }

      else {
        if ((line % 2 == 1 && line <= n / 2) || (line % 2 == 0 && line > n / 2))
          pluslines(line) above loop(line + 1)
        else blankLines(line) above loop(line + 1)
      }
    }

    firstLine above secondLine above loop(3)
  }
}

*/
