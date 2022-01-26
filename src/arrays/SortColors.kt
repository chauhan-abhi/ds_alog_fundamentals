package arrays

import Problem

class SortColors: Problem {

    private fun sortColors(nums: IntArray) {
        var i=0
        var j = 0
        var k = nums.size-1

        while (i <= k) {
            if (nums[i] == 0) {
                nums[i] = nums[j]
                nums[j] = 0
                j++
            }
            if (nums[i] == 2) {
                nums[i] = nums[k]
                nums[k] = 2
                i--
                k--
            }
            i++
        }
        println(nums.asList())
    }
    override fun solve() {
        sortColors(intArrayOf(2,0,2,1,1,0))
        sortColors(intArrayOf(2,0,1))
    }
}