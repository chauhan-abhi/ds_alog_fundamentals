package design

import design.lrucache.Node

class LinkedList {


    private var head: Node? = null
    private var length = 0

    fun get(index: Int) = findAtIndex(index)?.value ?:-1

    private fun findAtIndex(index: Int): Node? =
        when {
            length == 0 || index > length - 1 -> null
            index <= 0 -> head
            else -> {
                var next = head?.next
                repeat(index - 1) {
                    next = next?.next
                }
                next
            }
        }

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(length, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index > length) return
        val pre = findAtIndex(index-1)
        val node = Node(`val`)
        when {
            pre == null -> head = node
            index == 0 -> {
                node.next = head
                head = node
            }
            else -> {
                node.next = pre.next
                pre.next = node
            }
        }
        length++
    }

    fun deleteAtIndex(index: Int) {
        when {
            length == 0 || index > length - 1 || index < 0 -> return
            index == 0 -> head = head?.next
            else -> findAtIndex(index - 1)?.let {
                it.next = it.next?.next
            }
        }
        length--
    }

}