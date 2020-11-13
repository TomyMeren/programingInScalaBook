def patt(expr: Any): String = expr match {
  case 0 => "zero"
  case someThingElse => "not Zero: " + someThingElse
}

patt(Nil)

import scala.math.{E, Pi}

val pi = Pi

E match {
  case `pi` => "Stranger math? Pi = " + Pi
  case _ => "OK"
}

abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr

def a(expr: Any): AnyVal = expr match {
  case BinOp("+", _, Number(i)) => i
  case _ =>
}

a(BinOp("+", Var("x"), Number(5)))

def b(expr: Any) = expr match {
  case List(0, _*) => "is a list how star with 0"
  case _ =>
}

b(List(0, 2))


def tupleDemo(tuple: Any) = tuple match {
  case (x, y, z) => println("match " + x + y + z)
  case _ =>
}

tupleDemo((1, "a", true))

def generalSize(x: Any): Any = x match {
  case s: String => s.length
  case n: Map[_, _] => n
  case l: List[_] => l(0)
  //case _:Map[String,_] => "mal"
  case _ => -1
}

generalSize(Map((1, "a")))
generalSize(Map("e" -> "rr"))
generalSize("mehh")
generalSize(List(1, 2, 3))
val x = "jjeje"

if (x.isInstanceOf[Int]) x + 2
else x + "megg"

def c(expr: Any) = expr match {

  case UnOp("abs", e @ UnOp("a", _)) => e
  case _ =>
}

def d(expr: Any) = expr match {

  case UnOp("abs", ex:UnOp) => ex
  case _ =>
}

c(UnOp("abs",UnOp("ar",Var("e"))))
d(UnOp("abs",UnOp("ar",Var("e"))))