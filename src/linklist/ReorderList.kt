package linklist

import Problem

//https://leetcode.com/problems/reorder-list/
class ReorderList: Problem {

    private fun reorderList(head: Node?): Node? {
        if (head == null) return null
        var slow = head
        var fast = head
        while (slow?.next != null && fast?.next != null && fast.next?.next != null) {
            slow = slow.next
            fast = fast.next?.next
        }
        // currently slow is at mid and fast at end
        var mid: Node? = slow?.next
        slow?.next = null
        mid = RotateList.rotate(mid)

        slow = head
        fast = mid

        while (fast != null) {
            val t1 = slow?.next
            val t2 = fast.next
            slow?.next = fast
            fast.next = t1
            slow = t1
            fast = t2
        }

        return head
    }



    override fun solve() {
        val root = Node(1)
        root.next = Node(4)
        root.next?.next = Node(5)
        root.next?.next?.next= Node(8)

        var modifiedRoot = reorderList(root)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }
}