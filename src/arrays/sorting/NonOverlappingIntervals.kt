package arrays.sorting

import Problem
import java.util.*

class NonOverlappingIntervals : Problem {

    private fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { a: IntArray, b: IntArray -> a[1].compareTo(b[1]) }

        //val merged = LinkedList<IntArray>()
        var pre = intervals[0][1]
        var rem = 0


        for (i in 1 until intervals.size) {
            if (intervals[i][0] < pre) {
                //invalid interval ie., similar to meeting scheduling
                rem++
            } else {
                // last valid end
                pre = intervals[i][1]
            }
        }
        return rem
    }

    override fun solve() {
        val res = (eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 3))
        ))
        val res1 = (eraseOverlapIntervals(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
        )
        ))
        println(res)
        println(res1)
    }
}