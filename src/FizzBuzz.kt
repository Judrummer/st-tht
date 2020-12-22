fun fizzBuzz(start: Int, end: Int) {
    (start..end).forEach {
        when {
            it % 3 == 0 && it % 5 == 0 -> println("FizzBuzz")
            it % 3 == 0 -> println("Fizz")
            it % 5 == 0 -> println("Buzz")
            else -> println("$it")
        }
    }
}