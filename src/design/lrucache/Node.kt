package design.lrucache

internal class Node (var key: Int = 0, var value: Int = 0) {
    var prev: Node? = null
    var next: Node? = null
}