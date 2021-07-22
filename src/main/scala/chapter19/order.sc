class Person(val name: String, val lastName: String) extends Ordered[Person] {
  def compare(that: Person): Int = {
    val compareLat = lastName.compareToIgnoreCase(that.lastName)
    if (compareLat != 0) compareLat
    else name.compareToIgnoreCase(that.name)
  }

  override def toString: String = s"$name $lastName"
}

val tomy = new Person("tomas", "merendon")
val bego = new Person("begoña", "Odri")
val sobe = new Person("juan", "choberon")
val lore = new Person("Lorena", "Garcia")

val l = List(tomy, bego, sobe, lore)
tomy < bego

def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
  def merge(ys: List[T], zs: List[T]): List[T] = {
    (ys, zs) match {
      case (Nil, _) => zs
      case (_, Nil) => ys
      case (y :: yss, z :: zss) => {
        if (y < z) z :: merge(ys, zss)
        else y :: merge(yss, zs)
      }
    }
  }

  val splitNum = xs.length / 2
  if (splitNum == 0) xs
  else {
    val (ys, zs) = xs splitAt splitNum

    merge(orderedMergeSort(ys), orderedMergeSort(zs))
  }
}

orderedMergeSort(l)