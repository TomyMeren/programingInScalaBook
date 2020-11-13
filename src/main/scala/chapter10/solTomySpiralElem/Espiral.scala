package chapter10.solTomySpiralElem

object Espiral {
  val suma: Elemento = Elemento.elem("+")
  val blanco: Elemento = Elemento.elem(" ")

  def espiral(n: Int, edge: Int): Elemento = {
    if (1 >= n) suma
    else {
      val espi: Elemento = espiral(n-1, (edge + 1)  % 4 )
      val guiones: Elemento = Elemento.elem( 1,espi.anchura, '-')
      val barras:Elemento = Elemento.elem(espi.longitud,1,'|')
      if (edge == 0) {
        (suma unir guiones) join (espi unir blanco)
      }
      else if (edge == 1) {
        (barras join suma) unir (blanco join espi)
      }
      else if (edge == 2){
        (blanco unir espi) join (guiones unir suma)
      }

      else {
        (espi join blanco) unir (suma join barras)
      }
    }
  }
}
