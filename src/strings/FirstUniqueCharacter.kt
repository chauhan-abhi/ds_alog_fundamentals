package strings

import Problem

class FirstUniqueCharacter: Problem {

    fun firstUniqueChar(s: String): Int {
        for (ch in s.toCharArray()) {
            if (s.indexOf(ch) == s.lastIndexOf(ch))
                return s.indexOf(ch)
        }
        return -1
    }

    override fun solve() {
        println(firstUniqueChar("leetcode"))
        println(firstUniqueChar("aabb"))
    }
}