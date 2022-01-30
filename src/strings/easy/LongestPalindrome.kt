package strings.easy

import Problem


/*
* https://leetcode.com/problems/longest-palindrome/
* */
class LongestPalindrome : Problem {
    private fun longestPalindrome(s: String): Int {

        if (s.isEmpty()) return 0
        val hs = HashSet<Char>()
        var count = 0
        for (i in s.indices) {
            if (hs.contains(s[i])) {
                hs.remove(s[i])
                count++
            } else {
                hs.add(s[i])
            }
        }
        return if (hs.isNotEmpty()) count * 2 + 1 else count * 2
    }

    override fun solve() {
        println(longestPalindrome("abccccdd"))
        println(longestPalindrome("a"))
        println(longestPalindrome("bb"))

    }
}