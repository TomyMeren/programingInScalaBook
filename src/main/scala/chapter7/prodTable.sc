
def numtoStringde4(num:String):String = " " * (4-num.length) + num

val listaDeListas:List[List[Int]] =
     (1 to 10).toList.map(
          row=> (1 to 10).toList.map(
               col => row * col))


listaDeListas.map(elem =>
     println(elem.map(num =>
          numtoStringde4(num.toString)).mkString))

// Returns a row as a sequence
def makeRowSeq(row: Int) =
     for (col <- 1 to 10) yield {
          val prod = (row * col).toString
          val padding = " " * (4 - prod.length)
          padding + prod
     }

// Returns a row as a string
def makeRow(row: Int) = makeRowSeq(row).mkString

// Returns table as a string with one row per line
def multiTable() = {

     val tableSeq = // a sequence of row strings
          for (row <- 1 to 10)
               yield makeRow(row)

     tableSeq.mkString("\n")
}


val listaDeListas2:List[String] =
     (1 to 10).toList.map(
          row=> (1 to 10).toList.map(
               col => numtoStringde4((row*col).toString)).mkString)

val mia = listaDeListas2.mkString("\n")

multiTable == mia

