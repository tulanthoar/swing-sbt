import javax.swing._;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import scala.language.postfixOps

class ExitMenu {
  var _: JMenu = _
}
object ExitMenu {

  def apply: JMenu = {
    var menu = new JMenu( "Exit" )
    var bye = new JMenuItem( "Close" )
    HelloWindow putExit bye
    bye setToolTipText "Exit this app"
    bye setMnemonic ( KeyEvent VK_Q )
    bye setAccelerator ( KeyStroke getKeyStroke ( KeyEvent VK_Q, ActionEvent CTRL_MASK ) )
    menu add bye
    menu
  }

}
