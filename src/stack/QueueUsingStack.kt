package stack

import Problem
import java.util.*

class QueueUsingStack: Problem {

    var s1 = Stack<Int>()
    var s2 = Stack<Int>()

    fun push(x: Int) {
        s1.push(x)
    }

    fun pop(): Int {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop())
        }
        return s2.pop()
    }

    fun peek(): Int {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop())
        }
        return s2.peek()
    }

    fun empty(): Boolean = s1.isEmpty() && s2.isEmpty()


    override fun solve() {
        push(2)
        push(3)
        push(4)
        println("${peek()} peek")
        println("${pop()} popped")
        println("${peek()} peek")

    }
}