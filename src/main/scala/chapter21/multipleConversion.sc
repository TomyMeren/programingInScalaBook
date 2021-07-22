def printLength(seq: Seq[Int]) = println(seq.length)

implicit def intToRange[T](i: T) = 1 to T.toInt

implicit def intToDigits(i: Int) = i.toString.toList.map(_.toInt)

printLength(12)

class PreferredDrink(val preferd:String)

implicit val pred = new PreferredDrink("vodka")

def enjoy(name:String)(implicit drink :PreferredDrink) = {
  println(s"$name va a beber $drink")
}

enjoy("Bego")
