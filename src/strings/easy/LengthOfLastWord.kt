package strings.easy

import Problem


/*
*
* */
class LengthOfLastWord : Problem {
    private fun lengthOfLastWord(s: String): Int {
        var len = 0

        val chArr = s.toCharArray()
        for (i in s.length-1 downTo 0) {
            if (chArr[i] != ' ') {
                len++
            } else {
                if (len > 0) return len
            }
        }
        return len
    }

    override fun solve() {
        println(lengthOfLastWord("moon  "))
        println(lengthOfLastWord("hello"))
        println(lengthOfLastWord("   fly me   to   the moon  "))

        println(lengthOfLastWord("hello world  "))
        println(lengthOfLastWord("  "))

    }
}