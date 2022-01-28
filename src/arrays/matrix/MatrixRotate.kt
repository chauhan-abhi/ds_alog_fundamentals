package arrays.matrix

import BaseProblem
import Problem


class MatrixRotate: BaseProblem(), Problem {

    private fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        if (m * n != r * c) return mat

        val result = Array(r) { IntArray(c) }
        var row = 0
        var col = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                result[row][col] = mat[i][j]
                col++
                if (col == c) {
                    col = 0
                    row++
                }
            }
        }

        return result
    }

    override fun solve() {
        val row1 = intArrayOf(1,2)
        val row2 = intArrayOf(3,4)
        val array = arrayOf(row1,row2)
        val res = matrixReshape(array, 1, 4)
        for(i in 0 until 1) {
            for (j in 0 until 4) {
                print(res[i][j])
            }
            println()
        }
    }
}