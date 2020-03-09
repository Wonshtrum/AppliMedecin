import scala.io.StdIn

case class EspaceRecherche(dim:Int = 3){
  var limites:List[(Double,Double)] = List.fill(dim)(0,0)

  def defEspaceRecherche():List[Int]={
    limites.foreach((dimo:(Double,Double)) => StdIn.readDouble(),StdIn.readDouble())

  }
}
