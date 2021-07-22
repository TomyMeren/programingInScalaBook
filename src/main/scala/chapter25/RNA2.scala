package chapter25

import collection.IndexedSeqLike
import collection.mutable.{Builder, ArrayBuffer}
import collection.generic.CanBuildFrom

final class RNA2 private(val groups: Array[Int], val length: Int) extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA2] {

  import chapter25.RNA2._

  override def newBuilder: Builder[Base, RNA2] =
    new ArrayBuffer[Base] mapResult fromSeq

  override def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx) {
      throw new IndexOutOfBoundsException
    }

    Base.fromInt(groups(idx / N) >> (idx % N * S) & M) //??? Le pasas el ind y devuelve una BASE
  }
}

object RNA2 {
  // Number of bits necessary to represent group
  private val S = 2

  // Number of groups that fit in an Int
  private val N: Int = 32 / S

  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: Seq[Base]): RNA2 = {
    val groups = new Array[Int]((buf.length + N - 1) / N) //Para buf = Seq(T,T,A,U) => 1, Seq(..).lenght = 17 => 2,...
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S) //Le pasas una Seq[Base] y devuelve una RNA2 (conjunto de Base)

    new RNA2(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}