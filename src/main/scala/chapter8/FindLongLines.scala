package chapter8

object FindLongLines {
  def main(args: Array[String]) = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LogLines.ProcessFile(arg, width)
  }
}

