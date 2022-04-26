package trees

import Problem
import kotlin.math.max

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
class MaxPathSumDp : BaseTreeProblem(), Problem {

    var maxSum = Int.MIN_VALUE

    override fun solve() {
        println(maxPathSum(getTree()))
    }

    private fun maxPathSum(root: TreeNode?): Int {
        maxPathDown(root)
        return maxSum
    }

    private fun maxPathDown(root: TreeNode?): Int {
        if (root == null) return 0
        val left = max(0, maxPathDown(root.left))
        val right = max(0, maxPathDown(root.right))
        maxSum = max(maxSum, root.`val` + left + right) // include root in maxSum for path
        return root.`val` + max(left, right) // take either left or right path in decision tree
    }

    override fun getTree(): BaseTreeProblem.TreeNode {
        val root = TreeNode(-2)
        root.left = TreeNode(1)
        return root
    }
}