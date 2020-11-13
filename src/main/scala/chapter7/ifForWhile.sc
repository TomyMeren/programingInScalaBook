import java.io.File

def greet() = println("hi")
//() == greet()

var a = 0;
//() ==( a +1)

var line = ""
val line2 = "2"


val filesHere: Array[File] = (new File(".")).listFiles

def a = {
  for (file: File <- filesHere
       if file.toString.split("-").contains("win");
       if(file.isFile)) println(file)
}

def b = {
  for (file: File <- filesHere)
    if (file.toString.split("-").contains("console")) println(file)
}

for (num <- 1 to 5) println(num)
for (num <- 1 until 5) println(num)
a
b

