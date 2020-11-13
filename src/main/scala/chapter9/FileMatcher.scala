package chapter9

import java.io.File

object FileMatcher {
  private def filesHere: Array[File] =
    new File("C:\\Users\\tmerendo\\Desktop\\ProgramingInScala\\src\\main\\scala\\chapter8").listFiles()

  def filesEnding(query: String): Array[File] =
    for (file <- filesHere
         if file.getName.endsWith(query))
      yield file

  def fileContaing(query: String): Array[File] =
    for (file <- filesHere
         if file.getName.contains(query))
      yield file

  def fileRegex(query: String): Array[File] =
    for (file <- filesHere
         if file.getName.matches(query))
      yield file

  def filesMatching(f: String => Boolean): Array[File] =
    for (file <- filesHere
         if f(file.getName))
      yield file

  def filesEnding2(query: String): Array[File] = filesMatching(_.endsWith(query))

  def fileContaing2(query: String): Array[File] = filesMatching(name => name.contains(query))

  def fileRegex2(query: String): Array[File] = filesMatching(_.matches(query))
}
