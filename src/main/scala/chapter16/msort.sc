
def msort[T](f: (T, T) => Boolean)(l: List[T]): List[T] = {

  def merge(l1: List[T], l2: List[T]): List[T] = (l1, l2) match {
    case (chapter22.Nil, _) => l2
    case (_, chapter22.Nil) => l1
    case (l1i :: l1x, l2i :: l2x) =>
        if (f(l1i, l2i)) l1i :: merge(l1x,l2)
        else l2i ::merge(l1,l2x)
  }
  val n = l.length / 2

  if (n == 0) l
  else {
    val (l1, l2) = l splitAt n
    merge(msort(f)(l1), msort(f)(l2))
  }
}

msort((x:Int,y:Int) => x < y)(List(5,6,1,9,0))

def intSort = msort((x:Int,y:Int) => x < y) _
def reverseIntShort= msort((x:Int,y:Int) => x > y) _

val mixedInt = List(5,8,1,36,97,54,3)

intSort(mixedInt)
reverseIntShort(mixedInt)
