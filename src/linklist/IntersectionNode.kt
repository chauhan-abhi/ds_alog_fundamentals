package linklist

import Problem

// https://leetcode.com/problems/intersection-of-two-linked-lists/

class IntersectionNode: Problem {

    // the one node that reaches end is directed to seconds head and vice versa
    // this eliminates difference between their length

    private fun getIntersectionNode(headA:Node?, headB:Node?):Node? {
        if (headA == null || headB == null) return null

        var n1 = headA
        var n2 = headB

        while (n1 != n2) {

            n1 = if (n1 == null) headB else n1.next
            n2 = if (n2 == null) headA else n2.next


        }
        return n1
    }


    override fun solve() {
        val root = Node(1)
        root.next = Node(2)
        val intersection = Node(3)
        root.next?.next = intersection
        root.next?.next?.next = Node(4)

        val root2 = Node(5)
        root2.next = Node(6)
        root2.next?.next = intersection
        root2.next?.next?.next = Node(7)
        root2.next?.next?.next?.next = Node(8)

        val modifiedRoot = getIntersectionNode(root, root2)
        print("${modifiedRoot?.value} ")

    }
}