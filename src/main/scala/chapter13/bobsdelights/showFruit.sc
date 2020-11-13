import chapter13.bobsdelights.Fruit
//import chapter13.bobsdelights.Fruit.{Apple => Manza, Orange}
import chapter13.bobsdelights.Fruit.{Pear=>_,_}

def showFruit(fruit: Fruit): Unit = {
  import fruit._

  println(name + " s are " + color)
}

showFruit(Apple)
showFruit(Orange)
//showFruit(Pear)