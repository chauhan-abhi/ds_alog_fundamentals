package arrays

import Problem

class TwoSum: Problem {

    fun twoSum(list: List<Int>, sum: Int): List<Int> {
        var diff: Int
        val map = HashSet<Int>()
        for(element in list) {
            diff = sum - element
            if(map.contains(diff)) return listOf(element, diff)
            else map.add(element)
        }
        return listOf()
    }

    override fun solve() {
        val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
        print(twoSum(array, 6))
    }
}