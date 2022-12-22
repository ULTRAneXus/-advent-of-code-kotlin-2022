fun main() {

    /**
     * Splits a list divided by empty lines into sub lists
     */
    fun findSubLists(input: List<String>): List<List<String>> {
        val subLists: MutableList<List<String>> = mutableListOf()
        var segmentStart: Int
        var segmentEnd = 0
        for (index in input.indices) {
            if (input[index] == "") {
                segmentStart = segmentEnd
                segmentEnd = index
                subLists.add(input.subList(segmentStart, segmentEnd).filter { it != "" })
            }
        }
        return subLists
    }

    fun part1(input: List<String>): Int {
        val subLists = findSubLists(input)
        return subLists.maxOf { list -> list.sumOf { it.toInt() } }
    }

    fun part2(input: List<String>): Int {
        val subLists = findSubLists(input)
        val calories = mutableListOf<Int>()
        for (list in subLists) {
            calories.add(list.sumOf { it.toInt() })
        }
        calories.sortDescending()
        return calories[0] + calories[1] + calories[2]
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
