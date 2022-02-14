package heap

import Problem
import java.lang.StringBuilder
import java.util.*


/*
* https://leetcode.com/problems/sort-characters-by-frequency/
* */
class SortCharactersByFreq: Problem {

    private fun frequencySort(s: String): String {
        val map = hashMapOf<Char, Int>()
        val chArr = s.toCharArray()
        for (x in chArr) {
            map[x] = map.getOrDefault(x, 0) + 1
        }
        val pq = PriorityQueue<Map.Entry<Char, Int>> { a , b ->
            b.value - a.value
        }
        pq.addAll(map.entries)

        val sb = StringBuilder()
        while (pq.isNotEmpty()) {
            val e = pq.poll()
            for (i in 0 until e.value) {
                sb.append(e.key)
            }
        }
        return sb.toString()
    }


    override fun solve() {
        println(frequencySort("tee"))
        println(frequencySort("tree"))
        println(frequencySort("cccaaa"))

    }
}