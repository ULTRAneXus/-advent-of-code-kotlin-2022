fun main() {

    fun part1(input: List<String>): Int {
        for (index in 0 until input[0].length - 3) {
            val pattern = input[0].subSequence(index, index + 4)
            if (pattern.toList().distinct().size == 4) {
                println(pattern)
                return index + 4
            }
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        for (index in 0 until input[0].length - 13) {
            val pattern = input[0].subSequence(index, index + 14)
            if (pattern.toList().distinct().size == 14) {
                println(pattern)
                return index + 14
            }
        }
        return -1
    }

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}