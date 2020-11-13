var assertionsEnabled = false

def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError

def myAssertTomy(predicate: Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

myAssert(() => 5 > 3)
myAssertTomy(5 > 3)

myAssert(() => 5 > 8)
myAssertTomy(5 > 8)

def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

byNameAssert(5 > 3)

val x = 5

myAssertTomy(x / 0 == 0)
//byNameAssert(x / 0 == 0)
