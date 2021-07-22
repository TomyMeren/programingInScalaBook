case class CC[U](var tl: List[U])

var start: CC[Int] = CC(List())
var last0: CC[Int] = CC(List())


last0 = CC(List(0))
start = last0

val last1 = last0
last0 = CC(List(2))
println("Start1!! => " + start)
last1.tl = last0.tl

println("Start2!! => " + start) //12
println("last1!! => " + last1) //12
println("last0!! => " + last0) //2

val last1 = last0
last0 = CC(List(3))
last1.tl =  last0.tl

println("Start2!! => " + start) // 25
println("last1!! => " + last1) // 13
println("last0!! => " + last0) //3
