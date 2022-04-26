package trees

import Problem
import java.util.*
import kotlin.concurrent.fixedRateTimer

class SerializeDeserializeTree: BaseTreeProblem(), Problem {
    override fun getTree(): TreeNode = TreeUtils.getTestTree()

    override fun solve() {
        val root = (getTree())
    }

    private fun serialize(root: TreeNode?): String = root?.let {
            node -> "${node.`val`},${serialize(node.left)},${serialize(node.right)}"
    } ?: "null"


    fun deserialize(data: String): TreeNode? = deserialize(data.split(",").toMutableList())

    private fun deserialize(parts: MutableList<String>): TreeNode? = parts.takeUnless { it.isEmpty() }?.let {
            strings ->
        strings.removeFirst().let { first ->
            first.takeUnless { it == "null" }?.let { numStr ->
                TreeNode(numStr.toInt()).apply {
                    this.left = deserialize(strings)
                    this.right = deserialize(strings)
                }
            } ?: null
        }

    } ?: null
}