// 1) Write a function that takes in an integer and returns a Boolean indicating whether or nos it is even.
def isEven(n: Int): Boolean = {
  //if (n % 2 == 0) {return true} else {return false}
  return n % 2 == 0
}

//println(isEven(25)) // false

// 2) Write a function that returns True if there is an even number inside of a List, otherwise, return false
def checkEven(numbers: List[Int]): Boolean = {
  for (num <- numbers) {
    if (num % 2 == 0)
      return true
  }
  return false
}

//println(checkEven(List(1,3,5,7,4))) // true

// 3) Take in a list of integers and calculate their sum. However, sevens are lucky and they should be counted twice
def getSum(nums: List[Integer]): Integer = {
  var sum = 0
  for (num <- nums) {
    if (num == 7) {
      sum += num*2
    } else {
      sum += num
    }
  }
  return sum
}

//println(getSum(List(2,4,5,6,7))) // 2+4+5+6+7*2 = 31

// 4) Given a non-empty list of integers, return true if there ir a place to split the list so that the sum of
// the numbers on one side is equals to the sum of the numbers on the other side. For example, given the list
// (1,5,3,3) would return true, so you can split it in the middle 1 + 5 = 3 + 3. Another example (7,3,4) would return true, so
// / = 3 + 4
def isPlace(nums: List[Int]): Boolean = {
  for (i <- Range(2, nums.size)) {
    if (nums.slice(0,i).sum == nums.slice(i, nums.size).sum)
      return true
  }
  return false
}

//println(isPlace(List(3,4,6))) // false
//println(isPlace(List(2,2,2,3,3))) // true

// 5) Given a String, return a boolean indicating whether or not it is a palindrome (Spelled the same
// forwards and backwards).
def isPalindrome(sentence: String): Boolean = {
  sentence = sentence.replace(" ", "").replace(",")
}

//println(isPalindrome("hola")) // false
//println(isPalindrome("Yo dono rosas, oro no doy")) // true
var string = "Yo dono rosas, oro no doy".replace(" ", "").replace(",", "").toLowerCase
var array = string.split("")
var other = string.reverse.split("")
for (c <- array) {
  print(c)
}
print("\n")
for (c <- other) {
  print(c)
}
