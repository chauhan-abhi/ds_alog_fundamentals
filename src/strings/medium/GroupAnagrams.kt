package strings.medium

import Problem


/*
* https://leetcode.com/problems/group-anagrams/
* */
class GroupAnagrams : Problem {

    private fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val hm  = hashMapOf<String, ArrayList<String>>()

        for (x in strs) {

            // sort x
            val charArr = x.toCharArray()
            charArr.sort()
            val sorted = String(charArr)
            if (hm.containsKey(sorted)) {
               hm[sorted]?.add(x)
            } else {
                // first time
                val list= arrayListOf<String>()
                list.add(x)
                hm[sorted] = list
            }
        }
        return hm.values.toList()
    }

    override fun solve() {
        println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
        println(groupAnagrams(arrayOf("")))
        println(groupAnagrams(arrayOf("a")))

    }
}