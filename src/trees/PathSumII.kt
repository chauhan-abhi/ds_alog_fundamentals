package trees

import Problem


/*
https://leetcode.com/problems/path-sum-ii/
*/

class PathSumII : BaseTreeProblem(), Problem {

    override fun solve() {
        val result = arrayListOf<Int>()
        hasPathSum(getTree(), 0)
        println(hasPathSum(getTree(), 22))
        println(hasPathSum(getTree(), 23))
        print(result)
    }

    private fun hasPathSum(root: TreeNode?, target: Int): ArrayList<List<Int>> {
        val result: ArrayList<List<Int>> = arrayListOf()
        pathSum(root, target, arrayListOf(), result)
        return result
    }

    private fun pathSum(root: TreeNode?, value: Int, path: ArrayList<Int>, result: ArrayList<List<Int>>) {
        if (root == null) return
        path.add(root.`val`)
        if (root.`val` == value && root.left == null && root.right == null) {
            result.add(path)
            return
        }
        pathSum(root.left, value - root.`val`, ArrayList(path), result)
        pathSum(root.right, value - root.`val`, ArrayList(path), result)
    }

    override fun getTree() = TreeUtils.getTestTree()
}