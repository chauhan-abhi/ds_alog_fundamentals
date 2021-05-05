package trees

import Problem


/*
"""
The distance between a node in a Binary Tree and the tree's root alled the node's depth.
Write a function that takes in a Binary Tree and returns the sum of tis nodes' depths.
Each 'BinaryTree' node has an integer 'value', a 'left' child node, and a 'right' child node.
Children nodes can either be 'BinaryTree' nodes themselves or 'None/null
"""
*/
class NodeDepth : BaseTreeProblem(), Problem {
    override fun solve() {
        val root = getTree()
        if (root == null) print(-1)
        print(nodeDepths(root, 0))
    }

    private fun nodeDepths(root: BaseTreeProblem.TreeNode?, depth: Int): Int {
        if (root == null) return 0
        return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1)
    }

    override fun getTree() = TreeUtils.getTestTree()
}