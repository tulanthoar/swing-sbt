import javax.swing._;

class HelloMenu {
  var menu: JMenu = _
}
object HelloMenu {

  def apply(): JMenu = {
    var menu = new JMenu( "Welcome" )
    var hello = new JMenuItem( "Say Hello" )
    HelloWindow putGreeting hello
    hello setToolTipText "Call info box"

    menu add hello
    return menu
  }

}
