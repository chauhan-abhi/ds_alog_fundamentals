package linklist

import Problem

/*
* Given the head of a singly linked list.
* The nodes of the linked list are going to be sorted in ascending order
* with respect to their values and the values are going to be integers.
* I am asked to write a function that is going to remove all the nodes with duplicate values
* and return the modified linked list. The linked list should be modified in place
* and the nodes should remain in their original order.
*/

class RemoveElementsNode: Problem {
    override fun solve() {
        val root = Node(1)
        root.next = Node(1)
        root.next?.next = Node(1)
        root.next?.next = Node(1)

        var modifiedRoot = removeElements(root, 1)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }

    private fun removeElements(root: Node?, target: Int): Node? {
        val temp = Node(-1)
        temp.next = root
        var prev:Node? = temp
        var current = root

        while(current != null) {
            if (current.value == target) {
                prev?.next = current.next
            } else {
                prev = prev?.next
            }
            current = current.next
        }
        return temp.next
    }
}