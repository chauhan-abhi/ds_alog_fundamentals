package strings.easy

import Problem


/*
* https://leetcode.com/problems/word-pattern/
* */
class WordPattern : Problem {

    private  fun wordPattern(pattern: String, s: String): Boolean {
        val arr = s.split(" ")
        if (pattern.length != arr.size) return false

        val hm = hashMapOf<Char, String>()

        for (i in arr.indices) {
            val ch = pattern[i]
            if (hm.containsKey(ch)) {
                if (hm[ch] != arr[i])
                return false
            }
            else {
                if (hm.containsValue(arr[i])) return false
                hm[ch] = arr[i]
            }
        }
        return true

    }

    override fun solve() {
        println(wordPattern("abba", "dog cat cat dog"))
        println(wordPattern("abba", "dog cat cat fish"))
        println(wordPattern("aaaa", "dog cat cat dog"))
        println(wordPattern("abba", "dog dog dog dog"))


    }
}