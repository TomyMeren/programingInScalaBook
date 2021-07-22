package chapter19

trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def enqueue[U >:T](x: U): Queue[U]
}
object Queue {
  def apply[T](xs: T*):Queue[T] = new QueueImplt[T](xs.toList, Nil)

  private class QueueImplt[+T](
    val leading: List[T],
    val trailing: List[T])
    extends Queue[T] {

    private def mirror: QueueImplt[T] = {
      if (leading.isEmpty)
        new QueueImplt[T](trailing.reverse, Nil)
      else
        this
    }

    def head: T = mirror.leading.head
    def tail: Queue[T] = new QueueImplt[T](mirror.leading.tail, mirror.trailing)
    def enqueue[U >:T](x: U): Queue[U] = new QueueImplt(leading, x :: trailing)

    override def toString = (leading ::: trailing.reverse).mkString("Queue" + "(", ", ", ")")
  }
}