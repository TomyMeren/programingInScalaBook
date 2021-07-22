trait Monoid[A] {
  def empty: A

  def combine(x: A, y: A): A
}

final case class Pair[A, B](first: A, second: B)

object Pair {
  implicit def tuple2Instance[A, B](implicit A: Monoid[A], B: Monoid[B]): Monoid[Pair[A, B]] =
    new Monoid[Pair[A, B]] {
      def empty: Pair[A, B] = Pair(A.empty, B.empty)
      def combine(x: Pair[A, B], y: Pair[A, B]): Pair[A, B] =
        Pair(A.combine(x.first, y.first), B.combine(x.second, y.second))
    }
}

implicit val intAdditionMonoid: Monoid[Int] = new Monoid[Int] {
  def empty: Int = 0
  def combine(x: Int, y: Int): Int = x + y
}

implicit val StringAdditionMonoid: Monoid[String] = new Monoid[String] {
  def empty: String = ""
  def combine(x: String, y: String): String = x + y
}

def combineAll[A](list: List[A])(implicit m: Monoid[A]): A = list.foldRight(m.empty)(m.combine)

combineAll(List(Pair(1, "2"), Pair(2, "4"), Pair(3, "5")))


def implicitly[A](implicit ev: A): A = ev

def combineAllSugar[A : Monoid](list: List[A]): A =
  list.foldRight(implicitly[Monoid[A]].empty)(implicitly[Monoid[A]].combine)


combineAllSugar(List(Pair(1, "2"), Pair(2, "4"), Pair(3, "5")))