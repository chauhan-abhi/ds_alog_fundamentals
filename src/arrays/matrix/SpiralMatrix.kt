package arrays.matrix

import BaseProblem
import Problem

// https://leetcode.com/problems/spiral-matrix/
class SpiralMatrix: BaseProblem(), Problem {
    /*
    *1 2 3
     8 9 4
    *7 6 5
    * */

    private fun generate(numRows: Int): Array<IntArray> {
        val result = Array(numRows) { IntArray(numRows) }
        var count = 1

        var startRow = 0
        var startCol = 0
        var endRow = numRows-1
        var endCol = numRows-1

        while (startRow <= endRow && startCol <= endCol) {
            for (i in startCol..endCol) result[startRow][i] = count++
            startRow++
            for (i in startRow..endRow) result[i][endCol] = count++
            endCol--

            for (i in endCol downTo startCol) result[endRow][i] = count++
            endRow--
            for (i in endRow downTo startRow)  result[i][startCol] = count++
            startCol++
        }

        return result
    }

    private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = arrayListOf<Int>()
        val numRows = matrix.size
        val numCols = matrix[0].size

        var startRow = 0
        var startCol = 0
        var endRow = numRows-1
        var endCol = numCols-1

        while (startRow <= endRow && startCol <= endCol) {
            for (i in startCol..endCol) result.add(matrix[startRow][i])
            startRow++
            for (i in startRow..endRow) result.add(matrix[i][endCol])
            endCol--

            if (startRow<=endRow)
            for (i in endCol downTo startCol) result.add(matrix[endRow][i])
            endRow--
            if (startCol<=endCol)
            for (i in endRow downTo startRow)  result.add(matrix[i][startCol])
            startCol++
        }

        return result
    }

    override fun solve() {
        val res = generate(3)
        val res1 = generate(4)
        printMatrix(res)
        printMatrix(res1)

        val mat = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12))
        //printMatrix(mat)
        println(spiralOrder(mat))
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