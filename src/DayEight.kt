import java.util.*

fun main() {

    fun buildTheMap(input: List<String>): Pair<List<List<Int>>, List<List<Int>>> {
        val row = mutableListOf<MutableList<Int>>()
        val column = mutableListOf<MutableList<Int>>()
        input.forEach { line ->
            val rowLine = mutableListOf<Int>()
            line.forEachIndexed {index, tree ->
                if(column.size <= index) {
                    column.add(mutableListOf(tree.digitToInt()))
                } else {
                    column[index].add(tree.digitToInt())
                }
                rowLine.add(tree.digitToInt())
            }
            row.add(rowLine)
        }
        return Pair(row, column)
    }

    fun partOne(input: List<String>): Int {
        var total = 0
        val (row, column) = buildTheMap(input)
        row.forEachIndexed { rowIndex, treeY ->
            column.forEachIndexed { columnIndex, treeX ->
                if(rowIndex == 0 || rowIndex == row.size-1 || columnIndex == 0 || columnIndex == column.size -1) {
                    total++
                } else {
                    val fromTop = column[columnIndex].subList(0, rowIndex)
                    val fromBottom = column[columnIndex].subList(rowIndex + 1, column[columnIndex].size)
                    val fromLeft = row[rowIndex].subList(0, columnIndex)
                    val fromRight = row[rowIndex].subList(columnIndex + 1, row[rowIndex].size)
                    val tree = treeX[rowIndex]
                    if (fromTop.max() < tree && fromTop.count { it == tree } == 0) {
                        total++
                    } else if (fromBottom.max() < tree && fromBottom.count { it == tree } == 0) {
                        total++
                    } else if (fromLeft.max() < tree && fromLeft.count { it == tree } == 0) {
                        total++
                    } else if (fromRight.max() < tree && fromRight.count { it == tree } == 0) {
                        total++
                    }
                }
            }
        }


        return total
    }

    fun partTwo(input: List<String>): Int {
        var total = 0
        val (row, column) = buildTheMap(input)
        row.forEachIndexed { rowIndex, treeY ->
            column.forEachIndexed { columnIndex, treeX ->
                if(rowIndex == 0 || rowIndex == row.size-1 || columnIndex == 0 || columnIndex == column.size -1) {
                } else {
                    val tree = treeX[rowIndex]

                    val fromTop = column[columnIndex].subList(0, rowIndex).reversed()
                    val fromBottom = column[columnIndex].subList(rowIndex + 1, column[columnIndex].size)
                    val fromLeft = row[rowIndex].subList(0, columnIndex).reversed()
                    val fromRight = row[rowIndex].subList(columnIndex + 1, row[rowIndex].size)
                    val topScore = fromTop.indexOfFirst { it >= tree }.let { if(it == -1) fromTop.size else it + 1 }
                    val bottomScore = fromBottom.indexOfFirst { it >= tree }.let { if(it == -1) fromBottom.size else it + 1 }
                    val leftScore = fromLeft.indexOfFirst { it >= tree }.let { if(it == -1) fromLeft.size else it + 1 }
                    val rightScore = fromRight.indexOfFirst { it >= tree }.let { if(it == -1) fromRight.size else it + 1 }
                    if(topScore * bottomScore * leftScore * rightScore > total) {
                        total = topScore * bottomScore * leftScore * rightScore
                    }
                }
            }
        }
        return total
    }

    val input = readInput("dayeight")
//    val input = readInput("dayeightex")

    println(partOne(input))
    println(partTwo(input))
}


