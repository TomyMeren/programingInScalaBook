import math.abs

def nquens(k: Int): Set[List[Int]] = { //Int = num of row

  def isSafe(i: Int, l: List[Int]): Boolean = {
    if (l.isEmpty) true
    else {
      math.abs(l.head - i) > 1 && !l.contains(i)
    }
  }

  def Placequens(n: Int): Set[List[Int]] = {
    if (n == 0) Set(List())
    else {
      for {
        q <- Placequens(n - 1)
        r <- 0 until k
        if isSafe(r, q)
      } yield r :: q
    }
  }
  Placequens(k)
}

nquens(5)

def isSafeOdersky(col: Int, queens: List[Int]): Boolean = {
  val row: Int = queens.length
  val queensWithRows = (row -1 to 0 by -1) zip queens
  println(queensWithRows)
  queensWithRows.forall{
    case (r,c) => col != c && abs(col - c)!= row -r
  }
}
isSafeOdersky(2,List(0,3,1))

