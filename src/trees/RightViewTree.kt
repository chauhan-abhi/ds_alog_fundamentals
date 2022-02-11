package trees

import Problem
import java.util.*


/*
* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
* */

class RightViewTree : BaseTreeProblem(), Problem {

    override fun solve() {
        println(rightSideView(getTree()))
    }

    private fun rightSideView(root: TreeNode?): List<Int> {
        val list = arrayListOf<Int>()
        if (root == null) return list
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (i ==0) list.add(node.`val`)
                if (root.right != null) queue.offer(node.right!!)
                if (root.left != null) queue.offer(node.left!!)
            }
        }
        return list
    }

    override fun getTree() = TreeUtils.getTestTree()
}