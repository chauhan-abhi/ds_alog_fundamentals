import arrays.matrix.*
import arrays.medium.*
import graph.*
import heap.*
import linklist.*
import stack.*
import trees.*
import strings.medium.*
class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val main = Main()
            main.initArrayProblems()
            //main.initMatrixProblems()
            // main.initStringProblems()
            // main.initStackProblems()
            // main.initTreeProblems()
            // main.initLinkListProblems()
            //main.initGraphProblems()
            //main.initHeapProblems()
        }
    }

    private fun initHeapProblems() {
        //val problem = KthFrequentElement()
        //val problem = SortCharactersByFreq()
        val problem = KClosestPoint()
        problem.solve()
    }

    private fun initMatrixProblems() {
        //val problem = SpiralMatrix()
        //val problem = MatrixReshape()
        val problem = MatrixSearchII()
        //val problem = MatrixSearch()
        problem.solve()
    }

    private fun initStringProblems() {
        // val problem = FirstUniqueCharacter()
        // val problem = RansomNote()
        // val problem = ValidAnagram()
        // val problem = RomanToInteger()
        // val problem = LongestCommonPrefix()
        // val problem = StrStr()
        // val problem = LengthOfLastWord()
        //val problem = AddBinary()
        //val problem = AddStrings()
        //val problem = LongestPalindrome()
        //val problem = WordPattern()
        //val problem = WordPartition()
        //val problem = GroupAnagrams()
        //val problem = MultiplyStrings()
        //val problem = RepeatedDNA()
        val problem = LongestPalindromicSubstring()

        problem.solve()
    }

    private fun initStackProblems() {
         val problem =  ValidParenthesis()
        //val problem =  QueueUsingStack()
        problem.solve()
    }

    private fun initLinkListProblems() {
        // val problem = RemoveDuplicates()
        // val problem = DetectCycle()
        // val problem = DetectCycleII()
        // val problem = MergeSortedList()
        // val problem = RemoveElementsNode()
        //val problem = RotateList()
        //val problem = AddNumber()
        //val problem = IntersectionNode()
        //val problem = SwapNodes()
        //val problem = ReorderList()
        //val problem = ReverseNodeInKGroup()
        val problem = FindWinner()
        problem.solve()
    }

    private fun initTreeProblems() {
        // val problem = ClosestValue()
        // val problem = BranchSum()
        // val problem = NodeDepth()
        // val problem = PreOrderTraversal()
        // val problem = InOrderTraversal()
        // val problem = PostOrderTraversal()
        //val problem = InvertTree()
        //val problem = LevelOrderTraversal()
        // val problem = MaxDepth()
        //val problem = SymmetricTree()
        //val problem = ZigZagTraversal()
        //val problem = ConstructTree()
        //val problem = PathSumII()
        //val problem = RightViewTree()
        //val problem = KthSmallestNode()
        val problem = LowestCommonAncestor()
        problem.solve()
    }

    fun initArrayProblems() {
        // val problem = SortedSquaresArray()
        // val problem = ValidSubsequence()
        // val problem = TwoSum()
        // val problem = ThreeSum()
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
        // val problem = MatrixSearch()
        // val problem = SingleNumber()
        //val problem = MajorityNumber()
        //val problem = SortColors()
        //val problem = MergeIntervals()
        //val problem = NonOverlappingIntervals()
        //val problem = IncreasingTriplet()
        //val problem = ProductExceptSelf()
        //val problem = SubArraySumK()
        //val problem = SearchInRotatedArray()
        //val problem = RangeSearchArray()
        val problem = Permutations()
        problem.solve()
    }

    fun initGraphProblems() {
        val problem = KeysAndRoom()
        problem.solve()
    }
}