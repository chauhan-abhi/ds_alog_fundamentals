package design.lrucache

internal class LruCache(var capacity: Int) {

    private var count: Int = 0
    private var map = HashMap<Int, Node>()
    private var head: Node = Node()
    private var tail: Node = Node()

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val n = map[key] ?: return -1
        update(n)
        return n.value
    }

    fun set(key: Int, value: Int) {
        var n = map[key]
        if (n == null) {
            n = Node(key = key, value = value)
            map[key] = n
            add(n)
            ++count
        } else {
            n.value = value
            update(node = n)
        }
        if (count > capacity) {
            val nodeToDelete = tail.prev
            remove(nodeToDelete)
            map.remove(nodeToDelete?.key)
            --count
        }
    }


    private fun add(node: Node) {
        val after = head.next
        head.next = node
        node.prev = head
        node.next = after
        after?.prev = node


    }

    private fun remove(node: Node?) {
        node?.let {
            val before = it.prev
            val after = it.next
            before?.next = after
            after?.prev = before
        }
    }

    private fun update(node: Node) {
        remove(node)
        add(node)
    }


}