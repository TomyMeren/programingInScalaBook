import scala.collection.{TraversableOnce, mutable}
import scala.collection.mutable.Buffer

val it:Iterator[String] = Iterator("a","bbb", "number", "of", "words")
val itn:Iterator[Int] = (1 to 7).iterator
def f[T](xs:TraversableOnce[T]) = for(i <- xs) println(i)

it.next()
val aa = it dropWhile (_.length < 2)
//aa.next()

//it.next()
it.hasNext
it.hasNext
it.hasNext
//it.next()

//it foreach println
//it foreach println
//it map println

//it.buffered
//it.grouped(2).toList
//it.sliding(2).toList
val buf = new mutable.ArrayBuffer[String]
val arr =new Array[String](4)
//it copyToBuffer buf
it copyToArray arr
//buf.toArray
arr
it.hasNext

val it:Iterator[String] = Iterator("a","b", "num", "of", "words")

val (it1, it2) = it.duplicate

val itf = it1 ++ it2

val bb = itf padTo(12,"sii")
//bb.toList


val part: PartialFunction[String, String] = {
  case d: String if d.length < 2 => "pequeniiito"
}

val part2: Function1[String, String] = {
  case d: String if d.length < 2 => "pequeniiito"
  case _ => ""
}

part("i")
//part("ii")
part2("i")
part2("ii")


val (bb1, bb2) =  bb.duplicate

//bb1.toList

val cc = bb1 collect part

cc.isEmpty
cc.next()
cc.isEmpty
cc.length
cc.isEmpty


bb2.find(_ =="a")
//bb2.length
bb2 indexOf "of"
//bb2.length

bb2.indexWhere(_ =="a")
//bb2.length
//bb2.toList// List(b, num, of, words, sii, sii)
bb2.take(6)//.toList
//bb2.toList
bb2.drop(3) //List(words, sii, sii)
//bb2.toList

val it:Iterator[String] = Iterator("a","b", "num", "of", "words")

it.slice(0,2).toList //List("b", "num",)
it.toList

