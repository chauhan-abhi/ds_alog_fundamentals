package arrays.medium

import Problem

/*
* https://leetcode.com/problems/subarray-sum-equals-k/
* if the cumulative sum up to two indices,
* say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k,
* the sum of elements lying between indices ii and jj is kk.
* */
class SubArraySumK: Problem {

    private fun subArraySum(nums: IntArray, k: Int): Int {

        val map = hashMapOf<Int, Int>()
        var count = 0
        var sum = 0
        map[0] = 1
        for (i in nums.indices) {
            sum += nums[i]
            count += map.getOrDefault(sum-k, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count

    }

    // https://leetcode.com/problems/subarray-sums-divisible-by-k/
    private fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val map = hashMapOf<Int, Int>()
        map[0] = 1
        var count = 0
        var sum = 0
        for (x in nums) {
            sum = (sum + x) % k
            if (sum < 0 ) sum += k
            count += map.getOrDefault(sum, 0)
            map[sum] = map.getOrDefault(sum, 0) + 1

        }
        return count
    }



    override fun solve() {
        val input = intArrayOf(1,2,3)
        val input2 = intArrayOf(1,1,1)
        val input3 = intArrayOf(3,4,7,2,-3,1,4,2)
        println(subArraySum(input, 3))
        println(subArraySum(input2, 2))
        println(subArraySum(input3, 7))
        println(subarraysDivByK(input3, 2))
    }
}