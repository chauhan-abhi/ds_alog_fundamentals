package arrays.medium

import Problem

/*
* https://leetcode.com/problems/permutations/
* */
class Permutations: Problem {

    private fun permute(input: IntArray): List<List<Int>>  {
        val result = ArrayList<ArrayList<Int>>()
        val visited = BooleanArray(input.size)
        permuteHelper(arrayListOf(), visited, result ,input)
        return result
    }

    private fun permuteHelper(path: ArrayList<Int>, visited: BooleanArray, result: ArrayList<ArrayList<Int>>, input: IntArray) {
        if (path.size == visited.size) {
            result.add(ArrayList(path))
            return
        }
        for (i in visited.indices) {
            if (visited[i]) continue

            path.add(input[i])
            visited[i] = true
            permuteHelper(path, visited, result, input)
            path.removeAt(path.size-1)
            visited[i] = false
        }
    }

    override fun solve() {
        val input = intArrayOf(1,2,3)
        val res = permute(input)
        for (x in res)
            println("$x, ")
    }
}