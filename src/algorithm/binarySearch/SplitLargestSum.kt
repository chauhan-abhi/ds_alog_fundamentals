package algorithm.binarySearch

import Problem

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-k/
class SplitLargestSum : Problem {
    override fun solve() {
        println(splitArray(intArrayOf(7,2,5,10,8), 2))
        println(splitArray(intArrayOf(1,2,3,4,5), 2))
    }

    private fun splitArray(nums: IntArray, k: Int): Int {
        var start = Int.MIN_VALUE
        var end = 0
        for (weight in nums) {
            end += weight
            start = Math.max(weight, start)
        }

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (possible(nums, mid, k)) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return start
    }

    private fun possible(nums: IntArray, capacity: Int, k: Int): Boolean {
        var subArraySplit = 1
        var sum = 0
        for (i in nums) {
            sum += i
            if (sum > capacity) {
                subArraySplit++
                sum = i
            }
        }
        return subArraySplit <= k
    }
}