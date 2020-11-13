sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr

def describe(e: Expr): String =  0(e: @unchecked) match {
  case Number(_) => "a is a number"
  case Var(_) => "a is a String"
}

describe(UnOp("+",Number(2)))