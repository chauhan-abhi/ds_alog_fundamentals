package strings.easy

import Problem
import java.lang.StringBuilder


/*


* https://leetcode.com/problems/add-binary/
*  */
class AddBinary : Problem {
    private fun addBinary(a: String, b: String): String {
        var i = a.length-1
        var j = b.length -1
        var carry = 0
        var res = ""
        while (i >= 0 ||  j >=0 || carry == 1) {
            carry += if (i >= 0) a[i]-'0' else 0
            carry += if (j >= 0) b[j]-'0' else 0

            res = (carry%2 + '0'.code).toChar() + res
            carry /= 2
            i--
            j--

        }
        return res
    }

    private fun convertToTitle(columnNumber: Int): String {
        var n  = columnNumber
        var res = ""
        while (n != 0) {
            res = ('A'.toInt() + (n-1)%26).toChar() + res
            n = (n-1)/26
        }
        return res
    }

    override fun solve() {
        println(addBinary("11", "1"))
        println(addBinary("1010", "1011"))
        println(convertToTitle(701))
        println(convertToTitle(1))
        println(convertToTitle(28))
    }
}