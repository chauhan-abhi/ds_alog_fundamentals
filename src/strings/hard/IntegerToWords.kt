package strings.hard

import Problem

class IntegerToWords: Problem {

    private val BELOW_20 = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    private val BELOW_100 = arrayOf("", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    private val THOUSAND = arrayOf("",  "Thousand", "Million", "Billion")

    private fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"
        return helper(num)
    }

    private fun helper(num: Int): String {
        return when {
        num < 20 -> BELOW_20[num]
        num < 100 -> BELOW_100[num/10] + " " + helper(num%10)
        num < 1_000 -> helper(num/100) + " Hundred " + helper(num%100)
        num < 1_000_000 -> helper(num/1_000) + " ${THOUSAND[1]} " + helper(num%1_000)
        num < 1000_000_000 -> helper(num/1_000_000) + " ${THOUSAND[2]} " + helper(num%1_000_000)
        else -> helper(num/1000_000_000) + " ${THOUSAND[3]} " + helper(num%1000_000_000)
        }.trim()
    }

    override fun solve() {
        println(numberToWords(123))
        println(numberToWords(12345))
        println(numberToWords(1234567))
    }
}