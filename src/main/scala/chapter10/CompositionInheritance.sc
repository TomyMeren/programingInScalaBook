class Cat {
  val dangerous = false
}

class Tiger(override val dangerous: Boolean, private var age: Int) extends Cat

class TigerLong(param1: Boolean, param2:Int) extends Cat {
  override val dangerous:Boolean = param1
  private var age:Int = param2
}

Array.fill(3)("elem" * 4)