class Point(val x: Int, val y: Int)

object Point {
  def point(x:Int,y:Int):Point = new Point(x,y)
}

class Rectangle(val topLeft: Point, val bottonRight: Point) {
  def left: Int = topLeft.x
  def right: Int = bottonRight.y
  def width = right - left
}

abstract class Component  {
  def topLeft: Point
  def bottonRight: Point
  def left: Int = topLeft.x
  def right: Int = bottonRight.y
  def width: Int = right - left
}

trait Rectangular {
  def topLeft: Point
  def bottonRight: Point
  def left: Int = topLeft.x
  def right: Int = bottonRight.y
  def width: Int = right - left
}

abstract class Component2 extends Rectangular
class Rectangle2(val topLeft: Point, val bottonRight: Point) extends Rectangular {

}

import Point.point

val rec:Rectangular = new Rectangle2(point(1,2),point(3,4))

rec.topLeft.y

