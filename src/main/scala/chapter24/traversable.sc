val a: Traversable[Int] = Traversable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

a ++ Traversable(4)

val divide: PartialFunction[Int, Int] = {
  case d: Int if d != 0 => 42 / d
}

val divide2: PartialFunction[Int, Int] = {
  case d: Int if d != 0 => 42 / d
}

a
a.collect(divide2)

a.headOption

List("a", "b", "c", "d").slice(2, 4)

a.takeWhile(_ % 2 != 0)

a.dropWhile(_ % 2 != 0)
a.withFilter(_ % 2 == 0).map(_ + 1)
a.filter(_ % 2 == 0)

a.splitAt(2)

a.span(n => n < 3)
a.partition(_ % 2 == 0)
a.groupBy(_  % 5)

a.forall( _ < 11)
a.exists(_ > 9)
a.count(_ < 5)

a.foldLeft(0)(_ + _)
a.foldRight(0)(_ + _)
a.reduceLeft(_ + _)
a.reduceRight(_ + _)

a.sum
a.min
a.max
a.product
val sb = new StringBuilder("Tomy> ")
a.addString(sb,"numeros! => ",":"," Fin!")

a.mkString("Go! => ", ","," .")
a.stringPrefix
a.view(1,3)

val y = sb += '<'

