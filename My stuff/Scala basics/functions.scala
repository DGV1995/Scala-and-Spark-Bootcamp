def add(a: Int, b: Int): Int = {
  a + b
}

//add(2,5)

def greetName(name: String): String = {
  return s"Hello $name"
}

//println(greetName("Diego"))

def isPrime(number: Int): Boolean = {
  for (n <- Range(2, number)) {
    if (number % n == 0)
      return false
  }
  return true
}

/*isPrime(23) // true
isPrime(10)*/ // false
