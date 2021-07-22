import cats.Functor

/*trait Applicative[F[_]] extends Functor[F] {

  def ap[A,B](ff: F[A => B])(fa: F[A]): F[B]

  def pure[A](a:A):F[A]

  def map[A, B](fa: F[A])(f: A => B): F[B] = ap(pure(f))(fa)
}*/

trait Applicative[F[_]] extends Functor[F] {

  def product[A,B](fa: F[A], fb: F[B]): F[(A,B)]

  def pure[A](a:A):F[A]
}

implicit def applicativeForEither
