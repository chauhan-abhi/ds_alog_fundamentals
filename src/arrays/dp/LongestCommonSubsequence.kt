package arrays.dp

import Problem

class LongestCommonSubsequence: Problem {

    private fun computeLcs(x: String, y: String, m: Int, n: Int): Array<IntArray> {
        val dp = Array(m+1) { IntArray(n+1) }

        for (i in 0 until m+1) {
            for (j in 0 until n+1) {
                when {
                    (i == 0 || j == 0) -> dp[i][j] = 0
                    x[i-1] == y[j-1] -> dp[i][j] = dp[i-1][j-1] + 1
                    else ->  dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j])
                }
            }
        }
        return dp
    }

    private fun printLcs(x: String, y: String, m: Int, n: Int): String {
        val dp = computeLcs(x, y, m , n)
        // length of lcs
        // dp[m][n]
        var ii = m
        var jj = n
        var res = ""
        while (ii > 0 && jj > 0) {
            when {
                x[ii - 1] == y[jj - 1] -> {
                    res = x[ii - 1] + res
                    ii--
                    jj--
                }
                dp[ii-1][jj] > dp[ii][jj-1] -> ii--
                else -> jj--
            }
        }
        return res
    }

    /*private fun smallestSuperSequence(x: String, y: String, m: Int, n: Int): String {
        val dp = computeLcs(x,y,m, n)
        //println(m+n-dp[m][n])
        var ii = m
        var jj = n
        var res = ""
        while (ii > 0 && jj > 0) {
            if (x[ii - 1] == y[jj - 1]) {
                res = x[ii - 1] + res
                ii--
                jj--
            }
            when {
                // only one string reaches left end.
                ((ii <= 0)xor(jj <= 0)) -> {
                    res = if (ii <= 0 ) y[jj--] + res else x[ii--] + res
                }
                // common char in LCS
                x[ii - 1] == y[jj - 1] -> {
                    // append the char of either s1 or s2.
                    res = x[ii - 1] + res
                    ii--
                    jj--
                }
                // char is not in LCS
                else -> {
                   val ch = if (dp[ii-1][jj] > dp[ii][jj-1]) x[ii--] else y[jj--]
                    res = ch + res
                }
            }
        }

        return res
    }
*/

    override fun solve() {
        println(printLcs("abcdgf", "abedfhr", 6, 7))
        //println(smallestSuperSequence("AGGTAB", "GXTXAYB", 6, 7))
        //println(smallestSuperSequence("abac", "cab", 4, 3))

    }
}