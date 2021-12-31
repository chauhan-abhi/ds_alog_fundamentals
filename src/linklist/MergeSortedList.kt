package linklist

import Problem

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeSortedList: Problem {

    private fun mergeTwoLists(l1: Node?, l2: Node?): Node? {
        val head = Node(0)
        var handler: Node? = head
        var node1 = l1
        var node2 = l2
        while (node1 != null && node2 != null) {
            if (node1.value <= node2.value) {
                handler?.next = node1
                node1 = node1.next
            } else {
                handler?.next = node2
                node2 = node2.next
            }
            handler = handler!!.next
        }

        if (node1 != null) {
            handler?.next = node1
        } else if (node2 != null) {
            handler?.next = node2
        }

        return head.next
    }


    override fun solve() {
        val root = Node(1)
        root.next = Node(4)
        root.next?.next = Node(5)
        root.next?.next?.next= Node(8)
        root.next?.next?.next?.next= root.next

        val list2 = Node(2)
        list2.next = Node(6)


        var resHead = mergeTwoLists(root, list2)
    }
}