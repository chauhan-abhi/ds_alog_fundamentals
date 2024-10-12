package strings.slidingwindow

import Problem
import SlidingWindow

// Sliding Window
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class FindAnagram : Problem, SlidingWindow {

    private fun findAnagrams(s: String, p: String): List<Int> {
        val sl = s.length
        val pl = p.length
        val anagrams = mutableListOf<Int>()

        if (sl <= 0 || pl <= 0) return anagrams
        val hm = HashMap<Char, Int>()

        for (x in p.toCharArray())
            hm[x] = hm.getOrDefault(x, 0) + 1

        val arr = s.toCharArray()

        var i = 0
        var j = 0

        var count = hm.size
        while (j < sl) {

            // decrement the count of character present at j in map
            // if count tends to 0 then make count --
            if(hm.containsKey(arr[j])) {
                hm[arr[j]] = hm[arr[j]]!! - 1
                if (hm[arr[j]] == 0) {
                    count --
                }
            }
            if( j - i + 1 == pl) {
                if (count == 0) {  /// means hashmap entries are all 0
                    // calculate answer
                    anagrams.add(i)
                }
                // slide the window
                // now i is not part of sliding window so remove this calculation
                // undo that calculation done above on line #41

                if (hm.containsKey(arr[i])) {
                    if (hm[arr[i]] == 0) {
                        count++
                    }
                    hm[arr[i]] = hm[arr[i]]!! + 1
                }
                i++

            }
            j++
        }
        return anagrams
    }

    override fun solve() {
        println(findAnagrams("cbaebabacd", "abc"))
        println(findAnagrams("cbaebabacd", "abc"))
    }
}