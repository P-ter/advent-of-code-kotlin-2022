import kotlin.math.roundToInt

fun main() {


    fun partOne(input: List<String>): Int {
        var total = 0
        input.forEach { line ->
            val middle = (line.length / 2.0).roundToInt()
            val firstHalf = line.substring(0, middle)
            val secondHalf = line.substring(middle)
            val intersection = firstHalf.toCharArray().toList().intersect(secondHalf.toCharArray().toList())

            if (intersection.isNotEmpty()) {
                intersection.forEach {
                    if(it.isLowerCase()) {
                        total += it.code - 96
                    } else if (it.isUpperCase()) {
                        total += it.code - 64 + 26
                    }
                }
            }
        }
        return total
    }

    fun partTwo(input: List<String>): Int {
        var total = 0
        input.chunked(3).forEach { group ->
            val first = group[0]
            val second = group[1]
            val third = group[2]
            val firstSecond = first.toCharArray().toList().intersect(second.toCharArray().toList())
            val secondThird = second.toCharArray().toList().intersect(third.toCharArray().toList())
            val firstThird = first.toCharArray().toList().intersect(third.toCharArray().toList())
            val intersection = firstSecond.intersect(secondThird).intersect(firstThird)
            if (intersection.isNotEmpty()) {
                intersection.forEach {
                    if(it.isLowerCase()) {
                        total += it.code - 96
                    } else if (it.isUpperCase()) {
                        total += it.code - 64 + 26
                    }
                }
            }
        }

        return total
    }

    val input = readInput("daythree")
    println(partOne(input))
    println(partTwo(input))
}


