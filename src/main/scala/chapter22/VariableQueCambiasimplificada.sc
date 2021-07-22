case class CC(var tl: Int)

var start = CC(0)
var last0 = CC(0)

last0 = CC(1)
start = last0

val last1 = last0
last0 = CC(2)

println("Start!! => " + start)
println("last0!! => " + last0)
println("last1!! => " + last1)

last1.tl = 3
println("Start!! => " + start)
println("last0!! => " + last0)
println("last1!! => " + last1)
