package arrays.matrix

import BaseProblem
import Problem


class PascalsTriangle: BaseProblem(), Problem {
    /*
    * 1
    * 1 1
    * 1 2 1
    * 1 3 3 1
    * 1 4 6 4 1
    *
    * */

    private fun generate(numRows: Int): List<List<Int>> {
        val res: ArrayList<List<Int>> = arrayListOf()
        for (i in 0 until numRows) {
            val rowList = arrayListOf<Int>()
            rowList.add(1)
            for (j in 1..i) {
                val size = res[i-1].size
                if (j >= size) {
                    rowList.add(res[i-1][j-1])
                } else {
                    rowList.add(res[i-1][j-1] + res[i-1][j])
                }

            }
            res.add(rowList)
        }
        return res
    }

    override fun solve() {
        val res = generate(3)
        for(element in res) {
            for (j in element) {
                print(j)
            }
            println()
        }
    }
}