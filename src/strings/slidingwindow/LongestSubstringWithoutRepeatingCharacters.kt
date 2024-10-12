package strings.slidingwindow

import Problem
import SlidingWindow
import kotlin.math.max

// Sliding Window
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class LongestSubstringWithoutRepeatingCharacters : Problem, SlidingWindow {

    private fun lengthOfLongestSubstring(s: String): Int {
        val sl = s.length
        val hm = HashMap<Char, Int>()
        var i = 0
        var j = 0

        var result = 0
        while (j < sl) {
            hm[s[j]] = hm.getOrDefault(s[j], 0) + 1

            // window size reached without any repeating character
            if (hm.size == j - i + 1) {
                //
                result = max(result, j - i + 1)
                j++
            } else if (hm.size < j - i + 1) {
                // size of hm will be less if there is repeating char like
                // pww   hm.size = 2 < 3
                while (hm.size < j - i + 1) {
                    hm[s[i]] = hm.getOrDefault(s[i], 0) - 1
                    if (hm[s[i]] == 0) {
                        hm.remove(s[i])
                    }
                    i++
                }
                j++
            }
        }
        return result

    }


    override fun solve() {
        println(lengthOfLongestSubstring("abcabcbb"))
        println(lengthOfLongestSubstring("bbbbb"))
        println(lengthOfLongestSubstring("pwwkew"))
    }
}