package chapter18

class Thermometer {

  var celsius:Float = _

  def fharen = celsius * 9 /5 +32
  def fhren_ (f:Float) = {
    celsius = (f - 32) * 5  /9
  }

  override def toString = fharen + "F/" + celsius + "C/"
}
