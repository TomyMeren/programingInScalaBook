import chapter15.{BinOp, Number}

val mytuple = (123, "abc")
val (number, string) = mytuple
number
mytuple

val a = BinOp("+", Number(1), Number(4))

val BinOp(oper, left, rigt) = a

a.operator == oper

//Case sequences as partial functions

val widthDefault: Option[Int] => Int = {
  case Some(x) => x + 1
  case None => 0
}

widthDefault(Some(10))
widthDefault(None)

/*var sum = 0

def receive: Unit = {
  case Data(byte) => sum += byte

  case GetChecksum(requester) =>
    val checksum = ~(sum & 0xFF) + 1
    requester ! checksum
}*/


val second: PartialFunction[List[Int],Int] = {
  case _ :: y :: _ => y
}

val second2:List[Int] => Int = {
  case _ :: y :: _ => y
}


second(List(1, 2, 3))
second(List(1,2))
//second(List(1))
//second(List())

second.isDefinedAt(List(3,4,5))
second.isDefinedAt(List())