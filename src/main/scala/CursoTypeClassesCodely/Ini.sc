import scala.concurrent.Future
import cats.effect.IO

case class User(name: String, age: Int)


object  ConvencionalApi {
  trait userRepositoryFuture {
    def all: Future[Seq[User]]

    def insert(user: User): Future[Unit]
  }

  trait userRepositoryIO {
    def all: IO[Seq[User]]

    def insert(user: User): IO[Unit]
  }
}

Some(2).map(_ + 1)
Map("uno"-> 1).get("dos").map(_ + 1)
