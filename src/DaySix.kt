import java.util.*

fun main() {



    fun partOne(input: List<String>): Int {
        var total = 0
        val line = input.first()
//        val line = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        line.windowed(4).forEachIndexed { index, block ->
            val characters = block.toCharArray().toSet()
            if(characters.size == 4) {
                println(index + 4)
                return 0
            }
        }
        return total
    }

    fun partTwo(input: List<String>): Int {
        var total = 0
        val line = input.first()
//        val line = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        line.windowed(14).forEachIndexed { index, block ->
            val characters = block.toCharArray().toSet()
            if(characters.size == 14) {
                println(index + 14)
                return 0
            }
        }
        return total
    }

    val input = readInput("daysix")
    println(partOne(input))
    println(partTwo(input))
}


