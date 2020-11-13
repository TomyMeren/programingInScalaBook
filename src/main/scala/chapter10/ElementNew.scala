package chapter10

object ElementNew {

  private class ArrayElement(
                              val contents: Array[String]
                            ) extends ElementNew

  private class LineElement(s: String) extends ElementNew {
    val contents = Array(s)

    override def width = s.length

    override def height = 1
  }

  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends ElementNew {
    private val line = ch.toString * width

    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): ElementNew =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): ElementNew =
    new UniformElement(chr, width, height)

  def elem(line: String): ElementNew =
    new LineElement(line)
}

import ElementNew.elem

abstract class ElementNew {
  def contents: Array[String]

  def width: Int = contents(0).length

  def height: Int = contents.length

  def above(that: ElementNew): ElementNew = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  def beside(that: ElementNew): ElementNew = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2)
  }

  def widen(w: Int): ElementNew =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): ElementNew =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"
}
