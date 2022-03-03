package arrays.medium

import Problem

/*
* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* */
class RangeSearchArray: Problem {

    private fun rangeSearchII(nums: IntArray, target: Int): IntArray {
        val res= intArrayOf(-1,-1)
        res[0] = binarySearchFirst(nums, target)
        res[1] = binarySearchSecond(nums, target)
        println("${res[0]} - ${res[1]}")

        return res
    }

    private fun binarySearchFirst(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size-1
        var idx = -1
        while (lo <= hi) {
            val mid = lo + (hi - lo)/2
            if (nums[mid] >= target) {
                hi = mid - 1
            } else {
                lo = mid+1
            }
            if (nums[mid] == target) idx = mid
        }
        return idx
    }

    private fun binarySearchSecond(nums: IntArray, target: Int): Int {
        var lo = 0
        var hi = nums.size-1
        var idx = -1
        while (lo <= hi) {
            val mid = lo + (hi - lo)/2
             if (nums[mid] <= target) {
                 lo = mid+1
            } else {
                hi = mid - 1
            }
            if (nums[mid] == target) idx = mid
        }
        return idx
    }

    private fun rangeSearch(nums: IntArray, target: Int): IntArray {
        var lo = 0
        var hi = nums.size-1
        val res= intArrayOf(-1,-1)
        if (nums.isEmpty()) return res
        while (nums[lo] < nums[hi]) {
            val mid = lo + (hi - lo)/2
            if (nums[mid] < target) {
                lo = mid + 1
            } else if (nums[mid] > target) {
                hi = mid - 1
            } else {
                if (nums[lo] == nums[mid])
                    hi--
                else lo++
            }
        }
        if (nums[lo] == nums[hi] && nums[lo] == target) {
            res[0] = lo
            res[1] = hi
        }
        return res
    }

    override fun solve() {
        val input = intArrayOf(5,7,7,8,8,10)
        println(rangeSearch(input, 8))
        println(rangeSearchII(input, 8))
        println(rangeSearch(intArrayOf(), 8))

    }
}