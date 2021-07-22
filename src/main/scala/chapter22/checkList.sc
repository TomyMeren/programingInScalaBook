import chapter22._

val l = ::(0,::(1,::(2,  NilT )))

l.length

l.drop(0)

l.map(_ + 1)


1 :: List(3)

abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit


val apples = ::(new Apple,  NilT)

::(new Orange, apples)

def incAll(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => x + 1 :: incAll(xs1)
}
