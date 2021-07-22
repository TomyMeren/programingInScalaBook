//implicit def convIntDouble (d:Double):Int = d.toInt

implicit val convIntDouble2: Double => Int = (d: Double) => d.toInt

val i: Int = 3.5

Map(1 -> "one")

for (a <- List(1, 2, 3)) yield a

case class Rectangle(width: Int, height: Int)

implicit class RectangleMaker(width: Int) {
  def x(height: Int) = new Rectangle(width, height)
}

4 x 5