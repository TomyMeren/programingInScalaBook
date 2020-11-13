def isGoodEnough(guess: Double): Boolean = ???
def improve(d: Double): Double = ???

def approximate(guess: Double): Double =
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))

def approximateLoop(initialGuess: Double): Double = {
  var guess = initialGuess
  while (!isGoodEnough(guess))
    guess = improve(guess)
  guess
}

def boom(x: Int): Int =
  if (x == 0) throw new Exception("Boom")
  else boom(x - 1) + 1
//boom(3)

def bang(x:Int):Int =
  if (x == 0) throw new Exception("bang")
  else bang(x -1)

bang(3)
