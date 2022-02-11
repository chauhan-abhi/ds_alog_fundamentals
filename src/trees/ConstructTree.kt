package trees

import Problem
import java.util.HashMap


/*
* https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
* */

class ConstructTree : BaseTreeProblem(), Problem {

    var preStart = 0
    override fun solve() {
        val preOrder = intArrayOf(3,9,20,15,7)
        val inOrder = intArrayOf(9,3,15,20,7)
        printInorder(buildTree(preOrder, inOrder))
    }

    private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val hm = hashMapOf<Int, Int>()
        for (x in inorder.indices) {
            hm[inorder[x]] = x
        }
        return buildTreeUtil(preorder,  inorder, 0, inorder.size - 1,   hm)
    }

    private fun buildTreeUtil(
        preorder: IntArray,
        inorder: IntArray,
        inStart: Int,
        inEnd: Int,
        hm: HashMap<Int, Int>
    ): TreeNode? {
        if (inStart > inEnd) return null
        val root = TreeNode(preorder[preStart++])

        if (inStart == inEnd) return root
        val inIndex = (hm[root.`val`]?: 0)
        root.left = buildTreeUtil(preorder, inorder, inStart, inIndex -1,  hm)
        root.right = buildTreeUtil(preorder, inorder, inIndex + 1,inEnd,  hm)
        return root

    }


    override fun getTree() = TreeUtils.getTestTree()
}