package arrays.sorting

import Problem
import java.util.*

class MergeIntervals : Problem {

    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { a: IntArray, b: IntArray -> a[0].compareTo(b[0]) }

        val merged = LinkedList<IntArray>()
        var pre = intervals[0]

        merged.add(pre)

        for (interval in intervals) {
            if (interval[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], interval[1])
            } else {
                pre = interval
                merged.add(interval)
            }
        }
        return merged.toTypedArray()
    }

    override fun solve() {
        val res = (merge(arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18))
        ))
        for(x in res)println(x.toList())
    }
}