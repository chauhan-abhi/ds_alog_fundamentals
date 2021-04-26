package arrays

import Problem

/*
* Given an array of positive integers (representing coins),
* find the smallest value that cannot be constructed from those integers.
*
* Input: A = [1, 2, 4]
* Output: 8
* Explanation: With subsets of A, we can construct values 1, 2, 3, 4, 5, 6, 7.
*
* Input: A = [1, 2, 5]
* Output: 4
* Explanation: With subsets of A, we can construct values 1, 2, 3, 5, 6, 7, 8.
*/
class NonConstructibleChange: Problem {
    override fun solve() {
        computeProblem(intArrayOf(1,2,5))
    }

    private fun computeProblem(array: IntArray) {
        var maxNonConstructible = 0
        for (num in array.sorted()) {
            if (num > maxNonConstructible+1) break
            maxNonConstructible += num
        }
        print (maxNonConstructible+1)
    }


}