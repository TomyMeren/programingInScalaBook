import org.specs2.mutable._
import chapter10.solTomySpiralElem.Elemento.elem

class ElementSpecefication extends Specification {
  "A UniformElement" should {
    "hace a width equals to the passed value" in {
      val ele = elem(3, 2, 'x')
      ele.anchura must be_==(2)
    }

    "have a length equals to the passed value" in {
      val ele = elem(3, 2, 'x')
      ele.longitud must be_==(3)
    }

    "trow a Execp when passed a negative length" in {
      elem(-3, 2, 'x') must
        throwA[ArrayIndexOutOfBoundsException]
    }
  }
}
