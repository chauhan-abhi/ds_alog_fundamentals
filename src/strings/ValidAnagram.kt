package strings

import Problem

class ValidAnagram: Problem {

    private fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val hm = HashMap<Char, Int>()
        for (x in s.toCharArray())
            hm[x] = hm.getOrDefault(x, 0) + 1

        for (x in t.toCharArray()) {
            hm[x] = hm.getOrDefault(x, 0) - 1
        }
        return hm.filter {
            it.value != 0
        }.isEmpty()

    }

    override fun solve() {
        println(isAnagram("anagram", "nagaram"))
        println(isAnagram("rat", "car"))
    }
}