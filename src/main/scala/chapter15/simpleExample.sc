abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Number(0)) => e
  case BinOp("*", e, Number(1)) => e
  case _ => expr
}
def simplifyTop2(expr: Expr): Unit = expr match {
  case UnOp(a, e) => a + e
  case BinOp(_, _, _) =>
    println(expr + "is a binary operation")
  case _ =>
}

val v = Var("x")
val op = BinOp("+", Number(1), v)

simplifyTop(UnOp("-", UnOp("-", Var("x"))))

v.name
op.left
op
op.right == Var("x")
op.copy(right = Number(2))
