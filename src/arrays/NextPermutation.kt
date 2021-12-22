package arrays

import Problem

/*
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
* If such an arrangement is not possible,
* it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
* The replacement must be in place and use only constant extra memory.
* Input: nums = [1,2,3]
* Output: [1,3,2]
* */
class NextPermutation: Problem {

    private fun nextPermutation(input: IntArray) {
        var pivot = input.size -2
        while (pivot >= 0 && input[pivot+1] <= input[pivot]) pivot--

        if (pivot >= 0) {
            var swapIdx = input.size-1
            while (input[swapIdx] <= input[pivot]) {
                swapIdx--
            }
            swap(input, pivot, swapIdx)
            reverse(input, pivot+1)
        }
    }

    private fun swap(input: IntArray, i: Int, j: Int) {
        val temp = input[i]
        input[i] = input[j]
        input[j] = temp

    }
    private fun reverse(input: IntArray, start: Int) {
        var i = start
        var end = input.size-1
        while(i < end) {
            swap(input, i, end)
            i++
            end--
        }
    }

    override fun solve() {
        val input = intArrayOf(1,5,8,4,7,6,5,3,1)
        nextPermutation(input)
        for (x in input)
            println("$x ")
    }
}