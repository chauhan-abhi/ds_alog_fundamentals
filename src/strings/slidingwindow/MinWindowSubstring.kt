package strings.slidingwindow

import Problem
import SlidingWindow

// Sliding Window
// https://leetcode.com/problems/minimum-window-substring/description/
class MinWindowSubstring : Problem, SlidingWindow {

    private fun minWindow(s: String, t: String): String {
        val sl = s.length
        val pl = t.length

        val hm = HashMap<Char, Int>()

        for (x in t.toCharArray())
            hm[x] = hm.getOrDefault(x, 0) + 1

        val arr = s.toCharArray()
        var i = 0
        var j = 0

        var count = hm.size
        var start = 0
        var answerLength = Int.MAX_VALUE


        while (j < sl) {

            if (hm.containsKey(arr[j])) {
                hm[arr[j]] = hm[arr[j]]!! - 1
                if (hm[arr[j]] == 0) {
                    count--
                }
            }
            // hm would have entries in negative for those characters that are present in this substring more
            // times that required. for eg

            if (count == 0) {
                // possible answer  = (i, j) but it may contain repeating tokens
                // but lets find if there is a smaller answer
                // T O T M T A P T A T          TTA
                // T O T M T A is the substring with T:3 A: 1
                // so hm will be T: -1 A: 0 at this point signifying we have 1 extra T
                // optimised answer is (T M T A)
                while (count <= 0) {
                    if (answerLength > j - i + 1) {
                        answerLength = j - i + 1
                        start = i
                    }

                    if (hm.containsKey(arr[i])) {
                        hm[arr[i]] = hm[arr[i]]!! + 1

                        if (hm[arr[i]] == 1) {
                            count++ // so count  = 0 was giving us answer
                            // hence this index of i is no longer the answer
                        }
                    } else {
                        // if the element at i is not present in hm then its of no use in min substring
                        // remove it ie slide it off i++
                    }
                    i++
                }
                // we just
            }
            j++
        }
        if (answerLength == Int.MAX_VALUE) return ""
        return s.substring(start, start + answerLength)

    }

    override fun solve() {
        println(minWindow("ADOBECODEBANC", "ABC"))
        println(minWindow("a", "aa"))
        println(minWindow("a", "a"))
    }
}