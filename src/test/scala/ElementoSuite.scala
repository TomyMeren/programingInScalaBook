import org.scalatest.funsuite.AnyFunSuite
import chapter10.solTomySpiralElem.Elemento.elem
//import org.scalatest.diagrams.Diagrams._

class ElementoSuite extends AnyFunSuite {
  test("element result should have passed width") {
    //val ele = elem(3, 2, 'x')
    //assert(ele.anchura == 3)
    //assert(List(1,2,3).contains(4))
    //assertResult(2){ele.anchura}
    /*assertThrows[NegativeArraySizeException] {
          val arr = new Array[Int](-1)
      }*/
    val caught =
    intercept[ArithmeticException] {
      1 / 0
    }

    assert(caught.getMessage == "/ by zero")
  }
}
