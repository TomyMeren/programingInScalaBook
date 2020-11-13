package chapter10

class LineElement_old(s: String) extends Element {
  val contents = Array(s)
  override def heigh = 1

  override def width = s.length
}
