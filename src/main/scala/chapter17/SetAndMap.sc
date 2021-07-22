val text = "hola Hola adios. Adios, meh!"

val words = text.split("[ .,!]+")

import scala.collection.immutable.Set

var wo = Set.empty[String]

for (word <- words)
  wo += word.toLowerCase
wo

wo ++= Set("meh", "sobe", "lore")

wo

import scala.collection.mutable.Map

val map = Map.empty[String, Int]

map("uno") = 1
map("dos") = 2
map("uno") = map("uno") + 1
map

def counWords(text: String): Map[String, Int] = {
  val words = text.split("[ .,!]+")
  val map = Map.empty[String, Int]

  for (rawWord <- words) {
    val word = rawWord.toLowerCase

    if(map.contains(word)) map(word) = map(word) + 1
    else map(word.toLowerCase) = 1
  }
  map
}

counWords("hola Hola adios. Adios, meh!")

import scala.collection.immutable.Map
import scala.collection.immutable.Map.Map1

val zero= Map()
//val one:scala.collection.immutable.Map.Map1[Int,String] = Map(1 -> "uno")


import scala.collection.immutable.TreeSet
val ts = TreeSet(9,4,7,2,4,6,8,9,0)
TreeSet("T","o","m","y")

import scala.collection.immutable.TreeMap

var tm = TreeMap(1 -> "uno", 3 -> "tres")

tm += (2 -> "dos")

import scala.collection.immutable.Set

var people = Set('a','b','c')

people += 'd'

people

var pi = 3.0

pi += 0.1
pi+=0.04

pi
