def sum (a:Int ,b:Int ,c:Int):Int = a + b +c
val a = sum _

sum(1,2,3)
a(1,2,3)
a.apply(1,2,3)

val g = sum(1, _: Int, 3)
g(2)


List((1,2,3),(4,5,6)) map a.tupled

def c(f:((Int,Int,Int)) => Int)(tup:(Int,Int,Int)):Int = f(tup) - 5

def d (f:((Int,Int,Int)) => Int): ((Int,Int,Int)) => Int =  c(f)

val e = d(a.tupled)
e((4,5,6))

