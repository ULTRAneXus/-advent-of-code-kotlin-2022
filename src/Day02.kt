fun main() {

    fun part1(input: List<String>): Int {
        val pairedList: MutableList<Pair<String, String>> = mutableListOf()
        for (line in input) {
            pairedList.add(Pair(line.split(" ").first(), line.split(" ").last()))
        }
        var score = 0
        for (pair in pairedList) {
            score += when (pair.second) {
                "X" -> {
                    when (pair.first) {
                        "A" -> 3
                        "B" -> 0
                        "C" -> 6
                        else -> 0
                    } + 1
                }

                "Y" -> {
                    when (pair.first) {
                        "A" -> 6
                        "B" -> 3
                        "C" -> 0
                        else -> 0
                    } + 2
                }

                "Z" -> {
                    when (pair.first) {
                        "A" -> 0
                        "B" -> 6
                        "C" -> 3
                        else -> 0
                    } + 3
                }

                else -> 0
            }
        }
        return score
    }

    fun part2(input: List<String>): Int {
        val pairedList: MutableList<Pair<String, String>> = mutableListOf()
        for (line in input) {
            pairedList.add(Pair(line.split(" ").first(), line.split(" ").last()))
        }
        var score = 0
        for (pair in pairedList) {
            score += when (pair.second) {
                "X" -> {
                    when (pair.first) {
                        "A" -> 3
                        "B" -> 1
                        "C" -> 2
                        else -> 0
                    } + 0
                }

                "Y" -> {
                    when (pair.first) {
                        "A" -> 1
                        "B" -> 2
                        "C" -> 3
                        else -> 0
                    } + 3
                }

                "Z" -> {
                    when (pair.first) {
                        "A" -> 2
                        "B" -> 3
                        "C" -> 1
                        else -> 0
                    } + 6
                }

                else -> 0
            }
        }
        return score
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}