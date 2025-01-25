package graph

import DFS

class NumberOfIslands : DFS {

    private fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        if (grid.isEmpty()) return 0


        // find '1' in grid
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == '1') {
                    islandCount++
                    dfs(i, j, grid)
                }
            }
        }
        return islandCount
    }

    private fun dfs(i: Int, j: Int, grid: Array<CharArray>) {
        // This condition ensures that the function doesn't explore cells that are either water ('0') or already visited (*).
        if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] != '1') return

        // mark visited
        grid[i][j] = '*'

        dfs(i - 1, j, grid)
        dfs(i, j - 1, grid)
        dfs(i + 1, j, grid)
        dfs(i, j + 1, grid)
    }


    override fun solve() {
        val charArray = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )
        println(numIslands(charArray))

    }
    
}