package arrays.dp

import Problem
import kotlin.math.abs
import kotlin.math.max

// #Knapsack Unbounded
class UnboundedKnapsackProblems: Problem {

    // https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
    private fun rodCutting(price: IntArray, length: IntArray): Int {
        val W = length.size
        val N =  price.size
        val dp = Array(N+1) { IntArray(W+1) }
        dp[0][0] = 0

        for (i in 1 until N+1) {
            for (j in 0 until W+1) {
                if (length[i-1] <= j) {
                    dp[i][j] = max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j])
                } else dp[i][j] = dp[i-1][j]
            }
        }
        return dp[N][W]
    }

    // https://leetcode.com/problems/coin-change-2/
    private fun coinChange2(amount: Int, coins: IntArray): Int {
        val N =  coins.size
        val W  = amount
        val dp = Array(N+1) { IntArray(W+1) }
        for (i in 0 until N+1) { dp[i][0] = 1 }
        for (i in 1 until N+1) {
            for (j in 0 until W+1) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]]+ dp[i-1][j]
                } else dp[i][j] = dp[i-1][j]
            }
        }
        return dp[N][W]
    }


    override fun solve() {
        val input1 = intArrayOf(1,5,11,5)
        val input2 = intArrayOf(1,2,3,5)
        println(rodCutting(input1, input2))
        println(coinChange2(5, intArrayOf(1,2,5)))

    }
}