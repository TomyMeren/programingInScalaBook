
val oneTwo = List(1,2)
val threeFour = List.apply(3,4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")

0 :: oneTwo
oneTwo.::(0)

1 :: 2 :: 3 :: chapter22.Nil
3:: chapter22.Nil :: 4 :: chapter22.Nil


val trill = "Bcca" :: "cc" :: "acc" :: chapter22.Nil

trill.count(x=> x.length == 1)

trill.dropRight(1)
trill.exists(_ =="d")
trill.filter(x=> x.length == 2)
trill.forall(s=> s.endsWith("c"))
trill.foreach(println(_))
trill.foreach(println)
trill.last
trill.init
trill.map(_ + "a")
trill.reverse
trill.mkString(", ")

trill.sortWith((x,y) => x < y)
trill.sortBy(x => x.length)(Ordering[Int].reverse)
trill.sorted
trill.sortWith((x,y) => x.charAt(0).toLower < y.charAt(0).toLower)
