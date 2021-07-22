package chapter18

class BankAccount {

  private var total: Int = 0

  def getTotal = total

  def ingresar(cantidad: Int): Unit = {
    require(cantidad > 0)
    total += cantidad
  }

  def sacar(cantidad: Int): Boolean = {
    if (cantidad > total) false
    else {
      total -= cantidad
      true
    }
  }
}
