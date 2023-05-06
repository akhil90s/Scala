package functions

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA)
  val doubler1: Int => Int = (x: Int) => x * 2
  val doubler2 = (x: Int) => x * 2

  // multiplier
  val multiplier: (Int, Int) => Int = (x: Int, y: Int) => x * y;
  println(multiplier(5, 7))

  // multiple params in a lambda
  val adder1: (Int, Int) => Int = (a: Int, b: Int) => a + b
  val adder2 = (x: Int, y: Int) => x + y
  println(adder1(3, 5))

  // no params
  val justDoSomething: () => Int = () => 3

  // Function Itself
  println(justDoSomething)
  // Actual Function Call
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = (str: String) => str.toInt

  // More Syntactic Sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}

