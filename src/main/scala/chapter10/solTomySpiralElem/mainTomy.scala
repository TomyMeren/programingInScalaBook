package chapter10.solTomySpiralElem

object mainTomy extends App {
  val arr1 = Array("a", "e", "i", "o", "u")

  val elem0 = Elemento.elem(arr1)
  val elem1 = Elemento.elem("pato")
  val elem2 = Elemento.elem(3, 4, 'a')

  print(Espiral.espiral(34,0))

}
