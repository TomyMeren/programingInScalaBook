val it:Iterator[String] = Iterator("a","b", "num", "of", "words")
val f = (_:String).length < 3
val aa = it dropWhile (_.length < 2)

//it.toList //"a","b", "num", "of", "words"
//aa.toList //"num", "of", "words" //Nill
//it.toList //Nil

val bb = it takeWhile (_.length < 2)

//bb.toList
//it.toList

it.filter(f)//.toList
it.withFilter(f)//.toList
it.filterNot(f)//.toList

it.partition(f)//._1.toList

//it.forall(_.length < 10)
//it.exists(f)
//it.count(f)

def g (a:String,b:String):String = a + b

//it.toList
//it.foldLeft("=> ")(_ + _) //=> abnumofwords
//g(g(g(g(g(it.next(),it.next()),it.next()),it.next()),it.next()),"=> ") //"abnumofwords=> "
//g("=> ",g(it.next(),g(it.next(),g(it.next(),g(it.next(),it.next()))))) //=> abnumofwords

//it.foldRight("=> ")(_ + _) //"abnumofwords=> "
//it.reduceLeft(_ + _)
//it.reduceRight(_ + _)

val itn = (1 to 3).toIterator

//itn.sum
//itn.product
//itn.max
//itn.min

//(it zip itn).toList
//(it zipAll(itn,10,20)).toList

//it zipWithIndex
//it.patch(3,itn,1).toList

//itn.sameElements(it)

it addString(new StringBuilder(),"=>","|","<=")
it mkString("|")

val it1:Iterator[String] = Iterator("","","","a","b", "num", "of","", "words")
val it2:Iterator[String] = Iterator("","","","a","b", "num", "of","", "words")

def a1(it:Iterator[String]) = {
  while(it.next.isEmpty) {}
}

def a2(it:BufferedIterator[String]) = {
  while(it.head.isEmpty) {
    it.next()
  }
}

val bit1 = it1.buffered
val bit2 = it2.buffered

a1(bit1)
a2(bit2)

bit1.toList //WRONG!!!
bit2

bit2.head
bit2.next()
bit2.next()

List.apply(1,2,3)
