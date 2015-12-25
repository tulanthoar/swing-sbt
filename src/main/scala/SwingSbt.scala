import scala.language.postfixOps
import javax.imageio.ImageIO;
import java.net.URL;

/** @object App
 *  @author ${user.name}
 */
object SwingSbt {

  def main( args : Array[String] ) {
    lazy val scalaImg = ImageIO read new URL( "http://scala-lang.org/resources/img/smooth-spiral.png")
    println( "Swing Sbt!" )
    val client = new Company("Client Company")
    println( client getName )
    var window = new HelloWindow()
    window.setImg(scalaImg)
    window.draw(client)
  }

}
