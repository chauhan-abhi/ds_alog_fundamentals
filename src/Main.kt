import arrays.*
import linklist.*
import stack.*
import trees.*
import strings.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            // main.initArrayProblems()
             main.initStringProblems()
            // main.initStackProblems()
            // main.initTreeProblems()
            // main.initLinkListProblems()
        }
    }

    private fun initStringProblems() {
        // val problem = FirstUniqueCharacter()
        // val problem = RansomNote()
        // val problem = ValidAnagram()
         val problem = RomanToInteger()
        problem.solve()
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
        // val problem = ClosestValue()
        // val problem = BranchSum()
        // val problem = NodeDepth()
        // val problem = PreOrderTraversal()
        val problem = InOrderTraversal()
        problem.solve()
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