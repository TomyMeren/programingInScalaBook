def fibonnaci(a:Int,b:Int):Stream[Int] = {
  a #:: fibonnaci(b, a + b)
}

fibonnaci(1,1).take(7).toList

val vec = scala.collection.immutable.Vector.empty

val vec2 =  vec :+ 2 :+ 4

val vec3 = 100 +: vec2

vec3(0)

vec3 updated(0,1)

vec3

scala.collection.immutable.IndexedSeq(1,2,3)