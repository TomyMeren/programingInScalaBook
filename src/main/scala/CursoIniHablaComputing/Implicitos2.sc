/**
 * Type Clases. Especificamos de que tipo desciende el tipo generico
 */

def aggregate[T](elements: List[T])(zero: T, combine: (T, T) => T): T =
  elements match {
    case Nil => zero
    case head :: tail => combine(head, aggregate(tail)(zero, combine))
  }

aggregate(List(1,2,3))(1, _ * _)
aggregate(List("h", "o", "l", "a"))("", _ + _)

trait Aggregatable[T] {
  val zero:T
  def combine(a1:T,a2:T):T
}

object Aggregatable {
  implicit object sumIn extends Aggregatable[Int] {
    val zero: Int = 0
    def combine(a1: Int, a2: Int): Int = a1 + a2
  }

  implicit object sumString extends Aggregatable[String] {
    val zero: String = ""
    def combine(a1: String, a2: String): String = a1 + a2
  }
}

def aggregate[T](elements: List[T])(implicit agg:Aggregatable[T]): T =
  elements match {
    case Nil => agg.zero
    case head :: tail => agg.combine(head, aggregate(tail))
  }

aggregate(List(1,2,3))

def aggregate[T: Aggregatable](elements: List[T]): T =
  elements match {
    case Nil => implicitly[Aggregatable[T]].zero
    case head :: tail => implicitly[Aggregatable[T]].combine(head, aggregate(tail))
  }

aggregate(List(1,2,3))