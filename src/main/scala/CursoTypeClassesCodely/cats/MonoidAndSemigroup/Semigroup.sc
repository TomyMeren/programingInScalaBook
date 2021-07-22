/**
 * trait SemiGroup[A] {
 * def combine(x: A, y: A): A
 * } */

import cats.Semigroup

implicit val sumInt: Semigroup[Int] = new Semigroup[Int] {
  def combine(x: Int, y: Int): Int = x * y
}

/*implicit def sumMap[A,B]: Semigroup[Map[A,B]] = new Semigroup[Map[A,B]] {
  def combine(x: Map[A,B], y: Map[A,B]): Map[A,B] = x + y
}*/

val x = 1
val y = 2
val z = 3

Semigroup[Int].combine(x, Semigroup[Int].combine(y, z)) ==
  Semigroup[Int].combine(Semigroup[Int].combine(x, y), z)

import cats.implicits._

Semigroup[Int].combine(x, y)
x |+| y

val map1 = Map("hello" -> 1, "world" -> 1)
val map2 = Map("hello" -> 2, "cats" -> 3)

Semigroup[Map[String,Int]].combine(map1, map2)
map1 |+| map2
"hola" |+| "adios"

Semigroup[Int]
Semigroup[String]

trait Foo
Semigroup[List[Foo]]
Semigroup[(List[Foo],Int)]



