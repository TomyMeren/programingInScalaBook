object Tomy {
  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)

  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)

  val funValue = nestedFun _

  def nestedFun(x:Int):Unit = {
    if(x !=0) {println(x); funValue(x-1)}
  }
}

Tomy.isEven(2)
Tomy.nestedFun(5)