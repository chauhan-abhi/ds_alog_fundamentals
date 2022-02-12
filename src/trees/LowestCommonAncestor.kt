package trees

import Problem
import java.util.*
import kotlin.concurrent.fixedRateTimer

class LowestCommonAncestor: BaseTreeProblem(), Problem {
    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val root = (getTree())
        println(lowestCommonAncestor(root, root.left, root.right)?.`val`)
    }

    private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        if (root == null) return root
        if (root == p) return p
        if (root == q) return q
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left != null && right != null) return root
        return left?:right


    }

}