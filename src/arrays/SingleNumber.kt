package arrays

import Problem

class SingleNumber: Problem {

    private fun singleNumber(nums: IntArray): Int {
        var res = 0
        for (element in nums) {
            res = res xor element
        }
        return res
    }

    override fun solve() {
        println(singleNumber(intArrayOf(2,2,1)))
        println(singleNumber(intArrayOf(4,1,2,1,2)))
        println(singleNumber(intArrayOf(1)))
    }
}