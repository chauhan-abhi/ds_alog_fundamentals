package arrays

import Problem
import kotlin.math.max

class MaximumSubArray: Problem {

    private fun maxSubArray(nums: IntArray): Int {
        var sum = 0
        var maxSum = Int.MIN_VALUE
        for (x in nums) {
            sum += x
            maxSum = max(sum, maxSum)
            if (sum < 0) sum = 0

        }
        return maxSum

    }

    override fun solve() {
        val input = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
        print(maxSubArray(input))
    }
}