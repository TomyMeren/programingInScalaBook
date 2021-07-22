package chapter22

/*
case object NilT extends ListT[Nothing] {
  def isEmpty: Boolean = true
  def head:Nothing = throw new NoSuchElementException("No se puede obtener el head de una lista vacia")
  def tail:ListT[Nothing] = throw new NoSuchElementException("No se puede obtener el tail de una lista vacia")
}

final case class ::[T](hd:T, private[scala] var tl:ListT[T]) extends ListT[T] {
  def head = hd
  def tail = tl
  def isEmpty: Boolean = false
}*/
