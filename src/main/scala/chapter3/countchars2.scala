/*
import scala.io.Source
import scala.math.max

def lineLenth: Iterator[(Int, String)] = {
  val lines:Iterator[String] = Source.fromFile(args(0)).getLines()
  for (line <- lines) yield (line.length,line)
}
val maxNum = lineLenth.map(_._1.toString.length).reduce((x,y)=> if( x> y) x else y)

def maxNumText(num:Int)  = ("%0" + maxNum + "d").format(num)

if (args.length > 0) lineLenth.foreach{case(num, text) => println(maxNumText(num) + " | " + text)}
else Console.err.println("please enter filename")
*/
