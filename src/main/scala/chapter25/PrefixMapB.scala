package chapter25

import scala.collection._

class PrefixMapB[T]
  extends mutable.Map[String, T]
    with mutable.MapLike[String, T, PrefixMapB[T]] {

  var suffixes: immutable.Map[Char, PrefixMapB[T]] = Map.empty
  var value: Option[T] = None

  def get(s: String): Option[T] =
    if (s.isEmpty) value
    else suffixes get (s(0)) flatMap (_.get(s substring 1))

  def withPrefix(s: String): PrefixMapB[T] =
    if (s.isEmpty) this
    else {
      val leading = s(0)
      suffixes get leading match {
        case None =>
          suffixes = suffixes + (leading -> empty)
        case _ =>
      }
      suffixes(leading) withPrefix (s substring 1)
    }

  override def update(s: String, elem: T) =
    withPrefix(s).value = Some(elem)

  override def remove(s: String): Option[T] =
    if (s.isEmpty) { val prev = value; value = None; prev }
    else suffixes get (s(0)) flatMap (_.remove(s substring 1))

  def iterator: Iterator[(String, T)] =
    (for (v <- value.iterator) yield ("", v)) ++
      (for ((chr, m) <- suffixes.iterator;
            (s, v) <- m.iterator) yield (chr +: s, v))

  def += (kv: (String, T)): this.type = { update(kv._1, kv._2); this }

  def -= (s: String): this.type  = { remove(s); this }

  override def empty = new PrefixMapB[T]
}

import scala.collection.mutable.{Builder, MapBuilder}
import scala.collection.generic.CanBuildFrom

object PrefixMapB {
  def empty[T] = new PrefixMapB[T]

  def apply[T](kvs: (String, T)*): PrefixMapB[T] = {
    val m: PrefixMapB[T] = empty
    for (kv <- kvs) m += kv
    m
  }

  def newBuilder[T]: Builder[(String, T), PrefixMapB[T]] =
    new MapBuilder[String, T, PrefixMapB[T]](empty)

  implicit def canBuildFrom[T]
  : CanBuildFrom[PrefixMapB[_], (String, T), PrefixMapB[T]] =
    new CanBuildFrom[PrefixMapB[_], (String, T), PrefixMapB[T]] {
      def apply(from: PrefixMapB[_]) = newBuilder[T]
      def apply() = newBuilder[T]
    }
}