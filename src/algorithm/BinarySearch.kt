package algorithm

import Problem

class BinarySearch: BaseAlgoProblem(), Problem {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size-1
        while (start <= end) {
            val mid = ((start + end)/2)
            if (nums[mid] == target) return mid
            else if (nums[mid] > target) end = mid-1
            else start = mid+1
        }
        return -1
    }

    override fun solve() {
        val test1  = intArrayOf(-1,0,3,5,9,12)
        val test2  = intArrayOf(-1,0,3,5,9,12)
        println(search(test1, 9))
        println(search(test2, 2))
    }
}