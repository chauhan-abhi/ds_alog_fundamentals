package arrays.medium

import Problem

/*
* https://leetcode.com/problems/search-in-rotated-sorted-array/
* */
class SearchInRotatedArray: Problem {

    private fun search(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size-1

        while (lo <= hi) {
            val mid = lo + (hi - lo)/2
            if (nums[mid] == target) return mid

            if (nums[mid]<nums[lo]) {
                // 6 7 0 1 2 3 4 5
                if (target < nums[mid] || target >= nums[lo])
                    hi = mid-1
                else lo = mid +1
            } else {
                // 2 3 4 5 6 7 0 1
                if (target > nums[mid] || target < nums[lo])
                    lo = mid + 1
                else hi = mid - 1
            }
        }
        return -1
    }

    override fun solve() {
        val input = intArrayOf(4,5,6,7,0,1,2)
        println(search(input, 3))
        println(search(input, 0))
    }
}