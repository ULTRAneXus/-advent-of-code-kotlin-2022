fun main() {

    val duplicates = IntArray(52)

    fun addDuplicate(duplicate: Char) {
        if (duplicate.code > 95) duplicates[duplicate.code - 97]++
        else duplicates[duplicate.code - 39]++
    }

    fun part1(input: List<String>): Int {
        for (line in input) {
            val front = line.substring(0, line.length / 2).toCharArray()
            val back = line.substring(line.length / 2).toCharArray()
            var duplicateItem: Char = (-1).toChar()
            for (frontItem in front) {
                for (backItem in back) {
                    if (frontItem == backItem) {
                        duplicateItem = frontItem
                    }
                }
            }
            addDuplicate(duplicateItem)
        }
        return duplicates.indices.sumOf { index -> (index + 1) * duplicates[index] }
    }

    fun part2(input: List<String>): Int {
        val groups = input.chunked(3)
        for (group in groups) {
            var duplicateItem: Char = (-1).toChar()
            for (firstItem in group[0]) {
                for (secondItem in group[1]) {
                    for (thirdItem in group[2]) {
                        if (firstItem == secondItem && secondItem == thirdItem) duplicateItem = firstItem
                    }
                }
            }
            addDuplicate(duplicateItem)
        }
        return duplicates.indices.sumOf { index -> (index + 1) * duplicates[index] }
    }

    val input = readInput("Day03")
    part1(input).println()
    duplicates.indices.forEach { duplicates[it] = 0 }
    part2(input).println()
}