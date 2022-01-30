package arrays

import Problem


class IncreasingTriplet: Problem {

    private fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false
        val smaller = IntArray(nums.size)
        val greater = IntArray(nums.size)
        smaller[0] = -1
        var min = 0


        for (i in 1 until nums.size) {
            if (nums[i] <= nums[min]) {
                min = i
                smaller[i] = -1
            } else {
                smaller[i] = i
            }

        }
        greater[nums.size-1] = -1
        var max = nums.size-1

        for (i in nums.size-2 downTo 0) {
            if (nums[i] >= nums[max]) {
                max = i
                greater[i] = -1
            } else {
                greater[i] = i
            }

        }

        for (i in nums.indices) {
            if (smaller[i] != -1 && greater[i] != -1) return true
        }
        return false
    }

    private fun increasingTripletWithoutSpace(nums: IntArray): Boolean {
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE

        for (n in nums) {
            if (n <= first) {
                first = n
            } else if (n <= second) {
                second = n
            } else {
                return true
            }
        }
        return false
    }

    override fun solve() {
        val array = intArrayOf(2,1,5,0,4,6)
        //val array2 = intArrayOf(1,2,3,4,5)
        val array2 = intArrayOf(5,4,3,2,1)
        val array3 = intArrayOf(20,100,10,12,5,13)

        //println(increasingTriplet(array))
        println(increasingTriplet(array2))
        println(increasingTriplet(array3))
        println(increasingTripletWithoutSpace(array3))
    }
}