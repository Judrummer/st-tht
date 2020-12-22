fun add(numbers: String): Int {
    val firstNewLineIndex = numbers.indexOfFirst { it == '\n' }
    val previousNewLineIndex = firstNewLineIndex - 1
    val isCustomDelimiter =
        firstNewLineIndex != -1 && previousNewLineIndex >= 0 && (numbers[previousNewLineIndex] !in "0123456789")
    val splitString = if (isCustomDelimiter) {
        val sub = numbers.substring(0, firstNewLineIndex)
        numbers.substring(firstNewLineIndex).split(*((sub.toList() + listOf(',', '\n')).toCharArray()))
    } else {
        numbers.split(',', '\n')
    }
    val intList = splitString.mapNotNull { it.toIntOrNull() }
    val negativeList = intList.filter { it < 0 }
    if (negativeList.isNotEmpty()) {
        throw NegativeNotAllowedException("negatives not allowed: ${negativeList.joinToString(separator = ", ")}")
    }
    return intList.sum()
}

class NegativeNotAllowedException(override val message: String) : Throwable()


