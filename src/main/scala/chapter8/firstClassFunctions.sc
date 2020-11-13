val a: Function1[Int,Int] = (x:Int) => x +1
//def a (x:Int)  = x + 1

val b: Function1[Int,Int] = _ + 4
//val c = _ + 4
val d: Function1[Int,Boolean] = _ > 3

val f: Function2[Int,Int,Int] = ((_:Int) + (_:Int))
val f2: Function2[Int,Int,Int] = (x:Int,y:Int) => x + y

a(3)

val increase = (x:Int) =>  {
  println("We")
  println("are")
  x + 3
}

increase(7)

val l = List(1,2,3,4)

l.filter((x:Int) => x > 2)
l.filter((x) => x > 2)
l.filter(x => x > 2)
l filter d

l.map(a)
l map a
l map b

val l2 = List((1,2),(3,4),(5,6),(7,8))

l2.map{case (x,y) => f2(x,y)}