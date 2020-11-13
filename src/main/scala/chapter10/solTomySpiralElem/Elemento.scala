package chapter10.solTomySpiralElem

abstract class Elemento {
  def contenido: Array[String]

  val longitud: Int = contenido.length
  val anchura: Int = if (longitud == 0) 0 else contenido(0).length

  override def toString: String = contenido.mkString("\n")

  def join(that: Elemento): Elemento = {
    val this1:Elemento = this.fillUnionSpaces(that.anchura)
    val that1:Elemento = that.fillUnionSpaces(anchura)
    assert(this1.anchura == that1.anchura)
    Elemento.elem(this1.contenido ++ that1.contenido)
  }

  def unir(that: Elemento): Elemento = {
    val this1:Elemento = this.fillJoinSpaces(that.longitud)
    val that1:Elemento = that.fillJoinSpaces(longitud)
    Elemento.elem(
      (this1.contenido zip that1.contenido).map(x => x._1 + x._2))
  }

  def fillJoinSpaces(size: Int): Elemento = {
    if (longitud >= size) this
    else {
      val left: Elemento = Elemento.elem((size -longitud) / 2, anchura, ' ')
      val right: Elemento = Elemento.elem(size - longitud - left.longitud, anchura, ' ')
      left join this join right
    }
  } ensuring(x=> x.longitud >= size)

  def fillUnionSpaces(size: Int): Elemento = {
    if (anchura >= size) this
    else {
      val left: Elemento = Elemento.elem(longitud, (size - anchura) / 2, ' ')
      val right: Elemento = Elemento.elem(longitud, size - anchura - left.anchura, ' ')
      left unir this unir right
    }
  }
}

object Elemento {

  private class ElementoArray(val contenido: Array[String]) extends Elemento

  private class ElementoUnico(conten: String) extends Elemento {
    def contenido: Array[String] = Array(conten)

    override val longitud: Int = 1

    override val anchura: Int = conten.length
  }

  private class ElementoIter(override val longitud: Int,
                             override val anchura: Int,
                             conten: Char) extends Elemento {
    def contenido: Array[String] = Array.fill(longitud)(conten.toString * anchura)
  }

  def elem(conten: Array[String]): Elemento = new ElementoArray(conten)

  def elem(conten: String): Elemento = new ElementoUnico(conten)

  def elem(longitud: Int, anchura: Int, conten: Char): Elemento = new ElementoIter(longitud, anchura, conten)
}
