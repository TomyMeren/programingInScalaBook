def incAll(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => x + 1 :: incAll(xs1)
}

val l = List(1,2,3,4)
incAll(l)

def inefct(l:List[Int]) = {
  var result = List[Int]()
  for (x <- l) result =  result ::: List(x + 1)
  result
}

inefct(l)

import scala.collection.mutable.ListBuffer

def efct(l:List[Int]) = {
  val result = new ListBuffer[Int]
  for (x <- l) result +=  x + 1
  result.toList
}

efct(l)

l.map