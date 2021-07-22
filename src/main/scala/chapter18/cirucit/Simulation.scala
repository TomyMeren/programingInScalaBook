package chapter18.cirucit

class Simulation {

  type Action = () => Unit

  case class WorkItem(time: Int, action: Action, desc: String)

  private var curtime: Int = 0
  def currentTime = curtime

  var agenda: List[WorkItem] = List()

  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
    if (ag.isEmpty || item.time < ag.head.time)
      item :: ag
    else
      ag.head :: insert(ag.tail, item)
  }

  /** Acciona elimina el registro de la agenda
   * Modifica el curtime
   * Hace la accion (pintar o modificar valores) */

  private def next() = {
    println("next!!")
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()
    }
  }

  //insert en la agenda sin ejecutar el block
  def afterDelay(delay: Int, desc: String)(block: => Unit) = {
    println("Add Agenda! " + desc)
    //println("current time = " + currentTime)
    val item = WorkItem(currentTime + delay, () => block, desc)
    agenda = insert(agenda, item)
  }

  /** Mientras la agenda tenga registros continua la ejecucion */

  def run() = {
    afterDelay(0, "Inicio") {
      println("*** simulation started, time = " +
        currentTime + " ***")
    }
    while (!agenda.isEmpty) next()
  }
}
