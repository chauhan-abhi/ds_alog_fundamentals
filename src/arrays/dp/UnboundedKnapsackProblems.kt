package arrays.dp

import Problem
import kotlin.math.abs

// #Knapsack Unbounded
class UnboundedKnapsackProblems: Problem {

    // https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//    private fun rodCutting(price: IntArray, length: IntArray): Int {
//        val n = length.size
//        val dp = Array(n+1) { IntArray(target+1) }
//        dp[0][0] = 1
//        for (i in 1 until target+1) { dp[0][i] = 0 }
//
//        for (i in 1 until n) {
//            for (j in 0 until target+1) {
//                if (nums[i-1] <= j) {
//                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j]
//                } else dp[i][j] = dp[i-1][j]
//            }
//        }
//        return dp[n][target]
//    }


    override fun solve() {
        val input1 = intArrayOf(1,5,11,5)
        val input2 = intArrayOf(1,2,3,5)
        val input3 = intArrayOf(1000)

    }
}