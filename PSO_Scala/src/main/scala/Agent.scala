import Types.coord

case class Agent(dim: Int){
  var coord:Option[coord] = None
  var eval:Double = 0
  var vitesse:Double = 0
  var meilleurePos:Option[coord] = None
  var meilleureEval:Double = 0
  var voisinage:Option[List[Option[coord]]] = None
  var meilleurePosVoisin:Option[coord] = None
  var meilleureEvalVoisin:Double = 0



}
