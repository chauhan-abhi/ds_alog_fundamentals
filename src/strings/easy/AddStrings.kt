package strings.easy

import Problem
import java.lang.StringBuilder

/*

* https://leetcode.com/problems/add-strings/
*  */
class AddStrings : Problem {
    private fun addStrings(a: String, b: String): String {
        var i = a.length-1
        var j = b.length -1
        var carry = 0
        var res = ""
        while (i >= 0 ||  j >=0 || carry > 0) {
            carry += if (i >= 0) a[i]-'0' else 0
            carry += if (j >= 0) b[j]-'0' else 0

            res = (carry%10 + '0'.code).toChar() + res
            carry /= 10
            i--
            j--

        }
        return res
    }

    override fun solve() {
        println(addStrings("456", "77"))
        println(addStrings("0", "0"))

    }
}