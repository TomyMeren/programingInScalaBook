import cats.Monoid
import cats.data.NonEmptyList
//import cats.implicits._



val list = List(NonEmptyList(1, List(2, 3)), NonEmptyList(4, List(5, 6)), NonEmptyList(7, List(8, 9)))

val lifted: List[Option[NonEmptyList[Int]]] = None :: list.map(nel => Option(nel)) ++ List(None)

Monoid.combineAll(lifted): Option[NonEmptyList[Int]]

