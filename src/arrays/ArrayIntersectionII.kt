package arrays

import BaseProblem
import Problem

class ArrayIntersectionII: BaseProblem(), Problem {

    private fun arrayIntersection(nums1: IntArray, nums2: IntArray): IntArray {
        val map = hashMapOf<Int, Int>()
        val list = arrayListOf<Int>()

        for (x in nums1) {
            map[x] = map.getOrDefault(x, 0)+1
        }

        for (x in nums2) {
            if (map.containsKey(x) && map[x]!! > 0 ) {
                list.add(x)
                map[x] = map.getOrDefault(x, 0) - 1
            }
        }
        return list.toIntArray()
    }

    override fun solve() {
        val array = intArrayOf(4,9,5)
        val sequence = intArrayOf(9,4,9,8,4)
        printArray(arrayIntersection(array, sequence))
    }
}