package CursoTypeClassesCodely.cats.catsEffects

import cats.effect.{IO, IOApp, Ref}

object StupidFizzBuzz extends IOApp.Simple {

  val run =
    for {
      ctr <- IO.ref(0): IO[Ref[IO, Int]]

      wait = IO.sleep(1.second): IO[Unit]
      poll = (wait: IO[Unit]) *> ctr.get: IO[Int]

      _ <- poll.flatMap(IO.println(_): IO[Unit]).foreverM.start
      _ <- poll.map(_ % 3 == 0).ifM(IO.println("fizz"), IO.unit).foreverM.start
      _ <- poll.map(_ % 5 == 0).ifM(IO.println("buzz"), IO.unit).foreverM.start

      _ <- (wait *> ctr.update(_ + 1): IO[Unit]).foreverM.void
    } yield ()
}
