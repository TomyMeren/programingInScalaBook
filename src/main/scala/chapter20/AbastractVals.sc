trait Abstract {
  type T
  def transform(x: T): T
  val ini: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val ini = "HI"
  var current = ini
}

trait RationalTrait {
  val numberArgs: Int
  val denomArgs: Int
}

val t = new RationalTrait {
  val numberArgs: Int = 1
  val denomArgs: Int = 2
}

//(new Concrete).ini
t.denomArgs

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = numer + "/" + denom
}

val x: Int = 2

new {
  val numerArg: Int = 1 + x
  val denomArg: Int = 2 + numerArg
} with RationalTrait

object twoThirds extends {
  val numerArg: Int = 1 + x
  val denomArg: Int = 2 + x
} with RationalTrait

class RationalClass(n: Int, d: Int) extends {
  val numerArg: Int = n
  val denomArg: Int = d
  val tomy = "tomy"
} with RationalTrait {
  def +(that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}

new RationalClass(1 + x, 2 + x)

new RationalTrait {
  val numerArg: Int = 1 + x
  val denomArg: Int = 2 + x
}