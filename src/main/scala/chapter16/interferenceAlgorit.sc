
def msort[T](f: (T, T) => Boolean)(l: List[T]): List[T] = {

  def merge(l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
    case (chapter22.Nil, _) => l2
    case (_, chapter22.Nil) => l1
    case (l1i :: l1x, l2i :: l2x) =>
      if (f(l1i, l2i)) l1i :: merge(l1x, l2)
      else l2i :: merge(l1, l2x)
  }
  val n = l.length / 2

  if (n == 0) l
  else {
    val (l1, l2) = l splitAt n
    merge(msort(f)(l1), msort(f)(l2))
  }
}

def msortSwapped[T](l: List[T])(f: (T, T) => Boolean): List[T] = msort(f)(l)

//def msortSwapped2[T](l: List[T],f: (T, T) => Boolean): List[T] = msort(f)(l)

val l = List('a', 'b', 'c', 'd', 'e')
msort((x:Char, y:Char) => x > y)(l)
msort[Char](_ > _)(l)

l sortWith(_ > _)
l sortWith((x:Char, y:Char) => x > y)

msortSwapped(l)(_ > _)
//msortSwapped2(l,(_ > _))

def flattenRight[T](l: List[List[T]]): List[T] =
  l.foldRight(List[T]()) (_ ::: _)


