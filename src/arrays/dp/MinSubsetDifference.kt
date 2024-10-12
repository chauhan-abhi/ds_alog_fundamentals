package arrays.dp

import DP
import Problem

// #Knapsack 0-1
// https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
class MinSubsetDifference : Problem, DP {

    /*
    * To divide nums in two subsets S1, S2
    * Since S1 + S2 = totalSum
    * we can say S2 = totalSum - S1
    * Minimize |S2- S1| ie |TotalSum - 2*S1|
    * If one set is empty other contains all elements hence range of elements
    * in S2 can be [0, targetSum]
    * But all i < targetSum cannot be possible from elements of array ,
    * use subset Sum problem to decide what sums in range [0, targetSum]
    * are possible ->
    * last row of dp array tells if array.size = full then is [0, targetSum] true/false
    * Take true values less than sum/2 and check min
    * Assuming S1 to be smaller
    *
    *  */
    private fun minimumDifference(nums: IntArray): Int {
        var totalSum = 0
        for (x in nums) { totalSum += x }

        val n = nums.size
        val dp = Array(n+1) { BooleanArray(totalSum+1) }
        for (i in dp.indices) { dp[i][0] = true }

        for (i in 1 until n+1) {
            for (j in 1 until totalSum+1) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j]
                } else dp[i][j] = dp[i-1][j]
            }
        }
        var diff = Int.MAX_VALUE
        for (j in totalSum/2 downTo 0) {
            if (dp[n][j]) {
                diff = totalSum - 2* j
                break
            }
        }

        return diff
    }

    // Count the number of subset with a given difference
    // https://leetcode.com/problems/target-sum/
    /*
    *  S1+ S2 = totalSum
    *  S1- S2 = targetDiff
    *  S1 = (totalSum + targetDiff)/2
    *
    *  problem breaks to find count of subset having target as (totalSum + targetDiff)/2
    * */
    private fun countOfSubsetHavingDifference(nums: IntArray, targetDiff: Int): Int {
        var totalSum = 0
        for (x in nums) { totalSum += x }

        val targetSum = (totalSum + targetDiff)/2
        return subsetSumCountGeneric(nums, targetSum)
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


    override fun solve() {
        val input1 = intArrayOf(1, 6, 11, 5)
        val input2 = intArrayOf( 3, 1, 4, 2, 2, 1 )
        val input3 = intArrayOf( 1, 1, 2, 3 )
        println(minimumDifference(input1))
        println(minimumDifference(input2))
        println(countOfSubsetHavingDifference(input3, 1))

    }
}