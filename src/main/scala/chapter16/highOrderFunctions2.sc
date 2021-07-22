val l = List(1, 2, 4, 5, -3, -4, -7, -9, 1, -1)

l takeWhile (_ > 0)
l dropWhile (_ > 0)

l span (_ > 0)


//forall and exists

def hasZeroRows(m: List[List[Int]]): Boolean = m.exists(_.forall(_ == 0))

def sum(l: List[Int]): Int = l.foldLeft(0)(_ + _)

def sumLong(l: List[Int]): Int = l.foldLeft(0) {
  case (ele: Int, acc: Int) =>
    ele + acc
}

def sumList(l: List[Int]): Int = (0 /: l) (_ + _)

sum(l)

val lx = List("Hola", "que", "tal")

lx.foldLeft("")(_ + " " + _)
lx.foldRight("")(_ + " " + _)

def flattenRight[T](l: List[List[T]]): List[T] = l.foldRight(List(): List[T]) {
  case (ele: List[T], acc: List[T]) => ele ++ acc
}

def flattenLeft[T](l: List[List[T]]): List[T] = l.foldLeft(List(): List[T]) {
  case (ele: List[T], acc: List[T]) => ele ++ acc
}

val ll: List[List[Int]] = List(List(0, 0, 0), List(7, 4, 3), List(1, 6, 4))

flattenRight(ll)
flattenLeft(ll)

def reverseLeft[T](l: List[T]): List[T] = l.foldLeft(List(): List[T]) {
  (acc: List[T],ele: T) => ele :: acc
}

l
reverseLeft(l)

l.sortWith(_ < _)

