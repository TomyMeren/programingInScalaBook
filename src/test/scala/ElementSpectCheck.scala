import org.scalacheck._
import chapter10.solTomySpiralElem.Elemento.elem
import org.scalacheck.Prop.{forAll, propBoolean}

class ElementSpectCheck extends Properties("elem") {

  val a = forAll { w: Int =>
    (w > 0) ==> (elem(w, 2, 'x').longitud == w)
  }
}


