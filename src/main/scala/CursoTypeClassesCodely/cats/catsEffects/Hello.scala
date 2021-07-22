package CursoTypeClassesCodely.cats.catsEffects

import cats.effect.std.Random
import cats.effect.{ExitCode, IO, IOApp}

object Hello extends IOApp {

  def sleepPrint(word: String, name: String, rand: Random[IO]): IO[Unit] =
    for {
      delay <- rand.betweenInt(200, 700)
      _ <- IO.sleep(delay.millis)
      _ <- IO.println(s"$word, $name, $delay")
    } yield ()

  def run(args: List[String]) =
    for {
      rand <- Random.scalaUtilRandom[IO]: IO[Random[IO]]
      name <- IO.pure("Daniel")

      english <- sleepPrint("Hello", name, rand).foreverM.start
      french <- sleepPrint("Bonjour", name, rand).foreverM.start
      spanish <- sleepPrint("Hola", name, rand).foreverM.start

      _ <- IO.sleep(5.seconds)
      _ <- english.cancel >> french.cancel >> spanish.cancel
    } yield ExitCode.Success
}
