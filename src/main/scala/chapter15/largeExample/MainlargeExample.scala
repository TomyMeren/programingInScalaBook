package chapter15.largeExample

import chapter15._

object MainlargeExample extends App {
  val f = new HorizonalLayout

  val exp: Expr =
    BinOp("+",
      BinOp("*",
        BinOp("+", Var("x"), Var("y")),
        Var("z")),
      Number(1))

  val exp2: Expr =
    UnOp("==>",
        BinOp("+", Number(3), Number(4)))

  val exp3: Expr =
    BinOp("/", BinOp("*",Var("z"),Var("y")),
      BinOp("/",Var("x"),
        Number(1)
      )
    )

  val exp4: Expr =
    BinOp("*", BinOp("*",Var("z"),Var("y")),
      BinOp("*",Var("x"),Var("p")))

  val exp5: Expr =BinOp("-", Var("a"), BinOp("-", Var("b"), Var("c")))

  //(x + y) * z +1
  //2 * (3 + 4)
  
for (num <- Array(exp,exp2,exp3,exp4,exp5))
  println(f.format(num,0) + "\n")
  
}
