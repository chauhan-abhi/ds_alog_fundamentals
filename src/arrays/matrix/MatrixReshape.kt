package arrays.matrix

import BaseProblem
import Problem


class MatrixReshape: BaseProblem(), Problem {

    private fun rotate(matrix: Array<IntArray>): Unit {
        transpose(matrix)
        replace(matrix)
    }

    private fun transpose(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in i+1 until matrix[0].size) {
                val temp = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = temp
            }
        }

    }

    private fun replace(matrix: Array<IntArray>) {
        val n = matrix.size
        for (i in matrix.indices) {
            for (j in 0 until n/2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n-j-1]
                matrix[i][n-j-1] = temp
            }
        }
    }

    override fun solve() {
        val row1 = intArrayOf(1,2,3)
        val row2 = intArrayOf(4,5,6)
        val row3 = intArrayOf(7,8,9)
        val array = arrayOf(row1,row2, row3)
        printMatrix(array)
        rotate(array)
        printMatrix(array)
    }

    private fun printMatrix(array: Array<IntArray>) {
        for(i in array.indices) {
            for (j in 0 until array[0].size) {
                print("${array[i][j]} ")
            }
            println()
        }
    }
}