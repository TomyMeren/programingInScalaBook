import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.EventListener
import javax.swing.JButton



val
val button = new JButton
button.addActionListener(
  new ActionListener {
    def actionPerformed(event: ActionEvent) = {
      println("pressed!")
    }
  }
)

/*button.addActionListener(
  (_: ActionEvent) => println("pressed!")
)*/




implicit def function2AddActionListener(f: ActionEvent => Unit) =
  new ActionListener {
    def actionPerformed(event: ActionEvent) = f(event)
  }

button.addActionListener(
  function2AddActionListener((_:ActionEvent) => println("pressed!"))
)

/*button.addActionListener(
  (_:ActionEvent) => println("pressed!")
)*/

button.getActionListeners