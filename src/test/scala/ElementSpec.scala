import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import chapter10.solTomySpiralElem.Elemento.elem

class ElementSpec extends AnyFlatSpec with Matchers  {
  "A UniformElement" should
    "hace a width equals to the passed value" in {
    val ele = elem(3, 2, 'x')
    ele.anchura should be(2)
  }
  it should "hace a long equals to the passed value" in {
    val ele = elem(3, 2, 'x')
    ele.longitud should be(3)
  }
  it should "throw an IAE if passed a negative width" in {
    an[ArrayIndexOutOfBoundsException] should be thrownBy {
      elem(-3, 2, 'x')
    }
  }
}
