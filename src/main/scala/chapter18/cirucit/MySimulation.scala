package chapter18.cirucit

object MySimulation extends CircuitSimulation with App {
  val input1 = new Wire("input1")
  val input2 = new Wire("input2")
  val sum = new Wire("sum")
  val carry = new Wire("carry")

  probe("sum", sum) //Añadimos la accion de pintar el mensaje al wire Sum
  probe("carry", carry) //Añadimos la accion de pintar el mensaje al wire Carry

  //input1 setSignal true

  //Creamos la agenda y la lista de accion por wire
  halfAdder(input1, input2, sum, carry)

  input1 setSignal true

  run()



  //println(agenda)

  //Modificamos un input1 haciendo que la lista se vuelva a reacer
  //input1 setSignal true

  //println(agenda)
  //run()

  //input2 setSignal true

  //run()
}
