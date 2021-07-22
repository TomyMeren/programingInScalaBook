import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]

buf +=1

buf +=2

3+=:buf

import scala.collection.mutable.ArrayBuffer


val buf = new ArrayBuffer[Int]
val buf2 = new Array[Int](2)

buf +=1

buf +=2

3+=:buf

def hasUpperCase(s:String) = s.exists(_.isUpper)