var ms = Map(1 -> "Uno", 2 -> "Dos", 3 -> "Tres", 4 -> "Cuatro", 5 -> "Cinco")

ms += (1 -> "one")
ms

ms get 2
ms(2)
ms.getOrElse(2, 0)

ms get 6
//ms(6)
ms.getOrElse(6, 0)

ms.contains(3)

ms + (6 -> "seis")
ms + (6 -> "seis", 5 -> "five")
ms updated(6, "seis")
ms updated(5, "five")
ms ++ Map(6 -> "seis")

ms - 3
ms - (1, 2, 3)
ms -- List(6, 3, 2, 9)
ms.keys
ms.keySet
ms.keysIterator
ms.values
ms.valuesIterator.toList
ms.filterKeys(_ % 2 == 0)

ms.mapValues(_ + "!")

import scala.collection.mutable

val ms = mutable.Map(1 -> "Uno", 2 -> "Dos", 3 -> "Tres", 4 -> "Cuatro", 5 -> "Cinco")

ms(2) = "two"
ms(6) = "seis"

ms += (7 -> "siete")
ms += (1 -> "one")

ms += (8 -> "ocho", 9 -> "nueve")

ms ++= Map(8 -> "eight", 9 -> "nine")

ms getOrElseUpdate(10,"diez")
ms

ms -=8
ms-=11
ms-=(1,2,3)
ms --= Set(4,5)
ms remove (10)
ms remove(10)
ms retain((x,y)=> x % 6 ==0)
ms.clear()
ms
val ms = mutable.Map(1 -> "Uno", 2 -> "Dos", 3 -> "Tres", 4 -> "Cuatro", 5 -> "Cinco")

ms transform((x,y) => y + x)
 def f(x:String): Unit = {
   println("taking time");
   Thread.sleep(100)
   x.reverse
 }

f("tomas")

val cache = mutable.Map()
def cacheF(s:String)