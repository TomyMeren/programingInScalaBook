class Dollars(val amount:Int) extends AnyVal {
  override def toString() = "$" + amount
}
class Dollars2(val amount:Int,val tipo:String) {
  override def toString() = tipo + amount
}

val billete = new Dollars(100)
val billete2 = new Dollars(100)

billete == billete2

class SwittMonew(val amount:Int) extends AnyVal{
  override def toString = "CHF" + amount
}

val swi = new SwittMonew(100)