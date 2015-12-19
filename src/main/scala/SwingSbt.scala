import scala.language.postfixOps

/** @object App
 *  @author ${user.name}
 */
object SwingSbt {

  def main( args : Array[String] ) {
    println( "Swing Sbt!" )
    var client = new Company()
    client setName "Client Company"
    println( client getName )
    var hi = new HelloWindow()
    hi find_img "http://scala-lang.org/resources/img/smooth-spiral.png"
    hi draw client
  }

}
