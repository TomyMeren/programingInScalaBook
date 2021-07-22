val a = List(1, 2, 3, 4, 5)

val git = a.grouped(3)

git.next
git.next

val sit = a.sliding(3)

sit.next
sit.next
sit.next()

a.takeRight(2) zip a.dropRight(3)

val xs = a.takeRight(3)
a.zipAll(xs,6,7)
xs.zipAll(a,6,7)

a.zipWithIndex

a.takeRight(3) sameElements a.dropWhile(_ < 3)

//sealed abstract class Tree


/*sealed abstract class Tree extends Traversable[Int] {
  def foreach[U](f:Int => U):Unit = this match {
    case Node(el) => f(el)
    case Branch(le:Tree, ri) => le.foreach(f); ri.foreach(f)
  }
}*/

sealed abstract class Tree extends Iterable[Int] {
  def iterator:Iterator[Int] = this match {
    case Node(el) => Iterator.single(el)
    case Branch(le:Tree, ri) => le.iterator ++ ri.iterator
  }
}

case class Branch(left:Tree,right:Tree) extends Tree
case class Node(elem:Int) extends Tree