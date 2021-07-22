class Food

abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}

class Grass extends Food

class Cow extends Animal {
  type SuitableFood = Grass
  def eat(food: Grass): Unit = {}
}


class DogFood extends Food
class Dog extends Animal {
  type SuitableFood = DogFood
  def eat(food: DogFood): Unit = {}
}

class Fish extends Food
val bessy = new Cow
val lasy = new Dog
val pepe = new Dog

class Pasture {
  var animals:List[Animal {type SuitableFood = Grass}] = List(bessy)
}


lasy eat new pepe.SuitableFood

class Outer {
  class Inner
}

val o1 = new Outer
val o2 = new Outer

new o1.Inner == new o2.Inner

lasy eat new bessy.SuitableFood

bessy eat new Fish