fun main() {

    fun part1(input: List<String>): Int {
        val runningTotal = mutableListOf<Int>()
        var currentTotal = 0
        input.forEach {
            if(it.isBlank()) {
                runningTotal.add(currentTotal)
                currentTotal = 0
            } else {
                currentTotal += it.toInt()
            }
        }
        return runningTotal.max()
    }

    fun part2(input: List<String>): Int {
        val runningTotal = mutableListOf<Int>()
        var currentTotal = 0
        input.forEach {
            if(it.isBlank()) {
                runningTotal.add(currentTotal)
                currentTotal = 0
            } else {
                currentTotal += it.toInt()
            }
        }
        runningTotal.sortDescending()
        return runningTotal.take(3).sum()
    }

    val testInput = readInput("dayone")
    println(part1(testInput))
    println(part2(testInput))
}
