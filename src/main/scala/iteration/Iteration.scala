package iteration

object Iteration extends App {

  // Iterate Array
  var totalA = 0
  val itemsA = Array[Int](1, 10, 100, 1000)
  for (item <- itemsA) totalA += item
  println(totalA)

  // Iterate List
  var totalL = 0
  val itemsL = List[Int](1, 10, 100, 1000)
  for (item <- itemsL) totalL += item
  println(totalL)

  // Simple For Loop
  var total = 0;
  for (i <- Range(0, 5)) {
    println("Looping " + i)
    total = total + i
  }
  println(total)

  // Iterate Multi Dimensional Arrays
  val multi = Array[Array[Int]](Array(1, 2, 3, 4, 5), Array(6, 7, 8, 9, 10))
  for (arr <- multi; value <- arr) println(value)
  for (arr <- multi; value <- arr; if value % 2 == 0) println(value)

  // Conditional : Scala does not have a separate ternary expression syntax, and so the if-else can be directly
  // used as the right-hand-side of the total += below.
  total = 0
  for (i <- Range(0, 10)) {
    if (i % 2 == 0) total += i
    else total += 2
  }
  println(total)
  total = 0
  for (i <- Range(0, 10)) {
    total += (if (i % 2 == 0) i else 2)
  }
  println(total)

  // Simple Iteration with Conditional
  for (i <- Range.inclusive(1, 100)) {
    if (i % 3 == 0 && i % 5 == 0) println("FizzBuzz")
    else if (i % 3 == 0) println("Fizz")
    else if (i % 5 == 0) println("Buzz")
    else println(i)
  }

  // Comprehension - Apart from using for to define loops that perform some action, you can also use for together with yield
  // to transform a collection into a new collection
  val a1 = Array(1, 2, 3, 4)
  val a2 = for (i <- a1) yield i * i
  val a3 = for (i <- a1) yield "hello " + i

  // Comprehensions can also take multiple input arrays, a and b below. This flattens them out into one final
  // output Array, similar to using a nested for-loop:
  val a = Array(1, 2);
  val b = Array("hello", "world")
  val flattened = for (i <- a; j <- b) yield j + i
  println(flattened)

  //  You can also replace the parentheses () with curly brackets {} if you wish to spread out the nested loops
  //  over multiple lines, for easier reading. Note that the order of <-s within the nested comprehension
  //  matters, just like how the order of nested loops affects the order in which the loop actions will take place:

  val flattened1 = for {
    i <- a
    s <- b
  } yield s + i
  // flattened1: Array[String] = Array("hello1", "world1", "hello2", "world2")
  val flattened2 = for {
    s <- b
    i <- a
  } yield s + i
  // flattened2: Array[String] = Array("hello1", "hello2", "world1", "world2") </>
}
