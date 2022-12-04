import kotlin.math.roundToInt

fun main() {


    fun partOne(input: List<String>): Int {
        var total = 0
        input.forEach { line ->
            val (firstElf, secondElf) = line.split(",")
            val firstElfRange = firstElf.split("-").map { it.toInt() }
            val secondElfRange = secondElf.split("-").map { it.toInt() }
            if(firstElfRange[0] in secondElfRange[0]..secondElfRange[1] && firstElfRange[1] in secondElfRange[0]..secondElfRange[1]) {
                total++
            } else if(secondElfRange[0] in firstElfRange[0]..firstElfRange[1] && secondElfRange[1] in firstElfRange[0]..firstElfRange[1]) {
                total++
            }
        }

        return total
    }

    fun partTwo(input: List<String>): Int {
        var total = 0
        input.forEach { line ->
            val (firstElf, secondElf) = line.split(",")
            val firstElfRange = firstElf.split("-").map { it.toInt() }
            val secondElfRange = secondElf.split("-").map { it.toInt() }
            if(firstElfRange[0] in secondElfRange[0]..secondElfRange[1] || firstElfRange[1] in secondElfRange[0]..secondElfRange[1]) {
                total++
            } else if(secondElfRange[0] in firstElfRange[0]..firstElfRange[1] || secondElfRange[1] in firstElfRange[0]..firstElfRange[1]) {
                total++
            }
        }
        return total
    }

    val input = readInput("dayfour")
    println(partOne(input))
    println(partTwo(input))
}


