def error(msg: String): Nothing = {
  throw new RuntimeException(msg)
}
//error("Cagadon")

def div(x: Int, y: Int): Int = {
  if (y == 0) sys.error("can't div by zero")
  else (x / y)
}

div(8,0)