import scala.language.postfixOps

/** @object App
 *  @author ${user.name}
 */
object SbtEx {

  def foo( x : Array[String] ) = x.foldLeft( " = " )( ( a, b ) => a+":"+b )

  def main( args : Array[String] ) {
    println( "Sbt Ex!" )
    println( "concat arguments"+foo( args ) )
    println( "Hi from envy" )
    var boss = new Company()
    boss setName "company name" 
    val pt = new Point(5, 6)
    println( pt toString )
    println( boss getName )
  }

}
