package trees

import Problem
import java.util.*

class PreOrderTraversal: BaseTreeProblem(), Problem {

    private fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()

        preHelper(list, root)
        return list
    }

    private fun preorderIterative(root: TreeNode?): List<Int> {
        val pre: MutableList<Int> = LinkedList()
        if (root == null) return pre
        val visitingStack = Stack<TreeNode>()
        visitingStack.push(root)
        while (!visitingStack.empty()) {
            val visiting = visitingStack.pop()
            pre.add(visiting.`val`)
            if (visiting.right != null) visitingStack.push(visiting.right)
            if (visiting.left != null) visitingStack.push(visiting.left)
        }
        return pre
    }

    private fun preHelper(list: LinkedList<Int>, root: TreeNode?) {
        if (root == null) return

        list.add(root.`val`)
        preHelper(list, root.left)
        preHelper(list, root.right)
    }

    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val res = preorderTraversal(getTree())
        val resIt = preorderIterative(getTree())
        println(res.toString())
        println(resIt.toString())

    }

}