package chapter15.largeExample

import chapter15._


object Express extends App {
  import chapter15.largeExample.HorizonalLayout
  val f = new HorizonalLayout

  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
    BinOp("+", Var("x"), Number(1)))

  val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),
    BinOp("/", Number(1.5), Var("x")))

  val e3 = BinOp("/", e1, e2)

  def show(e: Expr) = println(f.format(e,0)+ "\n\n")

  for (e <- Array(e1, e2, e3)) show(e)
}
