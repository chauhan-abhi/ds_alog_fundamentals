import arrays.*
import trees.ClosestValue

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            main.initArrayProblems()
        }
    }

    fun initArrayProblems() {
        val array = listOf(5, 1, 22, 25, 6, -1, 8, 10)
        val sequence = listOf(1, 6, -1, 10)
        //print(ValidSubsequence().isValidSubsequence(array, sequence))
        //print(TwoSun().twoSum(array, 6))
        //val problem = SortedSquaresArray()
        //val tournament: Problem = TournamentWinner()

        //val problem = NonConstructibleChange()
        val problem = ClosestValue()
        problem.solve()
    }
}