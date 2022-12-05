import java.util.*

fun main() {



    fun partOne(input: List<String>): Int {
        var total = 0
        val stacks = (0 .. 9).map { Stack<String>() }
        input.take(8).forEach { line ->
            line.windowed(3, 4).forEachIndexed { index, crate ->
                if(crate.isNotBlank()) {
                    stacks[index].push(crate)
                }
            }
        }
        stacks.forEach { it.reverse() }
        val instructions = input.subList(10, input.size).forEach {line ->
            val (numberOfBlock, fromIndex, toIndex) = line.split(" ").filter { it.isNotBlank() && it.toIntOrNull() != null }.map { it.toInt() }
            for(i in 1 .. numberOfBlock) {
                stacks[toIndex-1].push(stacks[fromIndex-1].pop())
            }
        }
        stacks.forEach {
            if(it.isNotEmpty()) {
                println(it.peek())
            }
        }
        return total
    }

    fun partTwo(input: List<String>): Int {
        var total = 0
        val stacks = (0 .. 9).map { mutableListOf<String>() }.toMutableList()
        input.take(8).forEach { line ->
            line.windowed(3, 4).forEachIndexed { index, crate ->
                if(crate.isNotBlank()) {
                    stacks[index].add(crate)
                }
            }
        }
        stacks.forEach { it.reverse() }
        val instructions = input.subList(10, input.size).forEach {line ->
            val (numberOfBlock, fromIndex, toIndex) = line.split(" ").filter { it.isNotBlank() && it.toIntOrNull() != null }.map { it.toInt() }
            stacks[toIndex-1].addAll(stacks[fromIndex-1].takeLast(numberOfBlock))
            stacks[fromIndex-1] = stacks[fromIndex-1].dropLast(numberOfBlock).toMutableList()
        }
        stacks.forEach {
            println(it.lastOrNull())
        }
        return total
    }

    val input = readInput("dayfive")
    println(partOne(input))
    println(partTwo(input))
}


