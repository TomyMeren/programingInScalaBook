def foo[T](i: Int) = i
foo[Int](1)
foo(1)

/**
 * Implicitos basicos
 */

import scala.concurrent.{Future, ExecutionContext}

Future[Int](1)(ExecutionContext.global)
//Future(1)

trait Scope1 {
  implicit val ec = ExecutionContext.global
  Future(1)
}

object Scope1 extends Scope1

trait Scope2 {
  //import  Scope1._
  implicit val ec2 = ExecutionContext.global
  Future(2)
}

def bar(a: Int)(ec: ExecutionContext): Future[String] =
  Future(a.toString)(ec)

def foo(a: Int)(ec: ExecutionContext): Future[Boolean] =
  bar(a)(ec).map(_.length > 0)(ec)

def bar(a: Int)(implicit ec: ExecutionContext): Future[String] =
  Future(a.toString)

def foo(a: Int)(implicit ec: ExecutionContext): Future[Boolean] =
  bar(a).map(_.length > 0)

/**
 * funciones Implicitos de distintos tipos
 */

import java.time._
import scala.concurrent._
//import duration._
import akka._
import akka.actor._
import akka.stream._
import akka.stream.scaladsl._

val pipeline: RunnableGraph[NotUsed] = Source(List(1, 2, 3, 4)).to(Sink.foreach(println))

//pipeline.run Falla!! falta el implicito

/*

  def run()(implicit materializer:Materializer): MAt
 */

implicit val system: ActorSystem = ActorSystem("akka-stream-primer")

/*
object Materializer {

  //Si me das algo del tipo ActorSustem te devuelvo alfo del tipo Materializer
  implicit def matFromSystem(
      implicit provider: ClassicActorSystemProvider): Materializer =
    ???
}
*/

pipeline.run()(Materializer.matFromSystem(system))

/**
 * Clases implicitas para extender una clase
 */

val s: String = "hi"
s.getClass

s.map(c => c.toUpper)

class MyStringOps(x: String) {
  def mymap(f: Char => Char): String =
    "dummy"
}

implicit def toMyStringOps(x: String): MyStringOps =
  new MyStringOps(x)

s.mymap(_.toUpper)

implicit class MyStringOps(x: String) {
  def mymap2(f: Char => Char): String =
    "dummy"
}

"oooooo".mymap2(_.toUpper)