import scala.collection.mutable

def f(x:String): String = {
  println("taking time");
  Thread.sleep(1000)
  x.reverse
}

f("tomas")

val cache: mutable.Map[String,String] = mutable.Map()
def cachedF(s:String) = cache.getOrElseUpdate(s,f(s))


cache
cachedF("abc")
cache

cachedF("abc")
cache


val cache: mutable.Map[String,String] = mutable.Map()
def cachedF2(arg:String) = cache get arg match {
  case None => val result = f(arg); cache(arg) = result; result
  case Some(s: String) => s
}

cachedF2("abc")