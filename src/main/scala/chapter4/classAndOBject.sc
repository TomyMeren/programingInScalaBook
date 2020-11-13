class CheckSumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checkSum():Int = ~(sum & 0xFF) + 1
}

val acc = new CheckSumAccumulator
val csa = new CheckSumAccumulator

acc.add(3)
acc.checkSum

val x = 1
val y = 2
val z = 3

x
+ y

(x
  +y)

x +
y +
z