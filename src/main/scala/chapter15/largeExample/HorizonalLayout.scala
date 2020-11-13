package chapter15.largeExample

import chapter10.solTomySpiralElem.Elemento
import chapter10.solTomySpiralElem.Elemento.elem
import chapter15._

class HorizonalLayout {
  private val opGroups: Array[Set[String]] = Array(
    Set("|", "||"),
    Set("&", "&&"),
    Set("^"),
    Set("==", "!="),
    Set("<", "<=", ">", ">="),
    Set("+", "-"),
    Set("*", "%")
  )
  private val precedence: Map[String, Int] = {
    val assocs =
      for {
        i <- 0 until opGroups.length
        oper <- opGroups(i)
      } yield oper -> i
    assocs.toMap
  }
  private val fractionPrecedente = -1
  private val unaryPrecedence = opGroups.length

  /**
   * BinOp("+",
   * BinOp("*",
   * BinOp("+", Var("x"), Var("y")),
   * Var("z")),
   * Number(1))
   *
   * Deberia delvolver (x + y) * z +1
   */

  def format(expr: Expr, opNumPreced: Int): Elemento = expr match {
    case Var(str) => elem(str)
    case Number(n) => {
      val nStri = n.toString
      val nStrig2 = {
        if (nStri endsWith ".0") nStri.split('.')(0)
        else nStri
      }
      elem(nStrig2)
    }
    case UnOp(oper, postExpr) => elem(oper) unir format(postExpr, unaryPrecedence ) //TODO: unaryPrecedence

    case BinOp("/", prevExpr, postExpr) => {
      val top = format(prevExpr, fractionPrecedente)
      val bot = format(postExpr, fractionPrecedente)
      val line = elem(1,top.anchura max bot.anchura,'-')
      val frac = top join line join bot
      if(fractionPrecedente!= opNumPreced) frac
      else elem(" ") unir frac unir elem(" ")
    }
    case BinOp(oper, prevExpr, postExpr) => {
      val left = format(prevExpr, precedence(oper))
      val right = format(postExpr, precedence(oper) +1 ) // TODO: +1??
      if (opNumPreced > precedence(oper))
        elem("(") unir left unir elem(" " + oper + " ") unir right unir elem(")")
      else left unir elem(" " + oper +  " ") unir right
    }
  }
}
