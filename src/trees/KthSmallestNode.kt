package trees

import Problem
import java.util.*


/*
* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
* */

class KthSmallestNode : BaseTreeProblem(), Problem {

    override fun solve() {
        println(kthSmallest(getTree(), 2))
        println(kthSmallest(getTree(), 4))
    }

    private fun kthSmallest(root: TreeNode?, k: Int): Int {
        var curr = root
        var minL = k
        val stack = Stack<TreeNode>()
        // for min element search in left tree
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }

        while (minL > 0) {
            val node = stack.pop()
            minL--
            if (minL == 0) return node.`val`
            // not found in left go one step right

            var right = node.right
            while (right != null) {
                stack.push(right)
                // always search in left
                right = right.left
            }
        }
        return -1
    }

    override fun getTree() = TreeUtils.getTestTree()
}