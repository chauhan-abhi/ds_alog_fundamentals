package arrays.hard

import Problem
import kotlin.math.abs

// https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
class MinSubsetDifference: Problem {

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


    override fun solve() {
        val input1 = intArrayOf(1, 6, 11, 5)
        val input2 = intArrayOf( 3, 1, 4, 2, 2, 1 )
        println(minimumDifference(input1))
        println(minimumDifference(input2))

    }
}