name := "ProgramingInScala"

version := "0.1"

scalaVersion := "3.1.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.8.3" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.6.4"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-stream" % "2.6.4"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.0"

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.1.1"