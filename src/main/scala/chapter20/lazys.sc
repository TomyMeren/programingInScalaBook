object demo {
  lazy val x: String = {
    println("estoy inciializado!")
    "done"
  }
}

demo

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int

  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }

  lazy val numer = numerArg / g
  lazy val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = numer + "/" + denom
}

val x = 2

new RationalTrait {
  val numerArg: Int = 1 + x
  val denomArg: Int = 2 + x
}