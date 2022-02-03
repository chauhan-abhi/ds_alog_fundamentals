package linklist

import Problem

// https://leetcode.com/problems/linked-list-cycle-ii/
/*
*   Distance traveled by slow when they meet: L1+L2
    Distance traveled by fast when they meet: L1+L2+x+L2,
*   where x is the remaining length of the cycle (meeting point to start of the cycle).

    2(L1+L2) = L1+L2+x+L2
    2L1 + 2L2 = L1+2L2+x
    => x = L1
* */
class DetectCycleII: Problem {

    private fun detectCycle(head: Node?): Node? {
        if (head?.next == null) return null
        var tempHead: Node? = head
        var slow = head
        var fast = head
        while (slow != null && fast?.next != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) {
                while (tempHead  != slow) {
                    slow = slow?.next
                    tempHead = tempHead?.next
                }
                return tempHead
            }
        }
        return null

    }

    override fun solve() {
        val root = Node(1)
        root.next = Node(2)
        root.next?.next = Node(3)
        root.next?.next?.next= Node(4)
        root.next?.next?.next?.next= root.next
        println(detectCycle(root)?.value)
    }
}