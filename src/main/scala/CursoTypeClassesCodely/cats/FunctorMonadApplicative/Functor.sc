/*trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

  def lift[A, B](f: A => B): F[A] => F[B] =
    fa => map(fa)(f)
}

object Functor extends Functor[Option] {
  def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa match {
    case None => None
    case Some(value) => Some(f(value))
  }
}

Functor.map(Option(1))(_ + 1)
Functor.lift((_: Int) + 1)(Some(2))*/

//////////////////////////////////////////////////////////////////////

import cats.Functor
import cats.implicits._

val listOption = List(Some(1), None, Some(2))

Functor[List].compose[Option].map(listOption)(_ + 1)

def needsFunctor[F[_] : Functor, A](fa: F[A]): F[Unit] =
  Functor[F].map(fa)(_ => ())

def foo: List[Option[Unit]] = {
  val listOptionFunctor = Functor[List].compose[Option]
  type ListOption[A] = List[Option[A]]
  needsFunctor[ListOption, Int](listOption)(listOptionFunctor)
}


import cats.data.Nested

val nested: Nested[List, Option, Int] = Nested(listOption)
