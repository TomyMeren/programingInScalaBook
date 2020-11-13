import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get(): Int = buf.remove(0)
  def put(x: Int): Unit = {buf += x}

  override def toString: String = buf.mkString(",")
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = {super.put(x * 2)}
}

class MyQueue extends BasicIntQueue with Doubling

trait incrementing extends IntQueue {
  abstract override def put(x: Int) = {super.put(x + 1)}
}

trait filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}

val queue = new BasicIntQueue with Doubling

queue.put(10)
queue.put(20)
queue.put(30)
queue.get()

val myQueue = new MyQueue

myQueue.put(10)
myQueue.put(15)
myQueue.get()


val myQueueplus = new BasicIntQueue with incrementing

myQueueplus.put(12)
myQueueplus.get()

val myQueuefilt = new BasicIntQueue with filtering with incrementing
val myQueuefiltInvt = new BasicIntQueue with incrementing with filtering

myQueuefilt.put(-1)
myQueuefilt.put(0)
myQueuefilt.put(1)

myQueuefilt.get()
myQueuefilt.get()
myQueuefilt.get()

myQueuefiltInvt.put(-1)
myQueuefiltInvt.put(0)
myQueuefiltInvt.put(1)

myQueuefiltInvt.get()
myQueuefiltInvt.get()
