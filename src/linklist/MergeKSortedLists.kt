package linklist

import Problem
import java.util.*


/*
* https://leetcode.com/problems/merge-k-sorted-lists/
* */
class MergeKSortedLists: Problem {

    private fun mergeKLists(lists: Array<Node?>): Node? {
        if (lists.isNullOrEmpty()) return null

        val queue = PriorityQueue(lists.size) { o1: Node, o2: Node ->
            if (o1.value < o2.value) -1
            else if (o1.value == o2.value) 0
            else 1
        }

        lists.forEach {
            if (it != null)
                queue.add(it)
        }
        val dummy = Node(-1)
        var tail: Node? = dummy
        while (queue.isNotEmpty()) {
            tail?.next = queue.poll()
            tail = tail?.next
            if (tail?.next != null)
                queue.add(tail.next)

        }
        return dummy.next

    }


    override fun solve() {
        val root = Node(1)
        root.next = Node(4)
        root.next?.next = Node(5)


        val root2 = Node(1)
        root2.next = Node(3)
        root2.next?.next = Node(4)

        val root3 = Node(2)
        root2.next = Node(6)

        mergeKLists(arrayOf(root, root2, root3))
    }
}