package chapter19

class QueueVarian[+T] (
  private[this] var leading: List[T],
  private[this] var trailing: List[T]) {

  private def mirror(): Unit = {
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  }

  def head: T = {
    mirror()
    leading.head
  }
  def tail: QueueVarian[T] = {
    mirror()
    new QueueVarian[T](leading.tail, trailing)
  }

  def enqueue[U >: T](x: U): QueueVarian[U] = new QueueVarian(leading, x :: trailing)

  override def toString = (leading ::: trailing.reverse).mkString("QueueVarian" + "(", ", ", ")")
}

