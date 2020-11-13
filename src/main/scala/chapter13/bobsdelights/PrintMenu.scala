package chapter13.printMenu

import chapter13.bobsdelights.Fruits
import chapter13.bobsdelights.showFruit

object PrintMenu extends App  {
  for (fruit <- Fruits.menu) {
    showFruit(fruit)
  }
}
