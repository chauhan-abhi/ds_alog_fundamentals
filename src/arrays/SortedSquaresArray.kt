package arrays

import Problem
import kotlin.math.abs

/*
* Given an integer array nums sorted in non-decreasing order,
* return an array of the squares of each number sorted in non-decreasing order.
* Example 1:
*
* Input: nums = [-4,-1,0,3,10]
* Output: [0,1,9,16,100]
* Explanation: After squaring, the array becomes [16,1,0,9,100].
* After sorting, it becomes [0,1,9,16,100].
* Example 2:
*
* Input: nums = [-7,-3,2,3,11]
* Output: [4,9,9,49,121]

* */
class SortedSquaresArray: Problem {

    override fun solve() {
        val array1 = sortedSquaresWithSorting(intArrayOf(-4,-1,0,3,10))
        val array2 = sortedSquaresWithoutSorting(intArrayOf(-4,-1,0,3,10))
        array1.map { println(it) }
        array2.map { println(it) }
    }

    private fun sortedSquaresWithoutSorting(array: IntArray): IntArray {
        val length = array.size
        var left = 0
        var right = length - 1
        val result = IntArray(length)
        for (index in array.indices.reversed()) {
            if (abs(array[left]) > array[right]) {
                result[index] = array[left] * array[left]
                left++
            } else {
                result[index] = array[right] * array[right]
                right--
            }
        }
        return result
    }

    private fun sortedSquaresWithSorting(array: IntArray) = array.map { num: Int -> num*num }.sorted().toIntArray()

}