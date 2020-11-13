import java.io.{File, PrintWriter}

def twice(op: Double => Double, x: Double) = op(op(x))

twice(_ + 1, 5)
twice(_ + 1, 4)

def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

withPrintWriter(
  new File("C:\\Users\\tmerendo\\Desktop\\ProgramingInScala\\src\\main\\scala\\chapter9\\date.txt"),
  writer => writer.println(new java.util.Date))

def withPrintWriter2(file: File)(op: PrintWriter => Unit): Unit = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

val file = new File("C:\\Users\\tmerendo\\Desktop\\ProgramingInScala\\src\\main\\scala\\chapter9\\date.txt")

withPrintWriter2(file) {
  writer => writer.println(new java.util.Date)
}