package arrays

import BaseProblem
import Problem

class RemoveDuplicatesInPlace: BaseProblem(), Problem {

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

    override fun solve() {
        val array1 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val array2 = intArrayOf(0,1,2,3,4,5)
        println(removeDuplicates(array1))
        println(removeDuplicates(array2))
    }
}