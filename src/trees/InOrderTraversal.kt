package trees

import Problem
import java.util.*


class InOrderTraversal: BaseTreeProblem(), Problem {

    private fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        inHelper(list, root)
        return list
    }

    private fun inorderIterative(root: TreeNode?): List<Int> {
        val inorder: MutableList<Int> = LinkedList()
        val visitingStack = Stack<TreeNode>()
        var current = root
        while (current!= null || !visitingStack.empty()) {
            while (current != null) {
                visitingStack.add(current)
                current = current.left
            }
            current = visitingStack.pop()
            inorder.add(current.`val`)
            current = current.right
        }
        return inorder
    }

    private fun inHelper(list: LinkedList<Int>, root: TreeNode?) {
        if (root == null) return
        inHelper(list, root.left)
        list.add(root.`val`)
        inHelper(list, root.right)
    }

    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val res = inorderTraversal(getTree())
        val resIt = inorderIterative(getTree())
        println(res.toString())
        println(resIt.toString())

    }

}