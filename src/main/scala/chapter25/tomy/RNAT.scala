package chapter25.tomy

import chapter25.tomy.RNAT

class RNAT(groups: Array[Int], val length: Int) extends IndexedSeq[BaseT] {

  def apply(n: Int): BaseT = {
    if (n < 0 || n >= length)
      throw new IndexOutOfBoundsException
    AT
  }
}
