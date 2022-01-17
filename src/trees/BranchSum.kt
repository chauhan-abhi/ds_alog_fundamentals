package trees

import Problem


/*
* Write a function that takes in a Binary Tree and
* returns a list of its branch sums ordered from
* leftmost branch sum to rightmost branch sum.
*
* A branch sum is the sum of all values in a Binary Tree
* branch. A Binary Tree branch is a path of nodes
* in a tree that starts at the root node and ends
* at any leaf node.
*
* */

class BranchSum : BaseTreeProblem(), Problem {

    override fun solve() {
        val result = arrayListOf<Int>()
        branchSum(getTree(), 0, result)
        println(hasPathSum(getTree(), 22))
        println(hasPathSum(getTree(), 23))
        print(result)
    }

    private fun hasPathSum(root: TreeNode?, target: Int): Boolean {
        if (root == null) return false
        return if (root.left == null &&
            root.right == null &&
            root.value == target) true
        else hasPathSum(root.left, target - root.value) || hasPathSum(root.right, target - root.value)
    }

    private fun branchSum(root: TreeNode?, value: Int, result: ArrayList<Int>) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            result.add(root.value + value)
            return
        } else {
            branchSum(root.left, root.value + value, result)
            branchSum(root.right, root.value + value, result)
        }
    }

    override fun getTree() = TreeUtils.getTestTree()
}