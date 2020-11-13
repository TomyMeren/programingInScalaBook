import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

import com.sun.org.apache.xml.internal.utils.URI.MalformedURIException

/*try {
  val files = new FileReader("input.txt")
}
catch {
  case ex: FileNotFoundException => throw  new RuntimeException("meh")
  case ex: IOException =>
}*/

val file2 = new FileReader("C:\\Users\\tmerendo\\Downloads\\Libro2.csv")
try {
  println(file2.read())
}
finally {
  file2.close()
}
import java.net.URL
import java.net.MalformedURLException

def url(path:String) =
  try{
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }

url("tps://www.goodfsdfsdgle.cofdsa/")