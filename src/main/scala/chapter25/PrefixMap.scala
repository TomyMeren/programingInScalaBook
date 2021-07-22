package chapter25

import collection._

/*
class PrefixMap[T] extends mutable.Map[String, T]
  with mutable.MapLike[String, T, PrefixMap[T]] {

  var suffixes: immutable.Map[Char, PrefixMap[T]] = Map.empty //Map('a' -> PrefixMap[])
  var value: Option[T] = None

  //Se le pasa el string y devuelve el PrefixMap
  def withPrefix(s: String): PrefixMap[T] = ???

  override def update(s: String, t: T): Unit = {
    withPrefix(s).value = Some(t)
  }

  override def remove(s: String):Option[T] = {
    if(s.isEmpty) {val prev = value; value=None; prev }
    else suffixes get s(0) flatMap (_.remove(s.substring(1)))
  }

  def +=(kv: (String, T)): PrefixMap.this.type = {
    update(kv._1, kv._2); this
  }

  def -=(key: String): PrefixMap.this.type = {
    remove(key); this
  }
  def get(key: String): Option[T] = {
    if (key.isEmpty) value
    else suffixes get key(0) flatMap (_.get(key.substring(1)))
  }
  def iterator: Iterator[(String, T)] = ???
}


*/