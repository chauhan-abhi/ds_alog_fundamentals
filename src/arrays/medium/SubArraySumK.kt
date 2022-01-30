package arrays.medium

import Problem

/*
* https://leetcode.com/problems/subarray-sum-equals-k/
* */
class SubArraySumK: Problem {

    private  fun subarraySum(nums: IntArray, k: Int): Int {

        val map = hashMapOf<Int, Int>()
        var count = 0
        var sum = 0
        map[0] = 1
        for (i in nums.indices) {
            sum += nums[i]
            count += map.getOrDefault(sum-k, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count

    }

    override fun solve() {
        val input = intArrayOf(1,2,3)
        val input2 = intArrayOf(1,1,1)
        val input3 = intArrayOf(3,4,7,2,-3,1,4,2)
        println(subarraySum(input, 3))
        println(subarraySum(input2, 2))
        println(subarraySum(input3, 7))
    }
}