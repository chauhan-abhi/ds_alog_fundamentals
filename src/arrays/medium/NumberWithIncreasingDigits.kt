package arrays.medium

import BackTracking
import BaseProblem
import Problem

/*
* https://www.geeksforgeeks.org/print-all-n-digit-strictly-increasing-numbers/
* */
class NumberWithIncreasingDigits : Problem, BaseProblem(), BackTracking {

    private fun numberWithIncreasingDigits(N: Int): List<Int> {
        val result = ArrayList<Int>()
        val input = ArrayList<Int>()

        if (N == 1) {
            for (i in 0..9)
                result.add(i)
            return result
        }
        helper(input, N, result)
        return result
    }

    private fun helper(input: ArrayList<Int>, N: Int, result: ArrayList<Int>) {
        if (N == 0) {
            result.add(input.joinToString("").toInt())
            return
        }

        for (i in 1..9) {
            if (input.isEmpty() || input.last() < i) {
                input.add(i)
                helper(input, N - 1, result)
                input.remove(i)
            }
        }
    }

    override fun solve() {
        val res = numberWithIncreasingDigits(3)
        // val res = numberWithIncreasingDigits(1)
        for (x in res)
            println("$x, ")
    }
}