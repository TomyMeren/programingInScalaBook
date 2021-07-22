List(1,2,3).iterator

def lazyMap[T, U](coll: Iterable[T], f: T => U) =
  new Iterable[U]{
    override def iterator = coll.iterator map f
  }

lazyMap(List(1,2,3),(x:Int) => x.toString)

val v = Vector(1 to 10:_*)
val vv = v.view
vv map (_ + 1)

(v.view map( _ + 1) map (_ * 2)).force

List(1,2,3,4) find (_ == 2)

def isPalindrome(x:String) = x == x.reverse

def findPalindrome(xs:Seq[String]):Option[String] = xs find isPalindrome

findPalindrome(Seq("aa","ab"))

val words: List[String] = Nil

findPalindrome(words.view take 10000)

val arr = (0 to 9).toArray

val subarr = arr.view.slice(3,6)

import collection.mutable
def negate (xs:mutable.Seq[Int]) =
  for(a <- 0 until xs.length) xs(a) = - xs(a)

negate(subarr)

arr