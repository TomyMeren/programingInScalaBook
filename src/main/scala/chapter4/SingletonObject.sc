import scala.collection.mutable

class CheckSumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = sum += b

  def checkSum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new CheckSumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }

  def checkCache: mutable.Map[String, Int] = cache
}

val a = ChecksumAccumulator
a.calculate("Every value ")
a.checkCache
a.calculate("Every value ")
a.checkCache
a.calculate("Is an object")
a.checkCache
