import java.math.BigInteger

val big1 = new java.math.BigInteger("12345")
val big2: BigInteger = new BigInteger("12345")

val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings.update(0, "Bye")
greetStrings(1) = " "
greetStrings(2) = "word!\n"

for (i <- 0 to 2)
  print(greetStrings(i))

for (i <- 0.to(2))
  print(greetStrings(i))

val numNames= Array("zero","one","two")
val numNames2= Array.apply("zero","one","two")
greetStrings.apply(2)