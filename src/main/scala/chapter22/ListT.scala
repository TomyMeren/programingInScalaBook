package chapter22

import scala.collection.mutable.ListBuffer

abstract class ListT[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: ListT[T]

  def length: Int = if (isEmpty) 0 else 1 + tail.length

/*  def drop(n: Int): ListT[T] = {
    if (isEmpty) NilT
    else if(n == 0) tail
    else ::(head,tail.drop(n-1))
  }*/

  def map[U](f:T => U):List[U] = {
    val b = new ListBuffer[U]
    var these = this
    while(!these.isEmpty) {
      b += f(head)
      these = these.tail
    }
    b.toList
  }
}
