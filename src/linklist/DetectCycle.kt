package linklist

import Problem

// https://leetcode.com/problems/linked-list-cycle/
class DetectCycle: Problem {

    private fun hasCycle(head: Node?): Boolean {
        if (head == null) return false
        var slow = head
        var fast = head
        while (slow != null && fast?.next != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) return true
        }
        return false

    }

    override fun solve() {
        val root = Node(1)
        root.next = Node(2)
        root.next?.next = Node(3)
        root.next?.next?.next= Node(4)
        root.next?.next?.next?.next= root.next
        println(hasCycle(root))
    }
}