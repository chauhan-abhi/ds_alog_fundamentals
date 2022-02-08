package linklist

import Problem
import java.util.*

//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
class FindWinner : Problem {


    // poll k elements from front to last and remove k th element
    private fun findTheWinner(n: Int, k: Int): Int {
        val queue = LinkedList<Int>()
        for (i in 1..n)
            queue.add(i)
        var killed = 0
        for (i in 0 until n) {
            for (j in 1 until k) {
                queue.add(queue.poll())
            }
            killed = queue.poll()
        }
        return killed
    }

    override fun solve() {

        print(findTheWinner(5, 2))
        print(findTheWinner(6, 5))

    }

}