import scala.collection.mutable
import scala.reflect.ClassTag

val a1 = Array(1, 2, 3)
val a2: Seq[Int] = a1
val a3 = a2.toArray

a1 == a3

a2.reverse

val a4: mutable.ArrayOps[Int] = a1

a4.reverse


def eventElements[T:ClassTag](xs: Vector[T]): Array[T] = {
  val arr = new Array[T]((xs.length + 1) / 2)
  for (i <- 0 until xs.length by 2) {
    arr(i/2) = xs(i)
  }
  arr
}

eventElements[Int](Vector(1,2,3,4,5))