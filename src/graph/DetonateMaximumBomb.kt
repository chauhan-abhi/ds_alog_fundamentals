package graph

import DFS
import java.lang.Integer.max
import kotlin.math.sqrt

class DetonateMaximumBomb : DFS {

    private fun maximumDetonation(bombs: Array<IntArray>): Int {
        var maxBombs = 0

        val visited = BooleanArray(bombs.size)
        for (i in bombs.indices) {
            visited.fill(false)
            val count = dfsStack(bombs, i, visited)
            maxBombs = max(maxBombs, count)
        }
        return maxBombs
    }

    private fun dfsStack(bombs: Array<IntArray>, start: Int, visited: BooleanArray): Int {
        val stack = ArrayDeque<Int>()
        stack.addLast(start)
        visited[start] = true
        var count = 0

        while (stack.isNotEmpty()) {
            val current = stack.last()
            count++
            stack.removeLast()
            for (j in bombs.indices) {
                if (!visited[j] && inRange(bombs[current], bombs[j])) {
                    stack.addLast(j)
                    visited[j] = true
                }
            }
        }
        return count
    }

    private fun inRange(p1: IntArray, p2: IntArray): Boolean {
        val (x1, y1, r1) = p1
        val (x2, y2, _) = p2

        val distance = sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)).toDouble())
        return distance <= r1
    }

    override fun solve() {
        val province = arrayOf(
            intArrayOf(2, 1, 3),
            intArrayOf(6, 1, 4),
        )
        println(maximumDetonation(province))
        val province2 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 4, 2),
            intArrayOf(4, 5, 3),
            intArrayOf(5, 6, 4)
        )
        println(maximumDetonation(province2))
    }
}