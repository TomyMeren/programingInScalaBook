import java.awt.Color
import java.awt.Color.white

object Problem {
  trait Pet {
    def name: String
    def renamed(newName: String): Pet
  }

  case class Fish(name: String, age: Int) extends Pet {
    def renamed(newName: String): Fish = copy(name = newName)
  }

  case class Kitty(name: String, color: Color) extends Pet {
    def renamed(newName: String): Fish = Fish(newName, 42) // oops
  }

  val a = Fish("Tommy", 30)
  val b = a.renamed("Bego")

  //def esquire[A <: Pet](a: A): A = a.renamed(a.name + ", Esq.")
}
//////////////////////////////////////////////////////////////////////////

object FBound {
  trait Pet[A <: Pet[A]] {
    this: A => // s
    def name: String
    def renamed(newName: String): A
  }

  case class Fish(name: String, age: Int) extends Pet[Fish] {
    def renamed(newName: String): Fish = copy(name = newName)
  }
  val a = Fish("Tommy", 30)
  val b = a.renamed("Bego")

  def esquire[A <: Pet[A]](a: A): A = a.renamed(a.name + ", Esq.")

  esquire(a)

  case class Kitty(name: String, color: Color) extends Pet[Kitty] {
    def renamed(newName: String): Kitty = Kitty(newName, white) // oops
  }

  class Mammal(val name: String) extends Pet[Mammal] {
    def renamed(newName: String) = new Mammal(newName)
  }

  class Monkey(name: String) extends Mammal(name)
}

/////////////////////////////////////////////////////////////////////////////////////

object TypeClass {
  trait Pet {
    def name: String
  }

  trait Rename[A] {
    def renamed(a: A, newName: String): A
  }

  case class Fish(name: String, age: Int) extends Pet

  object Fish {
    implicit val FishRename: Rename[Fish] = new Rename[Fish] {
      def renamed(a: Fish, newName: String): Fish = a.copy(name = newName)
    }
  }

  implicit class RenameOps[A](a: A)(implicit ev: Rename[A]) {
    def renamed(newName: String) = ev.renamed(a, newName)
  }

  val a = Fish("Tommy", 30)
  val b = a.renamed("Bego")
  //val c = new RenameOps(a)(Fish.FishRename).renamed("Bego")

  def esquire[A <: Pet : Rename](a: A): A = a.renamed(a.name + ", Esq.")
  esquire(a)
}
/////////////////////////////////////////////////////////////////////////////////////

trait Pet[A] {
  def name(a:A): String
  def renamed (a:A, newName: String): A
}

implicit class PetOps[A](a: A)(implicit ev: Pet[A]) {
  def name = ev.name(a)
  def renamed(newName: String) = ev.renamed(a, newName)
}

case class Fish(name: String, age: Int)

object Fish {
  implicit val FishPet: Pet[Fish] = new Pet[Fish] {
    def renamed(a: Fish, newName: String): Fish = a.copy(name = newName)
    def name(a:Fish) = a.name
  }
}

val a = Fish("Tommy", 30)
val b = a.renamed("Bego")
