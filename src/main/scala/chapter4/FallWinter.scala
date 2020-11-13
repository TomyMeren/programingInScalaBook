
import CheckSumAccumulator.calculate

object FallWinter extends App {

  for (season <- List("fall", "Winter", "Springs"))
    println(season + ": " + calculate(season))
}
