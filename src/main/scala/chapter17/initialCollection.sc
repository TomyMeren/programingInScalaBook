val colors = List("red","blue","gree")

import scala.collection.immutable
import scala.collection.immutable.TreeSet

val colorSet: TreeSet[String]= TreeSet[String]() ++ colors

import scala.collection.mutable
import scala.collection.immutable

val colorSet2: mutable.TreeSet[String] = mutable.TreeSet[String]() ++  colorSet

var muta: mutable.Map[Int ,Char] = mutable.Map(1 -> 'i', 2 -> 'd')

val inmuta : immutable.Map[Int ,Char] =immutable.Map.empty ++ muta