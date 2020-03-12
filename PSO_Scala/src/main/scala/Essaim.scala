import Types.Hive
import sun.management.resources.agent

import scala.math

case class Essaim(dimension : Int = 2){
  var dim:Int = dimension
  var valeur:Int = Math.round((10+2*Math.sqrt(dim)).floatValue)
  var essaim:Option[Hive] = None

  def IniEssaim(): Option[Hive] ={
    val NouvEssaim = Some(List.fill(valeur)(Agent(dim)))
    NouvEssaim
  }

  def ComparVoisin(ag1:Agent,ag2:Agent):Agent={
    if(ag1.eval>ag2.eval){
      ag2
    }
    else{
      ag1
    }
  }

  lazy val meilleureVoisinage:Agent={
    essaim.reduce(ComparVoisin)
  }

  def SetMeilleurVoisin(ag:Agent, essaim: Hive):Hive ={
    essaim.foreach((ag:Agent) => ag.eval = meilleureVoisinage.eval)
    essaim
  }



}

