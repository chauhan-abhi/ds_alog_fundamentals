package linklist

class Node(var value: Int) {
    var next: Node? = null
    override fun toString(): String {
        return value.toString()
    }
}