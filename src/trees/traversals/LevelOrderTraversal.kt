package trees.traversals

import Problem
import trees.BaseTreeProblem
import trees.TreeUtils
import java.util.*
import kotlin.collections.ArrayList


class LevelOrderTraversal: BaseTreeProblem(), Problem {

    private fun levelOrderTraversal(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode>()
        val levelOrder = ArrayList<ArrayList<Int>>()
        if (root == null ) return levelOrder
        queue.push(root)

        while(queue.isNotEmpty()) {
            val level = queue.size
            val levelList  = ArrayList<Int>()

            for (i in 0 until level) {

                if (queue.peek().left != null)
                    queue.add(queue.peek().left!!)
                if (queue.peek().right != null)
                    queue.add(queue.peek().right!!)
                levelList.add(queue.poll().`val`)

            }
            levelOrder.add(levelList)
        }
        return levelOrder
    }

    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val res = levelOrderTraversal(getTree())
        println(res.toString())

    }

}