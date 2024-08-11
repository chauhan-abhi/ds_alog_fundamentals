package algorithm

import algorithm.binarySearch.BinarySearch

class AlgoMain {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = AlgoMain()
            main.initArrayProblems()

        }
    }

    private fun initArrayProblems() {
        val problem = BinarySearch()
        problem.solve()
    }
}
