package trees

import Problem
import java.util.*


class PostOrderTraversal: BaseTreeProblem(), Problem {

    private fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        postHelper(list, root)
        return list
    }

    private fun postorderIterative(root: TreeNode?): List<Int> {
        val postOrder: MutableList<Int> = LinkedList()
        val visitingStack = Stack<TreeNode>()
        if (root == null) return postOrder
        var cur = root

        while (cur != null || !visitingStack.empty()) {
            while (!isLeaf(cur)) {
                visitingStack.push(cur)
                cur = cur?.left
            }
            if (cur != null) postOrder.add(cur.`val`)
            while (!visitingStack.empty() && cur == visitingStack.peek().right) {
                cur = visitingStack.pop()
                postOrder.add(cur.`val`)
            }
            cur = if (visitingStack.empty()) null else visitingStack.peek().right
        }

        return postOrder
    }

    private fun isLeaf(r: TreeNode?): Boolean {
        return if (r == null) true else r.left == null && r.right == null
    }

    private fun postHelper(list: LinkedList<Int>, root: TreeNode?) {
        if (root == null) return
        postHelper(list, root.left)
        postHelper(list, root.right)
        list.add(root.`val`)

    }

    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val res = postorderTraversal(getTree())
        val resIt = postorderIterative(getTree())
        println(res.toString())
        println(resIt.toString())

    }

}