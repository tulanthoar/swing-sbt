import scala.language.postfixOps
import javax.imageio.ImageIO;
import java.net.URL;

/** @object SwingSbt
 *  @author ${user.name}
 */
object SwingSbt {

  def main( args: Array[String] ) {
    println( "Swing Sbt!" )
    var window = new HelloWindow()
    lazy val img =
      ImageIO read new URL( "http://scala-lang.org/resources/img/smooth-spiral.png" )
    window setImg img
    val client = new Company( "Client Company" )
    println( client getName )
    window.draw( client )
  }

}
