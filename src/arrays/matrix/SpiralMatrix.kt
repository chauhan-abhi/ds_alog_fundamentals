package arrays.matrix

import BaseProblem
import Problem


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

    override fun solve() {
        val res = generate(3)
        val res1 = generate(4)
        printMatrix(res)
        printMatrix(res1)
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