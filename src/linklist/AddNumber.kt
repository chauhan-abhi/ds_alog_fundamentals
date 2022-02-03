package linklist

import Problem


class AddNumber: Problem {

    // https://leetcode.com/problems/add-two-numbers/

    private fun addTwoNumbers(l1: Node?, l2: Node?): Node? {

        var n1 = l1
        var n2 = l2
        val dummy = Node(-1)
        var curr: Node? = dummy
        var carry = 0
        while (n1 != null || n2 != null || carry != 0) {
            val num1 = n1?.value ?: 0
            val num2 = n2?.value ?: 0
            val sum = num1 + num2 + carry

            carry = sum /10
            curr?.next = Node(sum%10)
            curr = curr?.next

            n1 = n1?.next
            n2 = n2?.next

        }

        return dummy.next

    }


    override fun solve() {
        val root = Node(2)
        root.next = Node(4)
        root.next?.next = Node(3)
        val num2 = Node(5)
        num2.next = Node(6)
        num2.next?.next = Node(4)

        var modifiedRoot = addTwoNumbers(root, num2)
        while (modifiedRoot != null) {
            print("${modifiedRoot.value} ")
            modifiedRoot = modifiedRoot.next
        }
    }
}