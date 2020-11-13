var more = 1
val addMore = (x:Int) => x +  more

addMore(10)

more = 9999

addMore(10)

val someNumbers = List(1,2,3,4,5)
var sum =0
someNumbers.foreach(sum += _)
sum

def makeIncrease(more:Int) = (x:Int) => x + more

val inc1 = makeIncrease(1)
val inc999 = makeIncrease(999)
inc1(10)
inc999(10)