package arrays.medium

import Problem

/*
 https://leetcode.com/problems/partition-equal-subset-sum/
* */
class EqualSubsetSumPartition: Problem {

    private fun subsetSum(nums: IntArray, target: Int): Boolean {
        val dp = Array(nums.size+1) { BooleanArray(target+1) }
        for (i in dp.indices) { dp[i][0] = true }

        for (i in 1 until dp.size) {
            for (j in 1 until dp[0].size) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j]
                } else dp[i][j] = dp[i-1][j]
            }
        }
        return dp[nums.size][target]
    }

    private fun canPartition(nums: IntArray): Boolean {
        var totalSum = 0
        for (x in nums) { totalSum += x }
        return if (totalSum % 2 == 0) {
             subsetSum(nums, totalSum/2)
        } else false
    }

    override fun solve() {
        val input1 = intArrayOf(1,5,11,5)
        val input2 = intArrayOf(1,2,3,5)
        println(canPartition(input1))
        println(canPartition(input2))
    }
}