abstract class Element {
  def demo() = {
    println("Element's implementation invoke")
  }
}

class ArrayElement extends Element { //final
   override def demo() = { //final
    println("ArrayElement's implementation invoke")
  }
}

class LineElement extends ArrayElement {
  override def demo() = {
    println("LineElement's implementation invoke")
  }
}

class UniformElement extends Element

def invokeDemo(e: Element) = {
  e.demo()
}
invokeDemo(new ArrayElement)
invokeDemo(new LineElement)
invokeDemo(new UniformElement)