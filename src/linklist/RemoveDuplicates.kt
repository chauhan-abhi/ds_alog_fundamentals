package linklist

import Problem

/*
* Given the head of a singly linked list.
* The nodes of the linked list are going to be sorted in ascending order
* with respect to their values and the values are going to be integers.
* I am asked to write a function that is going to remove all the nodes with duplicate values
* and return the modified linked list. The linked list should be modified in place
* and the nodes should remain in their original order.
* https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/

class RemoveDuplicates: Problem {
    override fun solve() {
        val root = Node(1)
        root.next = Node(2)
        root.next?.next = Node(2)
        root.next?.next = Node(2)
        root.next?.next?.next= Node(3)
        root.next?.next?.next?.next= Node(4)
        root.next?.next?.next?.next?.next= Node(4)
        var modifiedRoot = removeDuplicates(root)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }

    private fun removeDuplicates(root: Node?): Node? {
        var current = root
        while(current != null) {
            var nextDistinctNode = current.next
            while (nextDistinctNode != null && nextDistinctNode.value == current.value) {
                nextDistinctNode = nextDistinctNode.next
            }
            current.next = nextDistinctNode
            current = nextDistinctNode
        }
        return root
    }
}