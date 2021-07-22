package chapter25

import collection.{IndexedSeqLike, mutable}
import collection.mutable.{ArrayBuffer, Builder}
import collection.generic.CanBuildFrom

final class RNA private(val groups: Array[Int], val length: Int) extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA] {

  import chapter25.RNA._

  override protected[this] def newBuilder: Builder[Base, RNA] =
    RNA.newBuilder

  override def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx) {
      throw new IndexOutOfBoundsException
    }

    Base.fromInt(groups(idx / N) >> (idx % N * S) & M) //??? Le pasas el ind y devuelve una BASE
  }

  override def foreach[U](f: Base => U): Unit = {
    var i = 0
    var b = 0
    while (i < length) {
      b = if (i % N == 0) groups(i / N) else b >>> S
      f(Base.fromInt(b & M))
      i += 1
    }
  }
}

object RNA {
  // Number of bits necessary to represent group
  private val S = 2

  // Number of groups that fit in an Int
  private val N: Int = 32 / S

  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: Seq[Base]): RNA = {
    val groups = new Array[Int]((buf.length + N - 1) / N) //Para buf = Seq(T,T,A,U) => 1, Seq(..).lenght = 17 => 2,...
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S) //Le pasas una Seq[Base] y devuelve una RNA (conjunto de Base)

    new RNA(groups, buf.length)
  }

  def newBuilder: Builder[Base, RNA] =
    new ArrayBuffer[Base] mapResult fromSeq

  implicit def canBuildFrom: CanBuildFrom[RNA, Base, RNA] =
    new CanBuildFrom[RNA, Base, RNA] {
      override def apply(from: RNA): mutable.Builder[Base, RNA] = newBuilder
      override def apply(): mutable.Builder[Base, RNA] = newBuilder
    }

  def apply(bases: Base*) = fromSeq(bases)
}