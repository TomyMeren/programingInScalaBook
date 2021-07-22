val xs = Seq(1,2,3,4,5,6)

xs.updated(3, 0)

import scala.collection.mutable.Seq
val xy = Seq(1,2,3,4,5,6)

xy.update(3,3)
xy(4) = 7
xy.updated(0,9)
xy

xs isDefinedAt(6)
xs.lengthCompare(6)

xs.indices

xs indexOf(5)
xy
xy lastIndexOf(3)
xs  indexOfSlice Seq(3,4)

xs indexWhere( _ > 4)

xs segmentLength(_ < 4,1)

xs prefixLength (_ < 4)

0 +: xs

xs :+ 7

xs padTo(10,8)
xs.patch(2,9 to 11,2)

xs.sorted
xs.sortWith(_ > _)
xs sortBy(_ % 2)

xs.reverse

xs.reverseIterator

xs.reverseMap(_ % 2)

xs.startsWith(xs.dropRight(3))
xs.endsWith(xs.takeRight(3))
xs.contains(3)
xs containsSlice(List(3,4))
xy(3)=4
xy
(xs corresponds xs.tail :+ 7) (_ < _)

xs.dropRight(1) intersect xs.tail
xs.dropRight(1) diff xs.tail

