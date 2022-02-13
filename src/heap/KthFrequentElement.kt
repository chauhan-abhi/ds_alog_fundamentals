package heap

import Problem
import java.util.*


/*
* https://leetcode.com/problems/top-k-frequent-elements/
* */
class KthFrequentElement: Problem {

    private  fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()

        for (x in nums) {
            map[x] = map.getOrDefault(x, 0) + 1
        }
        val bucket: Array<ArrayList<Int>?> = arrayOfNulls(nums.size + 1)
        for (x in map.keys) {
            val freq = map[x]
            if (bucket[freq ?: -1] == null && freq != null) {
                bucket[freq] = arrayListOf()
            }
            bucket[freq ?: -1]?.add(x)
        }

        val res = ArrayList<Int>()

        var i: Int = bucket.size - 1
        var kk = k
        while (i > 0 && kk > 0) {
            if (bucket[i] != null) {
                val list: List<Int> = bucket[i]!!
                res.addAll(list)
                kk -= list.size
            }
            --i
        }
        return res.toIntArray()
    }


    override fun solve() {
        val input = intArrayOf(1,1,1,2,2,3)
        val res = topKFrequent(input,2 )
        for (x in res)
            print("$x ")
    }
}