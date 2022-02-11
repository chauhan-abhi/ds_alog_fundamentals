package trees

import Problem
import java.util.*


/*
* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
* */

class ZigZagTraversal : BaseTreeProblem(), Problem {

    override fun solve() {
        println(zigzagLevelOrder(getTree()))

    }

    private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val list = arrayListOf<List<Int>>()
        if (root == null) return list
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var size = 1
        var ltr = true
        while (queue.isNotEmpty()) {
            val tmp = arrayListOf<Int>()
            for (i in 0 until size) {
                val node = queue.poll()
                if (ltr) tmp.add(node.`val`)
                else tmp.add(0, node.`val`)
                if(node.left != null) queue.add(node.left!!)
                if(node.right != null) queue.add(node.right!!)

            }
            list.add(tmp)
            size = queue.size
            ltr = !ltr
        }
        return list
    }

    override fun getTree() = TreeUtils.getTestTree()
}