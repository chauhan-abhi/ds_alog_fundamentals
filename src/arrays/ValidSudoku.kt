package arrays

import Problem

class ValidSudoku: Problem {

    private  fun isValidSudoku(board: Array<CharArray>): Boolean {

        for (i in 0 until 9) {
            val rowMap = hashSetOf<Char>()
            val colMap = hashSetOf<Char>()
            val diceMap = hashSetOf<Char>()
            for (j in 0 until 9) {
                if (board[i][j] != '.' && !rowMap.add(board[i][j])) return false
                if (board[j][i] != '.' && !colMap.add(board[j][i])) return false

                val rowIdx = 3*(i/3)
                val colIdx = 3*(i%3)

                if (board[rowIdx + j/3][colIdx + j%3] != '.' && !diceMap.add(board[rowIdx + j/3][colIdx + j%3]))
                    return false
            }
        }
        return true
    }

    override fun solve() {
        //val res = isValidSudoku(input)
    }
}