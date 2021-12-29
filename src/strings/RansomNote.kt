package strings

import Problem

class RansomNote: Problem {

    private fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val hm = HashMap<Char, Int>()
        for (x in magazine.toCharArray())
            hm[x] = hm.getOrDefault(x, 0) + 1

        for (x in ransomNote.toCharArray()) {
            if (hm.getOrDefault(x, 0) == 0)
                return false
            hm[x] = hm.getOrDefault(x, 0) - 1
        }
        return true
    }

    override fun solve() {
        println(canConstruct("a", "b"))
        println(canConstruct("ab", "ba"))
        println(canConstruct("aa", "aab"))
    }
}