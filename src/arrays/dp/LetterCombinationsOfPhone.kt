package arrays.dp

import Problem

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class LetterCombinationsOfPhone: Problem {

    private fun letterCombinations(digits: String): List<String> {
        val mappingList = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        if (digits.isEmpty()) return emptyList()
        val res = arrayListOf<String>()
        backtrack(res,  digits.toCharArray(), "", mappingList)
        return res
    }

    private fun backtrack(combos: ArrayList<String>, digits: CharArray, s: String, dict: Array<String>) {
        if (s.length == digits.size) {
            combos.add(s)
            return
        }
        val i = s.length
        val digit = digits[i] - '0'
        for (letter in dict[digit].toCharArray()) {
            backtrack(combos, digits, s + letter.toString(), dict)
        }
    }


    override fun solve() {
        println(letterCombinations("235"))
        println(letterCombinations(""))
    }
}