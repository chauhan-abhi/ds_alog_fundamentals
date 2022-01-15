package trees

import Problem
import java.util.*


class SymmetricTree: BaseTreeProblem(), Problem {
    override fun getTree(): TreeNode = TreeUtils.getSymmetricTree()

    override fun solve() {
        val root = (getTree())
        println(inorderTraversal(root))
        val res = isSymmetric(getTree())
        println(isSymmetricIterative(TreeUtils.getTestTree()))
        println(res)
    }

    private fun isSymmetric(root: TreeNode?): Boolean {
        return (root == null || isSymmetricHelper(root.left, root.right))
    }

    private fun isSymmetricHelper(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) return left == right
        else if (left.value != right.value) return false
        else return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left)
    }

    private fun isSymmetricIterative(root: TreeNode?): Boolean {
        if (root == null) return true
        val q: Queue<TreeNode?> = LinkedList<TreeNode?>()

        q.add(root.left)
        q.add(root.right)
        while (!q.isEmpty()) {
            val left = q.poll()
            val right = q.poll()
            if (left == null && right == null) continue
            if (left == null || right == null || left.value != right.value) return false
            q.add(left.left)
            q.add(right.right)
            q.add(left.right)
            q.add(right.left)
        }
        return true
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