package algorithm.binarySearch

import Problem
import java.lang.Integer.max

// https://leetcode.com/problems/find-peak-element/description/
class PeakElement: Problem {

    private fun findPeakElement(nums: IntArray): Int {
        val L = nums.size
        var start = 0
        var end = nums.size - 1

        if(L==1) return nums[0]
        if (L==2) return max(nums[0], nums[1])

        while (start <= end) {
            val mid = start + (end - start)/2
            if (mid > 0 && mid  < L - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]) {
                    return mid
                }
                // move to element which has value greater than element at mid
                else if (nums[mid-1] > nums[mid]) {
                    end = mid -1
                } else {
                    start = mid + 1
                }
            } else if (mid == 0) {
                return if (nums[0] > nums[1])
                    0 else 1
            } else if (mid == L-1) {
                return if (nums[L-1] > nums[L-2])
                    L-1 else L-2
            }
        }
        return -1
    }

    override fun solve() {
        println(findPeakElement(intArrayOf(1,2,1,3,5,6,4)))
        println(findPeakElement(intArrayOf(1,2,3,1)))
        println(findPeakElement(intArrayOf(1,2,3)))
    }
}