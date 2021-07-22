//import chapter19.Queue

trait Queue[T] {
  def enqueue(x: T): Queue[T]
}

class StrangeIntQueue extends Queue[Int] {
  override def enqueue(x: Int): Queue[Int] = {
    math.sqrt(x)
      super.enqueue(x)
  }
}

val x :Queue[Any] = new StrangeIntQueue
x.enqueue("abc")