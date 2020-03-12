import scala.util.Random

object Initialisation {

  def IniPosEssaim(ess:Essaim): Essaim ={
    val tmp:Int = ess.dim
    for (a :: _ <- ess.essaim){
      a.coord = Some(List.fill(tmp)(Random.nextDouble()))
    }
  ess
  }

}
