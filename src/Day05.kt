fun main() {

    fun part1(input: List<String>): String {
        val stacks: List<MutableList<String>> = listOf(
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        )
        for (line in input.subList(0, 8)) {
            for (index in stacks.indices) {
                if (line.length >= index * 4 + 1 && line[index * 4 + 1].toString() != " ") {
                    stacks[index].add(line[index * 4 + 1].toString())
                }
            }
        }
        stacks.forEach { it.reverse() }
        val instructions: MutableList<List<Int>> = mutableListOf()
        for (line in input.subList(10, input.size)) {
            val temp = mutableListOf<Int>()
            temp.add(line.split(" ")[1].toInt())
            temp.add(line.split(" ")[3].toInt())
            temp.add(line.split(" ")[5].toInt())
            instructions += temp
        }
        for (instruction in instructions) {
            for (i in 0 until instruction[0]) {
                stacks[instruction[2] - 1].add(stacks[instruction[1] - 1].removeLast())
            }
        }
        var result = ""
        stacks.forEach { result += it.last() }
        return result
    }

    fun part2(input: List<String>): String {
        val stacks: List<MutableList<String>> = listOf(
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        )
        for (line in input.subList(0, 8)) {
            for (index in stacks.indices) {
                if (line.length >= index * 4 + 1 && line[index * 4 + 1].toString() != " ") {
                    stacks[index].add(line[index * 4 + 1].toString())
                }
            }
        }
        stacks.forEach { it.reverse() }
        val instructions: MutableList<List<Int>> = mutableListOf()
        for (line in input.subList(10, input.size)) {
            val temp = mutableListOf<Int>()
            temp.add(line.split(" ")[1].toInt())
            temp.add(line.split(" ")[3].toInt())
            temp.add(line.split(" ")[5].toInt())
            instructions += temp
        }
        for (instruction in instructions) {
            val temp = mutableListOf<String>()
            for (i in 0 until instruction[0]) {
                temp.add(stacks[instruction[1] - 1].removeLast())
            }
            stacks[instruction[2] - 1] += temp.reversed()
        }
        var result = ""
        stacks.forEach { result += it.last() }
        return result
    }

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}