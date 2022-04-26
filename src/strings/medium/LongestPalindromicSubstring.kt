package strings.medium

import Problem
import java.lang.StringBuilder

/*
* https://leetcode.com/problems/longest-palindromic-substring/
*  */
class LongestPalindromicSubstring : Problem {

    private fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var start = 0
        var end = 0

        for (i in s.indices) {
            val l1 = expand(s, i, i)
            val l2 = expand(s, i, i+1)
            val maxL = Math.max(l1, l2)
            if (maxL > end-start) {
                start = i - ((maxL-1)/2)
                end = i + (maxL/2)
            }
        }
        return s.substring(start, end + 1)

    }

    private fun longestSubsequenceWithoutRepetition(s: String): Int {
        val map = HashMap<Char, Int>()
        var start = 0
        var maxL = 0
        for (end in s.indices) {
            if (map.containsKey(s[end])) {
                start = start.coerceAtLeast(map[s[end]]!! + 1)
            }
            map[s[end]] = end
            maxL = maxL.coerceAtLeast(end - start + 1)
        }
        return maxL
    }

    private fun expand(s: String, left: Int, right: Int): Int {
        var start = left
        var end = right
        if (start > end) return 0

        while (start >= 0 && end < s.length && s[start] == s[end] ) {
            start--
            end++
        }
        return end - start - 1
    }

    override fun solve() {
        println(longestPalindrome("babad"))
        println(longestPalindrome("cbbd"))
        println(longestSubsequenceWithoutRepetition("abcabcbb"))

    }
}