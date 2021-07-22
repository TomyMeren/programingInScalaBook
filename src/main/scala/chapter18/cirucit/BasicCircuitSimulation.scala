package chapter18.cirucit

import chapter18.cirucit.MySimulation.agenda

class BasicCircuitSimulation extends Simulation {

  class Wire(name:String) {

    private var sigVal: Boolean = false
    private var actions: List[Action] = List()

    def getSignal = sigVal

    //Modifica la lista de acciones del wire en concreto si este cambia
    def setSignal(sig: Boolean) = {
      println(s"set! to $name")
      if (sigVal != sig) {
        sigVal = sig
        //Ejecuta todas las acciones => Meter registros en la agenda solo cuando cambia!!
        println(s"numero de acciones de $name = " + actions.length)
        actions foreach ((action:Action) => action()) //Al volver a meter os registros en la agenda y ejecutar proboa una reaccion en cadena
        println(agenda)
      }
    }

    /**
     * Añade acciones: invert,and,or,
     * La accion que añade siempre es un afterDelay(insert en la agenda)
     * @param a
     */
    def addAction(a: Action): Unit = {
      println(s"add Action to $name!!")
      actions = a :: actions
      //Ejecuta la accion => Meter en la agenda
      a()
    }
  }



  def inverter(input: Wire, output: Wire): Unit = {
    def invertAction() = {
      val sig = input.getSignal
      //Metemos el registro en la agenda sin que este se ejecute
      afterDelay(100,"inv") {
        output.setSignal(!sig)
      }
    }
    //Añadimos la accion (sin ejecutarse) al Wire de entrada
    input addAction invertAction
  }

  def andGate(a1: Wire, a2: Wire, output: Wire) = {
    def andAction() = {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(7,"and") {
        output setSignal (a1Sig & a2Sig)
      }
    }
    a1 addAction andAction
    a2 addAction andAction
  }

  def orGate(a1: Wire, a2: Wire, output: Wire) = {


    def orAction() = {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      //Insertamos en la agenda
      afterDelay(1,"or") {
        output.setSignal(a1Sig | a2Sig)
      }
    }
    //Añadimos a la accion
    a1 addAction orAction
    a2 addAction orAction
  }

  def probe(name:String,wire: Wire) = {
    def action() = {
        println(name + " " + currentTime +
        " new-value= " + wire.getSignal)
    }
    wire addAction action
  }
}
