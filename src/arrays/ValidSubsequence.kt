package arrays

import Problem

class ValidSubsequence: Problem {

    private fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        val size = sequence.size
        var idx = 0
        for (element in array) {
            if (idx == size) return true
            if (element == sequence[idx]) idx++
        }
        return idx == size
    }

    override fun solve() {
        val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
        val sequence = listOf(1, 6, -1, 10)
        print(isValidSubsequence(array, sequence))
    }
}