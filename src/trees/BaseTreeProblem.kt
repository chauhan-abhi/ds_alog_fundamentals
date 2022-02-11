package trees

abstract class BaseTreeProblem {

    abstract fun getTree(): TreeNode?

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun printInorder(node: TreeNode?) {
        if (node == null) {
            return
        }
        printInorder(node.left)
        print(node.`val`.toString() + " ")
        printInorder(node.right)
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        else if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
            return root
        } else if (root.`val` < key) {
            root.right = deleteNode(root.right, key)
            return root
        } else {
            // the removing node is a leaf node, so just return null.
            if (root.left == null && root.right == null) return null

            // the removing node only has a left node, so just return the left node.
            if (root.left != null && root.right == null) return root.left

            // the removing node only has a right node, so just return the right node.
            if (root.left == null && root.right != null) return root.right

            // the removing node has both left and right nodes.
            // find the largest left node and replace it with the removing node.
            val leftLargest = findLargest(root.left)
            if (leftLargest != null) {
                leftLargest.left = deleteNode(root.left, leftLargest.`val`)
                leftLargest.right = root.right
                return leftLargest
            }
            // find the smallest right node and replace it with the removing node.
            val rightSmallest = findSmallest(root.right)
            if (rightSmallest != null) {
                rightSmallest.left = root.left
                rightSmallest.right = deleteNode(root.right, rightSmallest.`val`)
                return rightSmallest
            }
            // this is not supposed to be called. just return null.
            return null
        }
    }

    private fun findSmallest(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.left == null) return root
        return findLargest(root.left)
    }

    private fun findLargest(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.right == null) return root
        return findLargest(root.right)
    }
}