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

    // https://leetcode.com/problems/reverse-linked-list-ii/
    private fun reverseBetween(head: Node?, left: Int, right: Int): Node? {

        val dummy = Node(0)
        dummy.next = head

        var curr1: Node? = dummy
        var pre1: Node? = null

        for (i in 0 until left) {
            pre1 = curr1
            curr1 = curr1?.next
        }

        var curr2: Node? = curr1
        var pre2: Node? = pre1
        var next: Node?

        for (i in left..right) {
            next = curr2?.next
            curr2?.next = pre2
            pre2 = curr2
            curr2 = next
        }
        pre1?.next = pre2
        curr1?.next = curr2


        return dummy.next
    }



    override fun solve() {
        val root = Node(1)
        root.next = Node(2)
        root.next?.next = Node(3)
        root.next?.next?.next= Node(4)
        root.next?.next?.next?.next= Node(5)
        root.next?.next?.next?.next?.next= Node(6)

        val modifiedRoot = reverseKGroup(root, 2)
        val problem2Root = reverseBetween(root, 2, 4)

        printList(modifiedRoot)
        printList(problem2Root)
    }

    private fun printList(root: Node?) {
        var modifiedRoot = root
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }
}