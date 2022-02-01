package strings.medium

import Problem
import java.lang.StringBuilder

/*

* https://leetcode.com/problems/multiply-strings/
*  */
class MultiplyStrings : Problem {

    private fun multiply(num1: String, num2: String): String {
        val m = num1.length
        val n = num2.length

        if (m == 0 || n== 0 || "0" == num1 || "0" == num2) return "0"
        if ("1" == num1) return num2
        if ("1" == num2) return num1

        val res = IntArray(m+n)

        for (i in m-1 downTo 0) {
            for (j in n-1 downTo 0) {
                var prod = (num1[i] - '0')*(num2[j] - '0')
                prod += res[i+j+1]

                res[i+j+1] = prod%10
                res[i+j] = prod/10
            }
        }

        val sb = StringBuilder()
        for (digit in res) {
            if (sb.isEmpty() && digit == 0) continue
            sb.append(digit)
        }
        return sb.toString()
    }


    override fun solve() {
        println(multiply("456", "77"))
        println(multiply("0", "0"))

    }

    /*
    *
    *            1  2  3             (num1)
         X       4  5  6             (num2)
	   ==================
		            1  8             (3*6)
		         1  2                (2*6)
		      0  6                   (1*6)
	   ------------------
		         1  5                (3*5)
		      1  0                   (2*5)
		   0  5                      (1*5)
	   ------------------
		      1  2                   (3*4)
		   0  8                      (2*4)
		0  4                         (1*4)
	   ==================
		0  5  6  0  8  8             (Result)
	   ==================
	   * */
}