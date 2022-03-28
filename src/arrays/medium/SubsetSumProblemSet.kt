package arrays.medium

import Problem
import kotlin.math.abs

class SubsetSumProblemSet: Problem {

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

    private fun subsetSumCountGeneric(nums: IntArray, target: Int): Int {
        val dp = Array(nums.size+1) { IntArray(target+1) }
        for (i in dp.indices) { dp[i][0] = 1 }

        for (i in 1 until dp.size) {
            for (j in 1 until dp[0].size) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]
                } else dp[i][j] = dp[i-1][j]
            }
        }
        return dp[nums.size][target]
    }

    //  https://leetcode.com/problems/partition-equal-subset-sum/
    private fun canEqualPartition(nums: IntArray): Boolean {
        var totalSum = 0
        for (x in nums) { totalSum += x }
        return if (totalSum % 2 == 0) {
             subsetSum(nums, totalSum/2)
        } else false
    }

    // https://leetcode.com/problems/target-sum/
    /*
    * Divide into two subsets S1, S2 such that
    * where S1 contains all elements that will take + elements
    * where S1 contains all elements that will take - elements
    * S1+S2 = totalSum
    * S2-S2 = targetSum
    * S1 = (totalSum + target)/2
    * conclusion = finding count of subsets which are having sum equal to S1.
    * */
    private fun findTargetSumWays(nums: IntArray, target: Int): Int {
        var totalSum = 0
        for (x in nums) { totalSum += x }
        if (abs(target) > totalSum || (totalSum + target) %2 != 0) return 0
        return subsetSumCount1(nums, (totalSum + target)/2)
    }

    private fun subsetSumCount1(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = Array(n+1) { IntArray(target+1) }
        dp[0][0] = 1
        for (i in 1 until target+1) { dp[0][i] = 0 }

        for (i in 1 until n) {
            for (j in 0 until target+1) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]
                } else dp[i][j] = dp[i-1][j]
            }
        }
        return dp[n][target]
    }


    override fun solve() {
        val input1 = intArrayOf(1,5,11,5)
        val input2 = intArrayOf(1,2,3,5)
        val input3 = intArrayOf(1000)
        println(canEqualPartition(input1))
        println(canEqualPartition(input2))
        println(findTargetSumWays(input3, -1000))
    }
}