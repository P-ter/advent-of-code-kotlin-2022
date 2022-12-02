fun main() {


    fun partOne(input: List<String>): Int {
        val resultMap = buildMap {
            put(Pair("A", "X"), 3)
            put(Pair("A", "Y"), 6)
            put(Pair("A", "Z"), 0)
            put(Pair("B", "X"), 0)
            put(Pair("B", "Y"), 3)
            put(Pair("B", "Z"), 6)
            put(Pair("C", "X"), 6)
            put(Pair("C", "Y"), 0)
            put(Pair("C", "Z"), 3)
        }

        val point = buildMap {
            put("X", 1)
            put("Y", 2)
            put("Z", 3)
        }

        val total = input.fold(0) { acc, pair ->
            val (opponent, myMove) = pair.split(" ")
            var point = point[myMove] ?: 0
            point += resultMap[Pair(opponent, myMove)] ?: 0
            acc + point
        }

        return total
    }

    fun partTwo(input: List<String>): Int {
        val resultMap = buildMap {
            put(Pair("A", "X"), 3)
            put(Pair("A", "Y"), 1)
            put(Pair("A", "Z"), 2)
            put(Pair("B", "X"), 1)
            put(Pair("B", "Y"), 2)
            put(Pair("B", "Z"), 3)
            put(Pair("C", "X"), 2)
            put(Pair("C", "Y"), 3)
            put(Pair("C", "Z"), 1)
        }

        val point = buildMap {
            put("X", 0)
            put("Y", 3)
            put("Z", 6)
        }

        val total = input.fold(0) { acc, pair ->
            val (opponent, myMove) = pair.split(" ")
            var point = point[myMove] ?: 0
            point += resultMap[Pair(opponent, myMove)] ?: 0
            acc + point
        }

        return total
    }

    val input = readInput("daytwo")
    println(partOne(input))
    println(partTwo(input))
}


