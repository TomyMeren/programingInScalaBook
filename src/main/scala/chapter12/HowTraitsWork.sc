trait Philosophical {
  def plolosophize() = {
    println("I consume teory, therefor I am")
  }
}

class Animal
trait hasLeg
class Frog extends Animal with Philosophical with hasLeg {
  override def toString = "green"

  override def plolosophize(): Unit = println("It ain't easy being " + toString + "!")
}

val frog:Frog = new Frog
frog.plolosophize()

val phil:Philosophical = frog

phil.plolosophize()

class Point(x:Int, y:Int)

//trait NoPoint(x:Int,y:Int)