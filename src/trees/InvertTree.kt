package trees

import Problem
import java.util.*

class InvertTree: BaseTreeProblem(), Problem {
    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val root = (getTree())
        println(inorderTraversal(root))
        val res = invertTree(getTree())
        println(inorderTraversal(res))
    }

    private fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val left = root.left
        val right = root.right
        root.left = invertTree(right)
        root.right = invertTree(left)

        return root
    }

    private fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        inHelper(list, root)
        return list
    }

    private fun inHelper(list: LinkedList<Int>, root: TreeNode?) {
        if (root == null) return
        inHelper(list, root.left)
        list.add(root.value)
        inHelper(list, root.right)
    }

}