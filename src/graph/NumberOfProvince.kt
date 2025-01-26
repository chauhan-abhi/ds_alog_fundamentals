package graph

import DFS

class NumberOfProvince : DFS {

    private fun findCircleNumRecursive(isConnected: Array<IntArray>): Int {
        var circles = 0
        if (isConnected.isEmpty()) return 0

        val visited = BooleanArray(isConnected.size)
        for (i in isConnected.indices) {
            if (!visited[i]) {
                circles++
                dfs(isConnected, visited, i)
            }

        }
        return circles
    }

    private fun dfs(isConnected: Array<IntArray>, visited: BooleanArray, node: Int) {
        // i is the representation of city
        visited[node] = true

        for (neighbour in isConnected.indices) {
            // focus here on isConnected[node][neighbour] where node index is the one that helps us traverse down in graph
            if (visited[neighbour].not() && isConnected[node][neighbour] == 1) {
                dfs(isConnected, visited, neighbour)
            }
        }

    }

    private fun findCircleNum(isConnected: Array<IntArray>): Int {
        var circles = 0
        if (isConnected.isEmpty()) return 0

        val stack = ArrayDeque<Int>()
        val visited = BooleanArray(isConnected.size)

        for (i in isConnected.indices) {
            if (visited[i].not()) {
                circles++

                // push to stack : add city to stack
                stack.addLast(i)


                // DFS magic : { push to stack - pop top - retrieve neighbours - repeat first 3 steps for each unvisited neighbour until stack empty }

                while (stack.isNotEmpty()) {
                    val current = stack.last()
                    stack.removeLast()
                    visited[current] = true

                    // visit neighbours
                    for (j in 0 until isConnected[current].size) {
                        if (visited[j].not() && isConnected[current][j] == 1) {
                            stack.addLast(j)
                        }
                    }
                }
            }
        }
        return circles
    }


    override fun solve() {
        val province = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        )
        println(findCircleNum(province))
        println(findCircleNumRecursive(province))
    }
}