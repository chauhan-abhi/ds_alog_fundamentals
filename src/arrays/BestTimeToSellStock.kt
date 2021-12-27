package arrays

import Problem
import kotlin.math.max

class BestTimeToSellStock: Problem {

    private fun maxProfit(prices: IntArray): Int {
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

    override fun solve() {
        val array = intArrayOf(7,1,5,3,6,4)
        val array2 = intArrayOf(3,2,6,5,0,3)
        print(maxProfit(array))
        print(maxProfit(array2))
    }
}