package arrays

import Problem

class ThreeSum: Problem {

    private fun threeSum(nums: IntArray) : List<List<Int>> {
        val res = arrayListOf<List<Int>>()
        if (nums.size < 3) return res

        nums.sort()
        var i = 0

        while (i < nums.size-2){
            // if positive number is encountered in sorted array no possible soln ahead
            if (nums[i] > 0) break

            var j = i+1
            var k = nums.size-1
            while (j< k) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum == 0) res.add(listOf(nums[i], nums[j], nums[k]))
                if (sum <= 0) while (nums[j] == nums[++j] && j < k) {} // skip same result
                if (sum >= 0) while (nums[k--] == nums[k] && j < k) {} // skip same result
            }
            while (nums[i] == nums[++i] && i< nums.size-2) {}
        }
        return res
    }

    override fun solve() {
        val array = intArrayOf(-1,0,1,2,-1,-4)
        val array2 = intArrayOf()

        val output = threeSum(array)
        for (x in output) print("$x  ,")
    }
}