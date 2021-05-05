import arrays.*
import trees.BranchSum
import trees.ClosestValue
import trees.NodeDepth
import java.util.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            main.initArrayProblems()
            main.initTreeProblems()
        }
    }

    private fun initTreeProblems() {
        //val problem = ClosestValue()
        //val problem = BranchSum()
        val problem = NodeDepth()
        problem.solve()
    }

    fun initArrayProblems() {
        // val problem = SortedSquaresArray()
        // val problem = ValidSubsequence()
        // val problem = TwoSun()
        // val problem = TournamentWinner()
        // problem.solve()
    }
}