package graph

import Problem
import java.util.*
import kotlin.collections.HashSet

//https://leetcode.com/problems/keys-and-rooms/
class KeysAndRoom: Problem {
    override fun solve() {
        val listFalse = arrayListOf(listOf(1,3), listOf(3,0,1), listOf(1), listOf(0))
        val listTrue = arrayListOf(listOf(1), listOf(2), listOf(3), listOf())
         println(canVisitAllRooms(listFalse))
         println(canVisitAllRooms(listTrue))
    }

    private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = HashSet<Int>()
        visited.add(0)
        val stack = Stack<Int>()
        stack.add(0)
        while (!stack.isEmpty()) {
            val keyList = rooms[stack.pop()]
            for (key in keyList)  {
                if (!visited.contains(key)) {
                    visited.add(key)
                    stack.add(key)
                }
                if (visited.size == rooms.size) return true
            }
        }
        return visited.size == rooms.size
    }
}