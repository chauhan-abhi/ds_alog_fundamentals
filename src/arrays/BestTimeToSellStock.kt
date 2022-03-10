package arrays

import Problem
import kotlin.math.max

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
class BestTimeToSellStock : Problem {

    private fun bestTimeToSellStock(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var max = 0
        var minSoFar = prices[0]
        for (x in prices) {
            if (minSoFar < x)
                max = max(max, x - minSoFar)
            else minSoFar = x
        }
        return max
    }

    private fun bestTimeToSellStockII(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var max = 0
        for (idx in 1 until prices.size) {
            if (prices[idx] > prices[idx - 1])
                max += prices[idx] - prices[idx - 1]
        }
        return max
    }

    private fun bestTimeToSellStockIII(prices: IntArray, k: Int): Int {
        val n = prices.size
        if (n == 0) return 0
        //var profit = 0
        val dp = Array(k+1) { IntArray(n) }

        for (j in 0 until n)
            dp[0][j] = 0

        for (j in 0..k)
            dp[j][0] = 0

        for (i in 1..k) {
            var mx = -prices[0]
            for (j in 1 until n) {
                val hold = dp[i][j-1]
                val bookProfit = prices[j] + mx
                dp[i][j] = Math.max(hold, bookProfit)

                mx = Math.max(mx, dp[i-1][j-1]- prices[j])
            }
        }

        return dp[k][n-1]
    }

    override fun solve() {
        val array = intArrayOf(7, 1, 5, 3, 6, 4)
        val array2 = intArrayOf(3, 2, 6, 5, 0, 3)
        val array3 = intArrayOf(7, 1, 5, 3, 6, 4)
        val array4 = intArrayOf(3,3,5,0,0,3,1,4)
        val array5 = intArrayOf(1,2,3,4,5)
        val array6 = intArrayOf(7,6,4,3,1)
        println(bestTimeToSellStock(array))
        println(bestTimeToSellStock(array2))
        println(bestTimeToSellStockII(array3))
        println(bestTimeToSellStockIII(array4, 2))
        println(bestTimeToSellStockIII(array5, 2))
        println(bestTimeToSellStockIII(array6, 2))
    }
}