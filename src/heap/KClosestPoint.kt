package heap

import Problem
import java.util.*


/*
* https://leetcode.com/problems/k-closest-points-to-origin/
* */
class KClosestPoint: Problem {

    private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        Arrays.sort(points) { p1: IntArray, p2: IntArray ->
            p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]
        }
        return points.copyOfRange(0, k)
    }


    override fun solve() {
        val point1 = intArrayOf(1,-3)
        val point2 = intArrayOf(-2,2)
        val res = kClosest(arrayOf(point1, point2),1)
        res

    }
}