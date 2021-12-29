package arrays

import BaseProblem
import Problem


class MatrixSearch: BaseProblem(), Problem {

    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        var start = 0
        var endRow = matrix.size - 1
        val endCol = matrix[0].size - 1

        while (start <= endRow) {
            val mid = start + (endRow-start)/2
            if (matrix[mid][0] <= target && matrix[mid][endCol] >= target)
                return searchRow(matrix, mid, target)
            if (matrix[mid][endCol] < target)
                start = mid+1
            if (matrix[mid][0] > target)
                endRow = mid-1
        }
        return false
    }

    private fun searchRow(matrix: Array<IntArray>, rowIdx: Int, target: Int): Boolean {
        var start = 0
        var end = matrix[rowIdx].size-1
        while(start <= end) {
            val mid = start + (end-start)/2
            if (matrix[rowIdx][mid] == target)
                return true
            else if (matrix[rowIdx][mid] < target)
                start = mid+1
            else end = mid - 1
        }
        return false
    }

    override fun solve() {
        val row1 = intArrayOf(1,2,3,4)
        val row2 = intArrayOf(6,7,8,9)
        val row3 = intArrayOf(0,11,16,20)
        val array = arrayOf(row1,row2, row3)
        println(searchMatrix(array,  7))
        println(searchMatrix(array,  5))

    }
}