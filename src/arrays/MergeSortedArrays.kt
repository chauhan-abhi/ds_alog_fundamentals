package arrays

import Problem

class MergeSortedArrays: Problem {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m-1
        var j = n-1
        var k = m + n -1
        while (i>=0 && j>=0) {
            nums1[k--] = if (nums2[j] > nums1[i]) nums2[j--] else nums1[i--]
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--]
        }
    }


    override fun solve() {
        val nums1 = intArrayOf(1,2,3,0,0,0)
        val nums2 = intArrayOf(2,5,6)
        val nums3 = intArrayOf(4,5,6,0,0,0)
        val nums4 = intArrayOf(1,2,3)
        merge(nums1, 3, nums2, 3)
        merge(nums3, 3, nums4, 3)
        for (x in nums1) print("$x ")
        println()
        for (x in nums3) print("$x ")
    }
}