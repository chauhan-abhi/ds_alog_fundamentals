package trees

abstract class BaseTreeProblem {

    abstract fun getTree(): TreeNode?

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun printInorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        printInorder(node.left)
        print(node.value.toString() + " ")
        printInorder(node.right)
    }
}