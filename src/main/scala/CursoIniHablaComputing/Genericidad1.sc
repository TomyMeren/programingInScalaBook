
sealed abstract class IntList
case class End() extends IntList
case class Cons(head: Int, tail: IntList) extends IntList

def addFive(n: Int, list: IntList): IntList =
  list match {
    case End() => Cons(n, End())
    case Cons(head, tail) => Cons(head, addFive(n, tail))
  }


//generacidad

sealed abstract class List[A]
case class End[A]() extends List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]

def add[A](n: A, list: List[A]): List[A] =
  list match {
    case End() => Cons(n, End())
    case Cons(head, tail) => Cons(head, add(n, tail))
  }

def addNumber[Int](n: Int, l: List[Int]): List[Int] = add(n, l)
def addString[String](n: String, l: List[String]): List[String] = add(n, l)


///////////////////////////////////////////////////////////////////////

class Complex(val real: Double, val img: Double)
class Real(val value: Double) extends Complex(value, 0.0)
class Rational(val num: Int, val den: Int) extends Real(num / den)
class IntegerN(val int: Int) extends Rational(int, 1)
class Natural(val nat: Int) extends IntegerN(nat.abs)

val `1+2i`: Complex = new Complex(1.0, 2.0)
val π: Real = new Real(3.1415)
val `2/3`: Rational = new Rational(2, 3)
val `-1`: IntegerN = new IntegerN(-1)
val `1`: Natural = new Natural(1)

/**
 * Herencia
 */
def foo(c: Rational): Rational = c

foo(`2/3`)
foo(`-1`)
foo(`1`)

//FALLA
// foo(`1+2i`)
// foo(π)

/**
 * Variancia y covariancia
 */

def foo(f: Rational => Rational): Rational =
  f(new Rational(4, 2))

val times2: Rational => Rational =
  r => new Rational(r.num * 2, r.den)
foo(times2) //Bien

val idiv: Rational => IntegerN =
  r => new IntegerN(r.num/r.den)
foo(idiv) // Devolvemos una clase que hereda de Rational =>  Bien

val rr2: Real => Rational =
  _ => new Rational(0,1)
foo(rr2) //Pasamos una clase que es superclase de Rational => Bien

val rr3: Natural => Rational = _ => new Rational(0,1)
//foo(rr2) //Pasamos una clase que hereda de Rational => Mal

val rr4: Rational => Complex = _ => new Complex(0.0, 0.0)
//foo(rr4)// Devolvemos una clase que es super clase de Rational =>  Bien