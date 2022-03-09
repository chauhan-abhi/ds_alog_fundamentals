package arrays.hard

import Problem

// https://leetcode.com/problems/first-missing-positive/
class FirstMissingNumber : Problem {

    private fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for(i in 0 until n) {
            while(nums[i] in 1..n && nums[i] != nums[nums[i]-1]) {
                val temp = nums[nums[i]-1]
                nums[nums[i]-1] = nums[i]
                nums[i] = temp
            }


        }
        for(i in 0 until n) {
            if (nums[i] != i+1) return i+1
        }
        return n+1

    }

    override fun solve() {
        println(firstMissingPositive(intArrayOf(1,2,0)))
        println(firstMissingPositive(intArrayOf(3,4,-1,1)))
        println(firstMissingPositive(intArrayOf(7,8,9,11,12)))
    }
}