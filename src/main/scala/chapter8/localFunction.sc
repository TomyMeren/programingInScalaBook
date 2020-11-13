import scala.io.Source

object LogLines {

  def ProcessFile(filename: String, width: Int) = {

    def processLine(line: String): Unit = {
      if (line.length > width) println(filename + ": " + line.trim)
    }

    val source: Source = Source.fromFile(filename: String)

    for (line <- source.getLines) processLine(filename, width, line)

  }
}

LogLines.ProcessFile("C:\\Users\\tmerendo\\Downloads\\consumos_anual.py", 500)