package strings

import Problem


/*
*
* */
class LongestCommonPrefix : Problem {

    private fun longestCommonPrefix(input: Array<String>): String {
        if (input.isEmpty()) return ""
        val first = input[0]

            first.toCharArray().forEachIndexed { idx, ch ->
                for (i in 1 until input.size) {
                    if (input[i][idx] != ch || idx == input[i].length)
                        return first.substring(0, idx)
                }
            }
        return first

    }

    override fun solve() {
        println(
            longestCommonPrefix(
                arrayOf(
                    "flower",
                    "flow",
                    "flight"
                )
            )
        )
        println(
            longestCommonPrefix(
                arrayOf(
                    "dog",
                    "race",
                    "car"
                )
            )
        )
    }
}