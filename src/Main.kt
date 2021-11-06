import arrays.*
import linklist.RemoveDuplicates
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
            main.initLinkListProblems()
        }
    }

    private fun initLinkListProblems() {
        val problem = RemoveDuplicates()
        problem.solve()
    }

    private fun initTreeProblems() {
        //val problem = ClosestValue()
        //val problem = BranchSum()
        //val problem = NodeDepth()
        //problem.solve()
    }

    fun initArrayProblems() {
        // val problem = SortedSquaresArray()
        // val problem = ValidSubsequence()
        // val problem = TwoSun()
        // val problem = TournamentWinner()
        // val problem = ClassPhotos()
        val problem = TandemBicycle()
        //problem.solve()
    }
}