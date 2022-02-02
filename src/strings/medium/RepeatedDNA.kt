package strings.medium

import Problem
import java.lang.StringBuilder

/*
* https://leetcode.com/problems/multiply-strings/
*  */
class RepeatedDNA : Problem {

    private  fun findRepeatedDnaSequences(s: String): List<String> {

        val set = hashSetOf<String>()
        val setRepeat = hashSetOf<String>()
        for (i in 0 until s.length-10) {
            val x = s.substring(i..(i+9))
            if (!set.add(x) ) setRepeat.add(x)
        }
        return setRepeat.toList()
    }


    override fun solve() {
        println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
        println(findRepeatedDnaSequences("AAAAAAAAAAAAA"))

    }
}