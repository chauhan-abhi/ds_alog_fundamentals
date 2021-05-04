package trees

abstract class BaseTreeProblem {

    abstract fun getTree(): TreeNode?

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}