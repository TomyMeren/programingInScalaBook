package chapter10

object Element {

  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)

    override def heigh = 1

    override def width = s.length
  }

  private class UniformElement(override val heigh: Int,
                               override val width: Int,
                               elem: Char)
    extends Element {
    private val filled = elem.toString * width

    val contents: Array[String] = Array.fill(heigh)(filled)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(s: String): Element = new LineElement(s)

  def elem(heigh: Int, width: Int, elem: Char): Element = new UniformElement(heigh, width, elem)
}

import Element.elem

abstract class Element {
  override def toString: String = contents.mkString("\n")

  def contents: Array[String]

  def heigh: Int = contents.length

  def width: Int = if (heigh == 0) 0 else contents(0).length

  def above(that: Element): Element = {

    val this1 = this widem that.width
    val that1 = that widem this.width
    elem(this1.contents ++ that1.contents)
  }

  /*  def beside(that: Elemwidement): Element =
      elem((this.contents zip that.contents).map(x => x._1 + x._2))*/

  def beside(that: Element): Element = {
    val this1 = this heighten  that.heigh
    val that1 = that heighten  this.heigh

    elem(
      for (
        (x, y) <- this1.contents zip that1.contents
      ) yield x + y
    )
  }

  def widem(n: Int): Element = {
    if (n <= width) this
    else {

      val left: Element = elem(heigh, (n - width) / 2, ' ')
      val right: Element = elem(heigh, n - width - left.width, ' ')

      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= heigh) this
    else {
      val top: Element = elem((h - heigh) / 2, width, ' ')
      val bottom: Element = elem(h - heigh - top.heigh, width, ' ')
      top above this above bottom
    }
  }
}
