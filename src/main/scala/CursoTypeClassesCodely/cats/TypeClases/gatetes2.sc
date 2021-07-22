trait Monoid[A] {
  def empty: A

  def combine(x: A, y: A): A
}

final case class Pair[A, B](first: A, second: B)

/*final case class Pair[A <: Monoid[A], B <: Monoid[B]](first:  A, second: B) extends Monoid[Pair[A,B]] {
  def empty: Pair[A,B] = ???
  def combine(x: Pair[A, B], y: Pair[A, B]): Pair[A,B] = ???
}*/

/*
final case class Pair[A , B](first:  A , second: B) extends Monoid[Pair[A,B]] {
  def empty(implicit eva: A <:< Monoid[A], evb: B <:< Monoid[B]): Pair[A,B] = ???
  def combine(x: Pair[A, B], y: Pair[A, B])(implicit eva: A <:< Monoid[A], evb: B <:< Monoid[B]): Pair[A,B] = ???
}*/

val intAdditionMonoid: Monoid[Int] = new Monoid[Int] {
  def empty: Int = 0

  def combine(x: Int, y: Int): Int = x + y
}

def deriveMonoidPair [A,B](A:Monoid[A], B:Monoid[B]):Monoid[Pair[A,B]] = {
  new Monoid[Pair[A, B]] {
    def empty:Pair[A, B] = Pair(A.empty,B.empty)
    def combine(x: Pair[A, B], y: Pair[A, B]):Pair[A, B] =
      Pair(A.combine(x.first,y.first),B.combine(x.second,y.second))
  }
}
intAdditionMonoid.empty
intAdditionMonoid.combine(1,2)

val pairIntAdditionMonoid =  deriveMonoidPair(intAdditionMonoid,intAdditionMonoid)
pairIntAdditionMonoid.empty
pairIntAdditionMonoid.combine(Pair(1,3),Pair(2,4))

def combineAll[A](list: List[A], m: Monoid[A]): A = list.foldRight(m.empty)(m.combine)
combineAll(List(1, 2, 3, 4), intAdditionMonoid)
combineAll(List(Pair(1,2),Pair(2,4),Pair(3,5)),pairIntAdditionMonoid)
