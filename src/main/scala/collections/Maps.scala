package collections

object Maps extends App {

  var m1: Map[Int, String] = Map(1 -> "Akhil", 2 -> "James", 3 -> "John")
  val m1_1 = m1 + (4 -> "Jack") + (5 -> "Alexander")
  println(m1_1)

  case class State(stateShortForm: String, stateName: String)

  var statesMap = scala.collection.mutable.Map[String, String]()
  statesMap += ("DL" -> "New Delhi") += ("MH" -> "Maharashtra") += ("HR" -> "Haryana") += ("UP" -> "Uttar Pradesh") += ("KL" -> "Kerala")
  println(statesMap)
  println(statesMap("DL"))

  statesMap.foreach((a, b) => println(s"$a -> $b"))

  val statesList = statesMap.map((k, v) => State(k, v))
  println(statesList)

  statesMap -= ("KL", "UP")
  println(statesMap)
  statesMap.put("UP", "Uttar Pradesh")
  statesMap.put("KL", "Kerala")
  println(statesMap)


}
