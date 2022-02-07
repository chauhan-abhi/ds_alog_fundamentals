package linklist

import Problem

// https://leetcode.com/problems/reverse-nodes-in-k-group/
class ReverseNodeInKGroup: Problem {

    private fun reverseKGroup(head: Node?, k: Int): Node? {
        if (head?.next == null || k == 1 ) return head
        val dummy = Node(-1)
        var curr = head
        dummy.next = curr
        var start: Node? = dummy
        var i = 0
        while (curr != null) {
            i++
            if (i%k==0) {
                start = reverse(start, curr.next)
                curr = start?.next
            } else curr = curr.next
        }
        return dummy.next
    }

    private fun reverse(start: Node?, end: Node?): Node? {

        var prev: Node? = start
        var curr = start?.next
        var next: Node?
        val first: Node? = curr
        while (curr != end) {
            next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
        }
        start?.next = prev
        first?.next = curr
        return first
    }



    override fun solve() {
        val root = Node(1)
        root.next = Node(4)
        root.next?.next = Node(5)
        root.next?.next?.next= Node(8)
        root.next?.next?.next?.next= Node(2)
        root.next?.next?.next?.next?.next= Node(3)

        var modifiedRoot = reverseKGroup(root, 2)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }
}