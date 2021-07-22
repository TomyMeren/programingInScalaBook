def sumInts(list: List[Int]): Int = list.foldRight(0)(_ + _)

def concatStrings(list: List[String]): String = list.foldRight("")(_ ++ _)

def unionSets[A](list: List[Set[A]]): Set[A] = list.foldRight(Set.empty[A])(_ union _)


sumInts(List(1, 2, 3, 4))
concatStrings(List("1", "2", "3", "4"))
unionSets(List(Set(1, 2), Set(3), Set(4)))

trait Monoid[A] {
  def empty: A

  def combine(x: A, y: A): A
}

// Implementation for Int
val intAdditionMonoid: Monoid[Int] = new Monoid[Int] {
  def empty: Int = 0

  def combine(x: Int, y: Int): Int = x + y
}

def combineAll[A](list: List[A], m: Monoid[A]): A = list.foldRight(m.empty)(m.combine)

combineAll(List(1, 2, 3, 4), intAdditionMonoid)

def combineAll[A <: Monoid[A]](list: List[A]): A = ???

