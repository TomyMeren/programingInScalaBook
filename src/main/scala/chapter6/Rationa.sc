class Rational(n: Int, d: Int) extends Ordered[Rational]{
  require(d != 0)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val deno: Int = d / g

  override def toString: String =
    if(deno == 1) numer.toString else  s"$numer/$deno"

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(numer * that.deno + deno * that.numer,
      deno * that.deno)

  def + (i:Int): Rational = new Rational(numer  + i * deno , deno)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, deno * that.deno)

  def * (i:Int): Rational = new Rational(numer * i , deno)

  def lessThant(that: Rational): Boolean = {
    numer * that.deno < that.numer * this.deno
  }

  def max(that: Rational): Rational = {
    if (lessThant(that)) that else this
  }

  def compare(that: Rational):Int = this.numer * that.deno - that.deno * this.numer

 /* def < (that: Rational):Boolean = {
    this.numer * that.deno < that.deno * this.numer
  }

  def > (that: Rational): Boolean = that < this

  def <= (that: Rational): Boolean = (this < that) || (this == that)

  def >= (that: Rational): Boolean = (this > that) || (this == that)*/
}

implicit def intToRational(x :Int) = new Rational(x)

val r1: Rational = new Rational(5, 2)
val r2: Rational = new Rational(6, 3)
val r3: Rational = new Rational(2)

r1 + r2
r1.lessThant(r2)
r1.numer

r1 * r2 + r2
r2 + r2 * r1
r1 * 5

5 * r1

r2 <= r3

