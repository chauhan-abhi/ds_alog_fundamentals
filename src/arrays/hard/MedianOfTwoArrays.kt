package arrays.hard

import Problem

class MedianOfTwoArrays : Problem {

    private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        if (n>m) return findMedianSortedArrays(nums2, nums1)

        var start = 0
        var end = n
        val realMid = (n+m+1)/2

        while (start<=end) {
            val mid = (start + end)/2
            val leftASize = mid
            val leftBSize = realMid- mid

            val leftA = if (leftASize > 0) nums1[leftASize-1] else Int.MIN_VALUE
            val leftB = if (leftBSize > 0 ) nums2[leftBSize-1] else Int.MIN_VALUE
            val rightA = if (leftASize < n) nums1[leftASize] else Int.MAX_VALUE
            val rightB = if (leftBSize < m) nums2[leftBSize] else Int.MAX_VALUE

            // if partition correct
            if (leftA <= rightB && leftB <= rightA) {
                if ((m+n)%2==0) return (Math.max(leftA, leftB) + Math.min(rightA, rightB))/2.0
                return Math.max(leftA, leftB).toDouble()
            } else if (leftA > rightB) {
                end = mid - 1
            } else start = mid + 1

        }
        return 0.0


    }

    override fun solve() {
        println(findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4)))
        println(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
    }
}