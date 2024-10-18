package arrays.medium

import BackTracking
import BaseProblem
import Problem
import java.lang.StringBuilder

/*
* https://leetcode.com/problems/palindrome-partitioning/
* */
class PalindromicPartition : Problem, BaseProblem(), BackTracking {

    private fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val temp = mutableListOf<String>()
        backtrack(s, temp, result, 0)
        return result
    }

    private fun isPalindrome(s: String, low: Int, high: Int): Boolean {
        var start = low
        var end = high
        while (start < end) {
            if (s[start] != s[end]) return false
            start++
            end--
        }
        return true
    }

    private fun backtrack(s: String, temp: MutableList<String>, result: MutableList<List<String>>, start: Int) {
        if (s.length == start) {
            result.add(ArrayList(temp))
            return
        }
        for (i in start until s.length) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1))
                backtrack(s, temp, result, i + 1)
                temp.removeLast()
            }
        }
    }


    override fun solve() {
        val res = partition("aabab")
        for (item in res) {
            println(item)
        }
    }
}