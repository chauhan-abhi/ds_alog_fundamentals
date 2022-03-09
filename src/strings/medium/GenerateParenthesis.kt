package strings.medium

import Problem
import java.lang.StringBuilder

/*
* https://leetcode.com/problems/generate-parentheses/
*  */
class GenerateParenthesis : Problem {

    private fun generateParenthesis(n: Int): List<String> {
        val result = arrayListOf<String>()
        dfs(n, result, "", 0, 0)
        return result
    }

    private fun dfs(n: Int, list: ArrayList<String>, s: String,  open: Int, close: Int) {
        if (s.length == 2*n) {
            list.add(s)
            return
        }
        if (open < n) dfs(n, list, "$s(", open+1, close)
        if (close < open) dfs(n, list, "$s)", open, close+1)


    }

    override fun solve() {
        println(generateParenthesis(3))
        println(generateParenthesis(4))

    }
}