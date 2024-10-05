package arrays.medium

import Problem

/*
* https://leetcode.com/problems/permutations-ii/description/
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
            path.removeAt(path.size - 1)
            visited[i] = false
        }
    }

    private fun permuteWithBackTracking(input: IntArray): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        helper(input, 0, result)
        return result
    }

    private fun helper(input: IntArray, start: Int, result: ArrayList<ArrayList<Int>>) {
        if (start == input.size - 1) {
            result.add(input.toCollection(ArrayList()))
            return
        }
        val map = hashSetOf<Int>()
        for (i in start until input.size) {
            if (!map.contains(input[i])) {
                // controlled recursion
                map.add(input[i])
                swap(input, start, i)
                helper(input, start + 1, result)
                swap(input, start, i)
            }
        }
    }

    private fun swap(input: IntArray, i: Int, j: Int) {
        val temp = input[i]
        input[i] = input[j]
        input[j] = temp
    }

    override fun solve() {
        val input = intArrayOf(1, 1, 2)
        //val res = permute(input)
        val res = permuteWithBackTracking(input)
        for (x in res)
            println("$x, ")
    }
}