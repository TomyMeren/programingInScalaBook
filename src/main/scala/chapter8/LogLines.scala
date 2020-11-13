package chapter8

import scala.io.Source

object LogLines {

  private def processLine(filename: String, width: Int, line: String): Unit = {
    if (line.length > width) println(filename + ": " + line.trim)
  }

  def ProcessFile(filename: String, width: Int) = {
    val source: Source = Source.fromFile(filename: String)

    for (line <- source.getLines) processLine(filename, width, line)

  }
}
