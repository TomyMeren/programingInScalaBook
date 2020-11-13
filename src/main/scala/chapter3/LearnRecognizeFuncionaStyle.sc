def printArgs(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}

def printArgs2(args: Array[String]): Unit = {
  args.foreach(println)
}

def formatArgs(args: Array[String]): String =
  args.mkString(",")

val args = Array("one","two","three")
print(formatArgs(args))

val res = formatArgs(args)

assert(res == "one,two,three")
