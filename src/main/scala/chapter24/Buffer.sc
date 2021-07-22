import scala.collection.mutable.ListBuffer

val buf = ListBuffer(1,2,3,4,5,6,7)
buf += 8

buf +=(9,10,11)

buf ++= ListBuffer(12,13)

buf insert(0,0)
buf remove(13)

buf insertAll(12, List(11,12))
buf remove(1,5)
buf
buf trimStart(2)
buf
buf trimEnd(2)
buf

val buf1 = buf.clone
val buf2 = buf

buf.clear()
buf//empty
buf1//no empty
buf2//Empty