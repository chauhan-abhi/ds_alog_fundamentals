import arrays.*
import linklist.*
import stack.*
import stack.ValidParenthesis

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            // main.initArrayProblems()
            // main.initStringProblems()
             main.initStackProblems()
            // main.initTreeProblems()
            // main.initLinkListProblems()
        }
    }

    private fun initStringProblems() {
        // val problem = FirstUniqueCharacter()
        // val problem = RansomNote()
        // val problem = ValidAnagram()
        // problem.solve()
    }

    private fun initStackProblems() {
        // val problem =  ValidParenthesis()
        val problem =  QueueUsingStack()
        problem.solve()
    }

    private fun initLinkListProblems() {
        // val problem = RemoveDuplicates()
        // val problem = DetectCycle()
        // val problem = MergeSortedList()
        // val problem = RemoveElementsNode()
        val problem = RotateList()
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
        // val problem = TwoSum()
        // val problem = TournamentWinner()
        // val problem = ClassPhotos()
        // val problem = TandemBicycle()
        // val problem = NextPermutation()
        // val problem = NthFibonacci()
        // val problem = MaximumSubArray()
        // val problem = MergeSortedArrays()
        // val problem = ArrayIntersectionII()
        // val problem = BestTimeToSellStock()
        // val problem = MatrixReshape()
        // val problem = PascalsTriangle()
        // val problem = ValidSudoku()
        val problem = MatrixSearch()
        problem.solve()
    }
}