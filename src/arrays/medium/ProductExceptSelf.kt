package arrays.medium

import Problem

/*
* https://leetcode.com/problems/product-of-array-except-self/
* */
class ProductExceptSelf: Problem {

    private fun productExceptSelf(nums: IntArray): IntArray {

        val res = IntArray(nums.size)
        res[0] = 1

        for (i in 1 until nums.size) {
            res[i] = res[i-1] * nums[i-1]
        }

        var right = 1
        for (i in nums.size-1 downTo 0) {
            res[i] = res[i] * right
            right *= nums[i]
        }
        return res
    }

    override fun solve() {
        val input = intArrayOf(1,2,3,4)
        val res = productExceptSelf(input)
        for (x in res)
            print("$x ")
    }
}