def sum(x:Int)(y:Int):Int = x +y
def onePlus = (x:Int) =>  sum(1)(x)
def onePlus2 = sum(1) _
def oneTwo = sum(2) _

onePlus(2)
onePlus2(3)
oneTwo(3)

def first(x:Int):Int => Int = (y:Int) => x + y

def second = first(1)