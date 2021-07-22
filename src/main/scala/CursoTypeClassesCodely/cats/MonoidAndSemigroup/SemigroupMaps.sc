import cats.Semigroup
import cats.implicits._

val ym1 = Map(1 -> List("hello"))
val ym2 = Map(2 -> List("cats"), 1 -> List("world"))

val ym3 = Map(1 -> "hello")
val ym4 = Map(2 -> "cats", 1 -> "world")

def optionCombine[A: Semigroup](value: A, opt: Option[A]): A = {
  opt.map(value |+| _).getOrElse(value)
}

def mergeMap[K, V: Semigroup](xs: Map[K, V], xy: Map[K, V]): Map[K, V] = {
  xs.foldLeft(xy) {
    case (acc, (k, v)) => acc.updated(k, optionCombine(v, acc.get(k)))
  }
}

mergeMap(ym1, ym2)
mergeMap(ym3, ym4)