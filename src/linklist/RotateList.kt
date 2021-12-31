package linklist

import Problem


class RotateList: Problem {

    // 1 -> 4 -> 5 -> 8
    // https://leetcode.com/problems/reverse-linked-list/

    private fun rotateList(head: Node?): Node? {
        val newHead: Node?
        var prev: Node? = null
        var curr = head
        var next: Node?
        while (curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        newHead = prev
        return newHead
    }


    override fun solve() {
        val root = Node(1)
        root.next = Node(4)
        root.next?.next = Node(5)
        root.next?.next?.next= Node(8)

        var modifiedRoot = rotateList(root)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }
}