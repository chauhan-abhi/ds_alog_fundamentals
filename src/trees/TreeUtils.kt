package trees

object TreeUtils {
    fun getTestTree() : BaseTreeProblem.TreeNode {
        val root = BaseTreeProblem.TreeNode(5)
        root.left = BaseTreeProblem.TreeNode(4)
        root.right = BaseTreeProblem.TreeNode(9)
        root.left?.left = BaseTreeProblem.TreeNode(2)
        root.right?.left = BaseTreeProblem.TreeNode(8)
        root.right?.right = BaseTreeProblem.TreeNode(10)
        return root
    }
}