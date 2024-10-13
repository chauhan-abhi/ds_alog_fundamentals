package arrays.medium

import BackTracking
import BaseProblem
import Problem

/*
* https://www.geeksforgeeks.org/print-all-n-digit-strictly-increasing-numbers/
* */
class RatInMaze : Problem, BaseProblem(), BackTracking {

    data class Choice(val dName: Char, val dr: Int, val dc: Int)

    private fun ratInMaze(matrix: Array<IntArray>): MutableList<String> {

        val result = mutableListOf<String>()
        val path = StringBuilder()
        val N = matrix.size

        val choices = mutableListOf<Choice>().apply {
            add(Choice('U', -1, 0))
            add(Choice('D', 1, 0))
            add(Choice('L', 0, -1))
            add(Choice('R', 0, 1))
        }

        backtrack(0, 0, N, result, path, matrix, choices)
        return result
    }

    private fun backtrack(
        row: Int,
        col: Int,
        n: Int,
        result: MutableList<String>,
        path: StringBuilder,
        matrix: Array<IntArray>,
        choices: MutableList<Choice>
    ) {
        // Base condition
        if (isSolved(row, col, n)) {
            result.add(path.toString())
            return
        }

        // Iterate on choices
        for (choice in choices) {
            val newX = row + choice.dr
            val newY = col + choice.dc
            if (isValid(newX, newY, n, matrix)) {
                matrix[row][col] = 0
                path.append(choice.dName)

                backtrack(newX, newY, n, result, path, matrix, choices)
                matrix[row][col] = 1
                path.deleteCharAt(path.lastIndex)
            }
        }

    }

    private fun isSolved(
        row: Int,
        col: Int,
        n: Int
    ) = (row == n - 1 && col == n - 1)

    private fun isValid(
        row: Int,
        col: Int,
        n: Int,
        matrix: Array<IntArray>,
    ) = (row >= 0 && row < n && col >= 0 && col < n && matrix[row][col] == 1)


    override

    fun solve() {
        val row1 = intArrayOf(1, 0, 0, 0)
        val row2 = intArrayOf(1, 1, 0, 1)
        val row3 = intArrayOf(1, 1, 0, 0)
        val row4 = intArrayOf(0, 1, 1, 1)
        val array = arrayOf(row1, row2, row3, row4)
        println(ratInMaze(array))
    }
}