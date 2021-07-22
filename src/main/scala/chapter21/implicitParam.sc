class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter {
  def greeter(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
    println(s"welcome $name the system is ready")
    println(s"Antes de empezar no quieres un vasito de ${drink.preference}?")
    println(prompt.preference)
  }
}

val tomyPrompt = new PreferredPrompt("relax> ")

//Greeter.greeter("Tomy")(tomyPrompt)

object JoesPfres {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
  implicit val drink = new PreferredDrink("leche de mi pito")
}

import JoesPfres._

import scala.math.Ordering

Greeter.greeter("joe")

def maxListOrdering[T:Ordering](l: List[T]): T =
  l match {
    case List() => throw new IllegalArgumentException("La lista esta vacia!!")
    case List(x) => x
    case x :: xi =>
      val maxRest:T =  maxListOrdering[T](xi)
      if(implicitly[Ordering[T]].gt(x,maxRest)) x
      else maxRest
}

def maxListOrdering[T<:Ordered[T]](l: List[T]): T =
  l match {
    case List() => throw new IllegalArgumentException("La lista esta vacia!!")
    case List(x) => x
    case x :: xi =>
      val maxRest:T =  maxListOrdering[T](xi)
      if(implicitly[Ordering[T]].gt(x,maxRest)) x
      else maxRest
  }

maxListOrdering(List(1,2,3,4))
maxListOrdering(List("b","c","p"))

case class Name(value:String)

implicit val ord = new Ordering[Name] {
  def compare(x:Name, y:Name):Int = x.value.compareTo(y.value)
}

val tomy = Name("Tomy")
val bego = Name("Bego")

maxListOrdering(List(tomy,bego))
maxListOrdering(List("Tomy","Bego"))

