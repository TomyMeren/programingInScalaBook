def echo(args: String*) =
  for (arg <- args)
    println(arg)

echo("hola")
echo("hola", "quepasa", "quetal")

echo(List("a", "b", "c"): _*)

def speed(vel: Int, tiemp: Int): Int = vel / tiemp

speed(100, 10)

speed(tiemp = 10, vel = 100)

def printTime(out: java.io.PrintStream = Console.out, div: Int = 1) =
  out.println("time = " + System.currentTimeMillis() / div)

printTime(Console.err)
printTime(div = 2)
printTime()