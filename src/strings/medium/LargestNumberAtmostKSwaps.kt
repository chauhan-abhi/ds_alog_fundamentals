package strings.medium

import BackTracking
import Problem

class LargestNumberAtmostKSwaps : Problem, BackTracking {

    private fun largestInKSwap(s: String, k: Int): String {
        val input = s.toCharArray()
        val res = input.clone()
        helper(input, k, res, 0)
        return String(res)
    }

    private fun helper(s: CharArray, k: Int, res: CharArray, start: Int) {
        if (k == 0 || start == s.size - 1) {
            return
        }

        var maxChar = s[start]
        for (i in (start + 1) until s.size) {
            if (s[i] > maxChar) {
                maxChar = s[i]
            }
        }

        for (i in (start + 1) until s.size) {
            if (s[start] < s[i] && s[i] == maxChar) {
                swap(s, start, i)
                if (String(s) > String(res)) {
                    System.arraycopy(s, 0, res, 0, s.size)
                }
                helper(s, k - 1, res, start + 1)
                swap(s, start, i) // Backtrack to original state
            }
        }

        helper(s, k, res, start + 1)
    }

    private fun swap(input: CharArray, i: Int, j: Int) {
        val temp = input[i]
        input[i] = input[j]
        input[j] = temp
    }

    override fun solve() {
        println(largestInKSwap("5477", 2))
        println(largestInKSwap("5477", 1))
        println(largestInKSwap("765", 2))
        println(largestInKSwap("5486", 2))
    }
}