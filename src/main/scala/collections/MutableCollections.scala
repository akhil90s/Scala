package collections

object MutableCollections extends App {

  var a = Array(1, 2, 3, 4, 5)
  a = a ++ Array(1, 2, 3, 4, 5)
  println(a)

  val a1 = Array.fill(5)("hello")
  println(a1)

  // Multiply every element by 2
  val a2 = Array(1, 2, 3, 4, 5).map(i => i * 2)
  println(a2)

  // Discard first two elements
  val a3 = Array(1, 2, 3, 4, 5).drop(2)
  println(a3)

  // Keep first two elements
  var a4 = Array(1, 2, 3, 4, 5).take(2)
  println(a4)

  // Keep elements from index 1-4
  val a5 = Array(1, 2, 3, 4, 5).slice(1, 4)
  println(a5)

  // Removes all duplicates
  val a6 = Array(1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8).distinct
  println(a6)

  // Query returns a Option element
  val a7 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).find(i => i % 2 == 0 && i > 2)
  println(a7)

  val a8 = Array(1, 2, 3, 4, 5, 6, 7).mkString(",")
  println(a8)

}
