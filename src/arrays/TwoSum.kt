package arrays

import Problem

class TwoSum: Problem {

    fun twoSum(list: List<Int>, sum: Int) : IntArray {
        var diff: Int
        val map = HashSet<Int>()
        for(element in list) {
            diff = sum - element
            if(map.contains(diff)) return intArrayOf(element, diff)
            else map.add(element)
        }
        return intArrayOf()
    }

    fun twoSumIndex(nums: IntArray, target: Int): IntArray {
        var diff: Int
        val map = HashMap<Int, Int>()
        for(i in nums.indices) {
            val element = nums[i]
            diff = target - element
            if(map.containsKey(diff)) return intArrayOf(i, map.getOrDefault(diff, 0))
            else map[element] = i
        }
        return intArrayOf()
    }

    override fun solve() {
        val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
        val array2 = intArrayOf(5, 1, 22, 25, 6, -1, 8, 10)
        println(twoSum(array, 6))
        val output = twoSumIndex(array2, 6)
        for (x in output) print("$x  ")
    }
}