fun main() {
    fun partOne() {
        val input = readInput("daytwo")
        var totalPoint = 0
        input.forEach {
            val split = it.split(" ")
            val oponent = split[0]
            val myMove = split[1]
            when(oponent) {
                "A" -> {
                    if(myMove == "Y") {
                        totalPoint += 6 + 2
                    } else if(myMove == "X") {
                        totalPoint += 1 + 3
                    } else {
                        totalPoint += 3
                    }
                }
                "B" -> {
                    if(myMove == "X") {
                        totalPoint++
                    } else if(myMove == "Z") {
                        totalPoint += 3 + 6
                    } else {
                        totalPoint += 2 + 3
                    }
                }
                "C" -> {
                    if(myMove == "X") {
                        totalPoint += 6 + 1
                    } else if(myMove == "Y") {
                        totalPoint += 2
                    } else {
                        totalPoint += 3 + 3
                    }
                }
            }
        }
        println(totalPoint)
    }

    fun partTwo() {
        val input = readInput("daytwo")
        var totalPoint = 0
        input.forEach {
            val split = it.split(" ")
            val oponent = split[0]
            val myMove = split[1]
            when(oponent) {
                "A" -> {
                    if(myMove == "X") {
                        totalPoint += 3
                    } else if(myMove == "Y") {
                        totalPoint += 3 + 1
                    } else {
                        totalPoint += 6 + 2
                    }
                }
                "B" -> {
                    if(myMove == "X") {
                        totalPoint += 1
                    } else if(myMove == "Y") {
                        totalPoint += 3 + 2
                    } else {
                        totalPoint += 3 + 6
                    }
                }
                "C" -> {
                    if(myMove == "X") {
                        totalPoint += 2
                    } else if(myMove == "Y") {
                        totalPoint += 3 + 3
                    } else {
                        totalPoint += 6 + 1
                    }
                }
            }
        }
        println(totalPoint)
    }
    partOne()
    partTwo()
}

