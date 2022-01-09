package strings.easy

import Problem


/*
*
* */
class StrStr : Problem {
    private fun strStr(haystack: String, needle: String): Int {
        if(needle.length > haystack.length) return -1
        val len1 = haystack.length
        val len2 = needle.length
        var i = 0
        var j = 0
        var start = 0
        while (i < len1 && j < len2) {
            if (haystack[i++] == needle[j]) {
                j++
            } else {
                i -= j
                j = 0
                start = i
            }
        }
        return if (j == needle.length) start else -1
    }

    override fun solve() {
        println(strStr("mississippi", "issip"))
        println(strStr("abc", "c"))
        println(strStr("hello", "ll"))
        println(strStr("aaaa", "vva"))
        println(strStr("a", "a"))
    }
}