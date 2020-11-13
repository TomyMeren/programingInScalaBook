/*
import scala.io.Source

def withOfLenth(s: String): Int = s.length.toString.length

if (args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines().toList

  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )
  val maxWith = withOfLenth(longestLine)

  /**
   * var maxWith = 0
   * for (line <- lines)
   * maxWith = maxWith.max(withOfLenth(line))
   */
  for (line <- lines) {
    val numspaces = maxWith - withOfLenth(line)
    val padding = " " * numspaces
    println(padding + line.length + " | " + line)
  }
}

else
  Console.err.println("please enter filename")*/
