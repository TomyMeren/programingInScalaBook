package chapter25

import chapter25.RNA1._

final class RNA1 (val groups: Array[Int], val length: Int) extends IndexedSeq[Base] {

  override def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx) {
      throw new IndexOutOfBoundsException
    }

    Base.fromInt(groups(idx / N) >> (idx % N * S) & M) //??? Le pasas el ind y devuelve una BASE
  }
}

object RNA1 {
  // Number of bits necessary to represent group
  private val S = 2

  // Number of groups that fit in an Int
  private val N: Int = 32 / S

  // Bitmask to isolate a group
  private val M = (1 << S) - 1

  def fromSeq(buf: Seq[Base]): RNA1 = {
    val groups = new Array[Int]((buf.length + N - 1) / N) //Para buf = Seq(T,T,A,U) => 1, Seq(..).lenght = 17 => 2,...
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S) //Le pasas una Seq[Base] y devuelve una RNA1 (conjunto de Base)

    new RNA1(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}