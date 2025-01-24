package strings.easy

import Problem
import java.lang.StringBuilder

class ValidPalindrome : Problem {

    private fun isPalindrome(s: String): Boolean {
        val sb = StringBuilder()
        for (ch in s) {
            if (ch.isLetter() || ch.isDigit()) {
                sb.append(ch.lowercase())
            }
        }
        val finalString = sb.toString()
        return finalString == finalString.reversed()

    }

    override fun solve() {
        println(isPalindrome("A man, a plan, a canal: Panama")) // amanaplanacanalpanama
        println(isPalindrome("race a car"))
        println(isPalindrome(" "))
    }
}