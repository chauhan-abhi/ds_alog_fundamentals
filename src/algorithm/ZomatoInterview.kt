package algorithm

import Problem

class ZomatoInterview: Problem {

//aabbbccccda
    //a$2b$3c$4d$1a$1

    fun encoding(input: String): String {

        var result = ""
        val len = input.length-1
        val freqMap = hashMapOf<Char, Int>()
        for (i in 0 until len) {
            freqMap[input[i]] = freqMap.getOrDefault(input[i], 0) +1
            if (input[i] != input[i+1]) {

                result += "${input[i]}$${freqMap.getOrDefault(input[i], 1)}"
                freqMap[input[i]] = 0
                if (i == len-2) {
                    result+= "${input[i+1]}$1"
                }
             }
        }
        return result

    }
    // https://leetcode.com/problems/subarray-product-less-than-k/solution/
    private fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0
        var prod = 1
        var left = 0
        var count = 0

        for (right in nums.indices) {
            prod *= nums[right]
            while (prod >= k) {
                prod /= nums[left++]
            }
            count += (right-left+1)
        }
        return count
    }

    override fun solve() {
        //println(encoding("aabbbccccda"))
        println(numSubarrayProductLessThanK(intArrayOf(10,5,2,6), 100))
        println(numSubarrayProductLessThanK(intArrayOf(1,2,3), 0))
    }
}