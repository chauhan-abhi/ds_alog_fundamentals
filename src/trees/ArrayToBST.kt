package trees

import Problem


/*
* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* */

class ArrayToBST : BaseTreeProblem(), Problem {

    override fun solve() {
        val result = arrayListOf<Int>()
        println(sortedArrayToBST(intArrayOf(-10,-3,0,5,9)))
        print(result)
    }

    private  fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return arrayToBST(nums, 0, nums.size-1)
    }

    private fun arrayToBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val mid: Int = start + (end - start)/2
        val treeNode  = TreeNode(nums[mid])
        treeNode.left = arrayToBST(nums, start, mid-1)
        treeNode.right = arrayToBST(nums, mid+1, end)
        return treeNode
    }

    override fun getTree() = TreeUtils.getTestTree()
}