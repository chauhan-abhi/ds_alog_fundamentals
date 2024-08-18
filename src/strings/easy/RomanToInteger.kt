package strings.easy

import Problem
import java.lang.StringBuilder


/*
* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.
    *
* */
class RomanToInteger: Problem {

    companion object {
        const val M = 1000
        const val D = 500
        const val C = 100
        const val L = 50
        const val X = 10
        const val V = 5
        const val I = 1
    }

    private fun romanToInt(s: String): Int {
        var i = 0
        var res = 0
        val charArray = s.toCharArray()
        while (i < charArray.size) {
            when(charArray[i]) {
                'I' -> {
                    val iv = if (i != charArray.size - 1) {
                         if (charArray[i + 1] == 'V') V - I
                        else if (charArray[i + 1] == 'X') X - I
                        else I
                    } else I
                    if (iv > I) i++
                    res += iv
                }
                'X' -> {
                    val iv = if (i != charArray.size - 1) {
                        if (charArray[i+1] == 'L') L - X
                        else if (charArray[i+1] == 'C') C - X
                        else X
                    } else X
                    if (iv > X) i++
                    res += iv
                }
                'C' -> {
                    val iv = if (i != charArray.size - 1) {
                        if (charArray[i+1] == 'D') D - C
                        else if (charArray[i+1] == 'M') M - C
                        else C
                    } else C
                    if (iv > C) i++
                    res += iv
                }
                'V' -> res+= V
                'L' -> res+= L
                'D' -> res+= D
                'M' -> res+= M
            }
            i++
        }
        return res
    }

    //https://leetcode.com/problems/roman-to-integer/
    private fun cleanRomanToInt(s: String?): Int {
        if (s.isNullOrEmpty()) return -1
        val map = getRomanMap()
        val len = s.length
        var result =  map.getOrDefault(s[len-1], 0)
        for (i in len - 2 downTo 0) {
            if (map.getOrDefault(s[i], 0) >= map.getOrDefault(s[i+1], 0))
                result += map.getOrDefault(s[i], 0)
            else result -= map.getOrDefault(s[i], 0)
        }
        return result
    }

    private fun intToRoman(num: Int): String {
        val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romanLiterals = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var temp = num
        val sb = StringBuilder()
        for (i in values.indices) {
            if (temp >= values[i]) {
                sb.append(romanLiterals[i])
                temp -= values[i]
            }
        }
        return sb.toString()

    }

    private fun getRomanMap(): HashMap<Char, Int> {
        val map = HashMap<Char, Int>()
        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000
        return map
    }

    override fun solve() {
        println(romanToInt("LVIII"))
        println(romanToInt("III"))
        println(romanToInt("MCMXCIV"))
        val roman = cleanRomanToInt("MCMXCIV")
        println(intToRoman(roman))
    }


}