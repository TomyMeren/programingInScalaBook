var jetSet = Set.apply("Boeing", "Airbus")
val jetSet2 = Set("Boeing", "Airbus")

jetSet += "Lear"
jetSet = jetSet + "Meh"

val jetSet3 = jetSet2 + "Meh"

jetSet.apply("Boeing")
jetSet.contains("Boeing")

import scala.collection.mutable

val movieSet = mutable.Set("Hitch", "Polterge")
movieSet += "Shrek"
movieSet.+=("pinocho")

import scala.collection.immutable.HashSet

val hasshet = HashSet.apply("tomatos","chilies")
println(hasshet + "mierdacas")

val treasuereMap = mutable.Map[Int,String]()

treasuereMap += (1.->("Go to island."))
treasuereMap += (2 -> "Find bi X in the grond")
treasuereMap += ((3,"Dig"))
treasuereMap(2)

1.->("Go to island.")

val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV"
)

