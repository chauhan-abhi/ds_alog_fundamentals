package arrays

import BaseProblem
import Problem

class RemoveDuplicatesInPlace: BaseProblem(), Problem {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array
    private fun removeDuplicates(nums: IntArray): Int {
        var start = 0
        val end = nums.size-1
        var i = 0

        while (i < end) {
            if (nums[i] != nums[i+1]) {
                nums[++start] = nums[i+1]
            }
            i++
        }
        return start+1
    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
    private fun removeDuplicatesAtMostKOccurrences(nums: IntArray): Int {
        val k = 2
        if (nums.isEmpty()) return 0

        var start = 1
        val end  = nums.size
        var count = 1

        for (i in 1 until end) {
            if (nums[i] == nums[i-1]) {
                if (count < k) {
                    nums[start++] = nums[i]
                }
                count++
            } else {
                count = 1
                nums[start++] = nums[i]
            }
        }
        nums.forEach { println(it) }
        return start
    }



    override fun solve() {
        val array1 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val array2 = intArrayOf(0,1,2,3,4,5)
        //println(removeDuplicates(array1))
        //println(removeDuplicates(array2))
        println(removeDuplicatesAtMostKOccurrences(array1))
    }
}