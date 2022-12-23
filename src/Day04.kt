fun main() {

    fun part1(input: List<String>): Int {
        val pairList: MutableList<List<Int>> = mutableListOf()
        for (pair in input) {
            var temp = pair.split(",")
            temp = temp.first().split("-") + temp.last().split("-")
            pairList.add(temp.map { it -> it.toInt() })
        }
        var fullyContained = 0
        for (pair in pairList){
            if ((pair[0] <= pair[2] && pair[1]>= pair[3]) || (pair[0] >= pair[2] && pair[1]<= pair[3])){
                fullyContained++
            }
        }
        return fullyContained
    }

    fun part2(input: List<String>): Int {
        val pairList: MutableList<List<Int>> = mutableListOf()
        for (pair in input) {
            var temp = pair.split(",")
            temp = temp.first().split("-") + temp.last().split("-")
            pairList.add(temp.map { it -> it.toInt() })
        }
        var overlaps = 0
        for (pair in pairList){
            if ((pair[0]..pair[1]).intersect(pair[2]..pair[3]).isNotEmpty()){
                overlaps++
            }
        }
        return overlaps
    }

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}