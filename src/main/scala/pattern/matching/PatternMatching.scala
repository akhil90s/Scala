package pattern.matching

import scala.util.Random

object PatternMatching extends App {

  val random = new Random()
  val x = random.nextInt(10)
  val randomMatch: String = x match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case 4 => "Four"
    case 5 => "Five"
    case _ => "NA"
  }

  println(x)
  println(randomMatch)

  case class Person(name: String, age: Int)

  val john = Person("John Page", 25)
  val greeting: String = john match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) if a > 21 => s"Hi, my name is $n and I can drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }
  println(greeting)


  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  sealed trait Notification
  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  val someEmail = Email("Martin Odersky", "Scala", "Hello World")
  println(showNotification(someSms))
  println(showNotification(someVoiceRecording))
  println(showNotification(someEmail))

  sealed trait Device
  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }
  def goIdle(device: Device): String = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }
  val phone = Phone("iPhone")
  println(goIdle(phone))

  // Variable Pattern Matching
  val name: String = "Akhil"
  val nameMatch = name match {
    case n if n.equals("John") => s"Name matched to $n"
    case n if n.equals("Alex") => s"Name matched to $n"
    case n if n.equals("Akhil") => s"Name matched to $n"
    case n => s"Name not in config. Name is $n"
  }
  println(nameMatch)

  // Match anything - Wildcard
  val matchAnything = x match {
    case _ =>
  }
  // Match anything - Variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // Typed Pattern Matching
  def typedPatternMatching(x: Any) = {
    x match {
      case name: String => s"Type is String $name"
      case age: Int => s"Type is Int $age"
      case height: Double => s"Type is Double $height"
      case _ => "Type not found"
    }
  }

  println(typedPatternMatching("Akhil"))

  // Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => "Tuple2 value is (1, 1)"
    case (something, 2) => s"I've found $something"
  }

  println(matchATuple)

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  // PMs can be NESTED!

  // List Pattern Matching
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, _) :+ 42 => "lala" // infix pattern
  }

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => "list not matched"
  }

  // try catch finally
  // In Scala the catch are actually MATCHES
  try {
    // code
  } catch {
    case re: RuntimeException => re.printStackTrace()
    case npe: NullPointerException => npe.printStackTrace()
    case _ => "something else"
  }
  /*
    try {
      // code
    } catch (e) {
      e match {
        case e: RuntimeException => "runtime"
        case npe: NullPointerException => "npe"
        case _ => "something else"
      }
    }
   */

  // Generators are also based on PATTERN MATCHING
  val nums = List[Int](1, 2, 3, 4, 5)
  val evenTimesTen = for {
    num <- nums if num % 2 == 0
  } yield num * 10

  println(evenTimesTen)

  val tuples = List((2, 1), (5, 3))
  val filterTuples = for {
    (first, second) <- tuples if first > second
  } yield first * second

  println(filterTuples)

  // Name Binding property of Pattern Matching
  val mytuple3 = (1, 2, 3)
  val (a, b, c) = mytuple3
  println(a + " " + b + " " + c)

  val head :: tail = nums
  println(nums)
  println(head)
  println(tail)

  // Partial Function based on Pattern Matching
  val mappedList1 = nums.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
      0
  } // partial function literal
  println(mappedList1)

  val mappedList2 = nums.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }
  println(mappedList2)


}
