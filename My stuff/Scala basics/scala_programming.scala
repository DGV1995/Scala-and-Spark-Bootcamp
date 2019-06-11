import util.control.Breaks._

/*val person = "Diego"

if (person == "Sammy") {
  println("Welcome Sammy")
} else if (person == "George") {
  println("Welcome George")
} else {
  println(s"You're not welcome, $person")
}*/

/*for (num <- Range(0,11)) {
  if (num % 2 == 0) {
    println(s"$num is even")
  } else {
    println(s"$num is odd")
  }
}*/

var x = 0

while (x < 5) {
  println(s"x is currenty $x")
  println(s"$x is still less than 5, adding 1 to x")
  if (x == 3)
    break
  x += 1
}
