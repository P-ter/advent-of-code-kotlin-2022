import java.util.*

data class File(val name: String, val size: Int)

data class Folder(val name: String, val files: MutableList<File>, val folders: MutableList<Folder>)

fun main() {

    fun parseCommand(commands: List<String>): Folder {
        val root = Folder("/", mutableListOf(), mutableListOf())
        var currentFolder = root
        var folderList = mutableListOf(currentFolder)
        commands.subList(1, commands.size).forEach { command ->
            if(command == ("$ ls")) {

            } else if (command.contains("dir")) {
                val folderName = command.split(" ").last()
                currentFolder.folders.add(Folder(folderName, mutableListOf(), mutableListOf()))
            } else if (command.split(" ").first().toIntOrNull() != null) {
                val (size, fileName) = command.split(" ")
                currentFolder.files.add(File(fileName, size.toInt()))
            } else if (command.contains("$ cd") && !command.contains("..")) {
                val folderName = command.split(" ").last()
                currentFolder = currentFolder.folders.first { it.name == folderName }
                folderList.add(currentFolder)
            } else if (command == "$ cd ..") {
                currentFolder = folderList[folderList.size - 2]
                folderList.removeAt(folderList.size - 1)
            }
        }
        return root
    }



    fun partOne(fileStructure: Folder): Int {
        var grandTotal = 0

        fun calculateSize(folder: Folder): Int {
            var total = 0
            folder.files.forEach { total += it.size }
            folder.folders.forEach { total += calculateSize(it) }
            if(total <= 100000) {
                grandTotal += total
            }
            return total
        }

        calculateSize(fileStructure)
        return grandTotal
    }

    fun partTwo(fileStructure: Folder): Int {
        var grandTotal = 0
        var totalList = mutableListOf<Int>()
        var spaceUnused = 70000000 - 46728267
        var spaceRequired = 30000000 - spaceUnused
        fun calculateSize(folder: Folder): Int {
            var total = 0
            folder.files.forEach { total += it.size }
            folder.folders.forEach { total += calculateSize(it) }
            if(total >= spaceRequired) {
                totalList.add(total)
            }
            return total
        }

        val rootSize = calculateSize(fileStructure)
        return totalList.min()
    }

    val input = readInput("dayseven")
//    val input = readInput("example")

    val commands = parseCommand(input)
    println(partOne(commands))
    println(partTwo(commands))
}


