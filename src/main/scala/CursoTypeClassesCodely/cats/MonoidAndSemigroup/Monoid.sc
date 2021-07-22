import cats.Monoid
import cats.Semigroup
import cats.implicits._

val x = 1

Monoid[Int].combine(Monoid[Int].empty, x)

Monoid[Int].combine(x, Monoid[Int].empty)

def combineAll[A: Monoid](list: List[A]): A = {
  list.foldLeft(Monoid[A].empty)(Monoid[A].combine)
}

combineAll(List(1, 2, 3, 4, 5))
combineAll(List("hello", " ", "world"))
combineAll(List(Map('a' -> 1), Map('a' -> 2, 'b' -> 3), Map('b' -> 4, 'c' -> 5)))
combineAll(List(Set(1, 2), Set(2, 3, 4, 5)))

final case class NonEmptyList[A](head: A, tail: List[A]) {
  def ++(other: NonEmptyList[A]): NonEmptyList[A] = NonEmptyList(head, tail ++ other.toList)

  def toList: List[A] = head :: tail
}

object NonEmptyList {
  implicit def nonEmptyListSemigroup[A]: Semigroup[NonEmptyList[A]] =
    new Semigroup[NonEmptyList[A]] {
      def combine(x: NonEmptyList[A], y: NonEmptyList[A]): NonEmptyList[A] = x ++ y
    }
}

//NonEmptyList(1,List(2,3)).combine(NonEmptyList(4,List(5,6)))

Semigroup.combine(NonEmptyList(1,List(2,3)),NonEmptyList(4,List(5,6)))

val list = List(NonEmptyList(1, List(2, 3)), NonEmptyList(4, List(5, 6)), NonEmptyList(7, List(8, 9)))
//Monoid.combineAll(list)

//Al no tener un elemento zero no podemos colapsar el resultado de un Monoid de Listas de listas llenas
// Usamos el Monoid Option para usar el None como elemento zero

implicit def optionMonoid[A: Semigroup]: Monoid[Option[A]] = new Monoid[Option[A]] {
  def empty: Option[A] = None

  def combine(x: Option[A], y: Option[A]): Option[A] =
    x match {
      case None => y
      case Some(xv) =>
        y match {
          case None => x
          case Some(yv) => Some(xv |+| yv)
        }
    }
}

import cats.Semigroup.combineAllOption

val list = List(NonEmptyList(1, List(2, 3)), NonEmptyList(4, List(5, 6)), NonEmptyList(7, List(8, 9)))
val lifted: List[Option[NonEmptyList[Int]]] = list.map(nel => Option(nel))
Monoid.combineAll(lifted): Option[NonEmptyList[Int]]

