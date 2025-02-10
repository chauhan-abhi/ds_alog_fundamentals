package trees

import Problem
import java.util.*


class MaxDepth : BaseTreeProblem(), Problem {
    override fun solve() {
        val root = getTree()
        println(maxDepth(root))
        println(maxDepthIterative(root))
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
    }

    private fun maxDepthIterative(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var count = 0
        while (!queue.isEmpty()) {
            var size: Int = queue.size
            while (size-- > 0) {
                val node: TreeNode = queue.poll()
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            count++
        }
        return count
    }

    override fun getTree() = TreeUtils.getTestTree()
}