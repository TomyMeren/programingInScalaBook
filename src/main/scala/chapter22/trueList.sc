abstract class ListT[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: ListT[T]

  def map[U](f: T => U): ListT[U] = {
    val b = ListBuffer[U]()
    var these = this
    while (!these.isEmpty) {
      b += f(these.head)
      these = these.tail
    }
    b.toList
  }
}

case object NilT extends ListT[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("No se puede obtener el head de una lista vacia")
  def tail: ListT[Nothing] = throw new NoSuchElementException("No se puede obtener el tail de una lista vacia")
}

final case class ::[U](hd: U, var tl: ListT[U]) extends ListT[U] {
  def head:U = hd
  def tail:ListT[U] = tl
  override def isEmpty: Boolean = false
}

final case class ListBuffer[T]() {
  var start: ListT[T] = NilT
  var last0: ::[T] = _
  var exported: Boolean = false

  //var last1: ::[T] = _

  def +=(x: T) = {
    if (exported) copy()
    if (start.isEmpty) {
      println("empty!!")
      last0 = ::(x, NilT)
      start = last0 //???
    } else {
      println("No empty!!")
      val last1 = last0
      last0 = ::(x, NilT)
      println("start1" +  start)
      println("last0" +  last0)
      println("last1" +  last1)
      last1.tl = last0
      println("start2" +  start)
      println("last0" +  last0)
      println("last1" +  last1)
    }
  }

  def toList: ListT[T] = {
    exported = !start.isEmpty
    start
  }

  private def copy() = println("Copiamos!")
}

::(3,::(2, ::(1, NilT))).map(_ + 1)

var last0  = ::(3, NilT)
var start = last0
var last1 = last0


last0 = ::(2,NilT)
last1.tl = last0

last0
last1
start

last1 = last0
last0 = ::(1,NilT)
last1.tl = last0

last0
last1
start

/*val last1 = last0
last0 = ::(2,NilT)
last1.tl = last0

val last2 = last0
last0 = ::(1,NilT)
last2.tl = last0*/


val b: ListBuffer[Int] = ListBuffer()

b.+=(2)
b.start
b.last0
b.exported

b.+=(3)
b.start
b.last0
b.exported


b.+=(4)
b.start
b.last0
b.exported


b.toList
b.start
b.last0
b.exported

