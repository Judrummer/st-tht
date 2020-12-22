import kotlin.math.max

fun harryPotter(inputs: List<Int>) {
    var currentInputs = inputs
    var output = 0
    val priceSetMap = mapOf(
        5 to 375, // 500*0.75
        4 to 320, // 400*0.80
        3 to 270, // 300*0.90
        2 to 190, // 200*0.95
        1 to 100, // 100
    )
    var distinctCount = currentInputs.count { it > 0 }
    while (distinctCount > 0) {
        output += priceSetMap[distinctCount] ?: 0
        currentInputs = currentInputs.map { max(it - 1, 0) }
        distinctCount = currentInputs.count { it > 0 }
    }
    println("$output")
}