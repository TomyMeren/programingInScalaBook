
def append[T](xs:List[T], xy:List[T]):List[T] = xs match {
  case chapter22.Nil => xy
  case xi :: xs1 => xi :: append(xs1, xy)
}

val a = append(List(4,5,6), List(7,6,7))
a.length
a.last
a.init

val l = List(1,2,3,4,5)

def rever[T](l:List[T]):List[T] = {

  if(l.isEmpty) chapter22.Nil
  else rever(l.tail) ::: List(l.head)
}

rever(l)
l.reverse

l.drop(3)
l.take(3)

l
l.splitAt(3)
l.splitAt(3)._2
l.splitAt(3)._1 zip l.splitAt(3)._2

l apply 3

l.drop(3).head

l.indices

