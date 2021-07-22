package chapter18

class BankAccount {

  private var total: Int = 0

  def getTotal = total

  def ingresar(cantidad:Int):Unit  = {
  if (cantidad > 0)
    total = total + cantidad
  else
    throw new Exception("No se puede ingresar un numero negativo de dinero")
  }

  def sacar(cantidad:Int):Unit = {
    if (cantidad > total)
    total = total - cantidad
  }
}
