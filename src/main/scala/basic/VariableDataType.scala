package basic

object VariableDataType extends App {

  // String
  val a = "a"
  println(a)

  // Tuple
  val t = (1, true, "hello")
  println(t._3)

  // Arrays
  val a1 = Array[String]("one", "two", "three", "four", "five")
  val a2 = a1 ++ Array("six", "seven")
  var a3 = Array[String]("one", "two", "three", "four", "five");
  a3 = a3 ++ Array("six", "seven")
  println(a1(0))
  println(a2)
  println(a3)

  // Multi Dimensional Arrays
  val multi = Array[Array[Int]](Array(1, 2, 3, 4, 5), Array(6, 7, 8, 9, 10))
  println(multi(0)(2))

  // Scala's Option[T] type allows you to represent a value that may or may not exist. An Option[T] can either
  // be Some(v: T) indicating that a value is present, or None indicating that it is absent:
  def hello(title: String, firstName: String, lastNameOpt: Option[String]): Unit = {
    lastNameOpt match {
      case Some(lastName) => println(s"Hello $title. $firstName $lastName ")
      case None => println(s"Hello $title. $firstName")
    }
  }

  hello("Mr", "Haoyi", None)
  hello("Mr", "Haoyi", Some("Li"))
}
