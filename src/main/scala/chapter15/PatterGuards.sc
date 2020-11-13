import chapter15._

def simplyfyAdd(e: Expr): Expr = e match {
  case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  case _ => e
}

simplyfyAdd(BinOp("+", Number(2), Number(2)))

def simplifyAll(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) =>
    simplifyAll(e) // `-' is its own inverse
  case BinOp("+", e, Number(0)) =>
    simplifyAll(e) // `0' is a neutral element for `+'
  case BinOp("*", e, Number(1)) =>
    simplifyAll(e) // `1' is a neutral element for `*'
  case UnOp(op, e) =>
    UnOp(op, simplifyAll(e))
  case BinOp(op, l, r) =>
    BinOp(op, simplifyAll(l), simplifyAll(r))
  case _ => expr
}

def simplifyBad(expr: Expr): Expr = expr match {
  case UnOp(op, e) => UnOp(op, simplifyBad(e))
  case UnOp("-", UnOp("-", e)) => e
}
