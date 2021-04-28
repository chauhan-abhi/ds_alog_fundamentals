package trees

import Problem
import kotlin.math.abs

/*
* Given a non-empty binary search tree and a target value,
* find the value in the BST that is closest to the target.
*
* Given target value is a floating point.
* You are guaranteed to have only one unique value in the BST
* that is closest to the target
* */

class ClosestValue : Problem {

    var closest = Int.MAX_VALUE

    override fun solve() {
        val root = TreeNode(5)
        root.left = TreeNode(4)
        root.right = TreeNode(9)
        root.left?.left = TreeNode(2)
        root.right?.left = TreeNode(8)
        root.right?.right = TreeNode(10)
        val target = 5.0
        closest = root.value
        computeClosestElementInBST(root, target)
        print(closest)
    }

    private fun computeClosestElementInBST(root: TreeNode?, target: Double) {
        if (root == null) return
        if (abs(root.value - target) < abs(target - closest))
            closest = root.value
        if (target > root.value)
            computeClosestElementInBST(root.right, target)
        else computeClosestElementInBST(root.left, target)
    }

}