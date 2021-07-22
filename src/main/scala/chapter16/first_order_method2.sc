val fruit = "apples" :: ("oranges" :: ("pinapple" :: Nil))

fruit.map(_.toCharArray).flatten
fruit.flatMap(_.toCharArray)

val abcde = List("a","b","c","d","e")

abcde zip abcde.indices

abcde zip (1 to 4)

abcde.zipWithIndex

val tupla = List(("hola",1),("adios",2),("buenas",3))

val (a, b) = tupla.unzip
a
b


fruit.mkString("frutas:", ", ", " fin")
fruit.mkString

val buf = new StringBuilder

abcde addString(buf,"(" ,", ",")")

val l = (1 to 5).toList

l.toArray

val arr2 = new Array[Int](4)

l copyToArray (arr2,1)

arr2

val it = abcde.iterator

it.next