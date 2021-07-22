val l = List(1, 2, 3, 4, 5)

l.map(_ + 1)

val fox = List("the", "quick", "brown", "fox")

fox.map(_.length)
fox.map(_.toList.reverse.mkString)

List.range(1, 5) flatMap {
  i => List.range(1, i) map (j => (i, j))
}

for (i <- 1 until 5;
     j <- 1 until i) yield (i, j)

(1 until 2).toList

var sum = 0
l foreach (sum += _)

l.filter(_ % 2 == 0)

fox.filter(_.length > 3)

val p: Int => Boolean = x => x % 2 == 0

(l filter p, l filter (!p(_)))

l partition p

fox find (_.length > 3) match {
  case Some(ele) => ele
  case None => "meh"
}
