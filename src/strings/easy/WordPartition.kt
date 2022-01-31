package strings.easy

import Problem


/*
* https://leetcode.com/problems/partition-labels/
* */
class WordPartition : Problem {

    private fun partitionLabels(s: String): List<Int> {
        val res = arrayListOf<Int>()

        // chat to last index of char
        val hm = hashMapOf<Char, Int>()
        for (i in s.indices) {
            hm[s[i]] = i
        }

        var start = 0
        var currEnd = -1
        for (i in s.indices) {
            currEnd = Math.max(currEnd, hm[s[i]]?:0)
            if (currEnd == i) {
                val len = currEnd-start+1
                start = currEnd+1
                res.add(len)
            }
        }
        return res
    }

    override fun solve() {
        println(partitionLabels("ababcbacadefegdehijhklij"))
        println(partitionLabels("eccbbbbdec"))


    }
}