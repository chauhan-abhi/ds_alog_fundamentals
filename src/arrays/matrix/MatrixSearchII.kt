package arrays.matrix

import BaseProblem
import Problem

class MatrixSearchII: BaseProblem(), Problem {

    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false

        val n: Int = matrix.size
        val m: Int = matrix[0].size
        var i = 0
        var j = m - 1

        while (i < n && j >= 0) {
            val num = matrix[i][j]
            if (num == target) return true else if (num > target) j-- else i++
        }

        return false
    }

    override fun solve() {
        val row1 = intArrayOf(1,2,3,4)
        val row2 = intArrayOf(6,7,8,9)
        val row3 = intArrayOf(10,11,16,20)
        val array = arrayOf(row1,row2, row3)
        println(searchMatrix(array,  7))
        println(searchMatrix(array,  5))

    }
}