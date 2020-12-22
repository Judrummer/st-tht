fun add(numbers: String): Int {
    val sub01 = numbers.substring(0, 2)
    val splitString = if (sub01.none { it in "0123456789" } && numbers[2] == '\n')
        numbers.substring(2).split(*((sub01.toList() + listOf(',', '\n')).toCharArray()))
    else numbers.split(',', '\n')
    val intList = splitString.mapNotNull { it.toIntOrNull() }
    val negativeList = intList.filter { it < 0 }
    if (negativeList.isNotEmpty()) {
        throw NegativeNotAllowedException("negatives not allowed: ${negativeList.joinToString(separator = ", ")}")
    }
    return intList.sum()
}

class NegativeNotAllowedException(override val message: String) : Throwable()


