package chapter10

class UniformElement_old(override val heigh: Int,
                     override val width: Int,
                     elem: Char)
  extends Element {
  private val filled = elem.toString * width

  val contents: Array[String] = Array.fill(heigh)(filled)
}
