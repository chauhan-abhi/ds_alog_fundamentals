import arrays.*
import linklist.RemoveDuplicates

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            main.initArrayProblems()
            //main.initTreeProblems()
            //main.initLinkListProblems()
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
        //val problem = TwoSum()
        // val problem = TournamentWinner()
        // val problem = ClassPhotos()
        //val problem = TandemBicycle()
        //val problem = NextPermutation()
        //val problem = NthFibonacci()
        //val problem = MaximumSubArray()
        //val problem = MergeSortedArrays()
        //val problem = ArrayIntersectionII()
        val problem = BestTimeToSellStock()
        problem.solve()
    }
}