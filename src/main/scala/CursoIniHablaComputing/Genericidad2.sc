class Complex(val real: Double, val img: Double)
class Real(val value: Double) extends Complex(value, 0.0)
class Rational(val num: Int, val den: Int) extends Real(num / den)
class IntegerN(val int: Int) extends Rational(int, 1)
class Natural(val nat: Int) extends IntegerN(nat.abs)

val com: Complex = new Complex(1.0, 2.0)
val pi: Real = new Real(3.1415)
val dosTercios: Rational = new Rational(2, 3)
val menosUno: IntegerN = new IntegerN(-1)
val uno: Natural = new Natural(1)

/**
 *  Genericidady coleciones <: y :>
 */
sealed abstract class MyList[+A]
case class End[A]() extends MyList[A]
case class Cons[A](head: A, tail: MyList[A]) extends MyList[A]

val a: MyList[Rational] = Cons(uno, Cons(menosUno, Cons(dosTercios, End())))

def prependDosTercios(l: MyList[Rational]): MyList[Rational] = Cons(dosTercios, l)

prependDosTercios(a)

val b: MyList[IntegerN] = Cons(menosUno, End())
prependDosTercios(b)

def prepend[A](a: A, l: MyList[A]): MyList[A] = {
  Cons(a, l)
}

prepend(menosUno,b)
prepend(pi,b)
prepend(uno,b)


sealed abstract class MyList[+A] {
  def prepend[B >: A](a: B): MyList[B] = {
    Cons(a, this)
  }
}
case class End[A]() extends MyList[A]
case class Cons[A](head: A, tail: MyList[A]) extends MyList[A]

val b: MyList[IntegerN] = Cons(menosUno, End())

b.prepend[IntegerN](menosUno)
b.prepend[Real](pi)
b.prepend/*[Natural]*/(uno)

def prependS[N <: Rational](l: MyList[N], r: N): MyList[N] =
  Cons(r, l)

prependS(b, menosUno)
//prependS(b, pi)
prependS(b, dosTercios)
prependS(b, uno)

def prependR(a: Rational, l: MyList[Rational]): MyList[Rational] = {
  Cons(a, l)
}

prependR(menosUno,b)
//prependR(pi,b)
prependS(b, dosTercios)
prependR(uno,b)