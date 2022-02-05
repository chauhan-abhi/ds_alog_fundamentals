package linklist

import Problem


class SwapNodes: Problem {

    // 1 -> 4 -> 5 -> 8
    // https://leetcode.com/problems/swap-nodes-in-pairs/

    private fun swapPairs(head: Node?): Node? {
        val dummy = Node(-1)
        dummy.next = head
        var curr : Node?= dummy

        while (curr?.next != null && curr.next?.next != null) {
            val first: Node? = curr.next
            val second: Node? = curr.next?.next
            first?.next = second?.next
            curr.next = second
            curr.next?.next = first
            curr = curr.next?.next
        }

        return dummy.next
    }


    override fun solve() {
        val root = Node(1)
        root.next = Node(4)
        root.next?.next = Node(5)
        root.next?.next?.next= Node(8)

        var modifiedRoot = swapPairs(root)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }
}