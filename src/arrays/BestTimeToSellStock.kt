package arrays

import Problem
import kotlin.math.max

class BestTimeToSellStock: Problem {

    private fun bestTimeToSellStock(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var max = 0
        var minSoFar  = prices[0]
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
            if (prices[idx] > prices[idx-1])
                max+= prices[idx]-prices[idx-1]
        }
        return max
    }

    override fun solve() {
        val array = intArrayOf(7,1,5,3,6,4)
        val array2 = intArrayOf(3,2,6,5,0,3)
        val array3 = intArrayOf(7,1,5,3,6,4)
        print(bestTimeToSellStock(array))
        print(bestTimeToSellStock(array2))
        print(bestTimeToSellStockII(array3))
    }
}