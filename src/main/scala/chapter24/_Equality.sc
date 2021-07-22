val str = "Hello"
str.reverse
str.map(_.toUpper)
str drop 3
str slice (1,3)
val s :Seq[Char] = str


import scala.collection.mutable
import scala.collection.mutable._

val buff = ArrayBuffer(1,2,3)
val map = mutable.HashMap(buff -> 3)

map(buff)
buff += 1

map(buff)
