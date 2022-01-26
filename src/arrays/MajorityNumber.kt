package arrays

import Problem

class MajorityNumber: Problem {

    private fun majorityElement(nums: IntArray): Int {
        val hm = hashMapOf<Int, Int>()
        val mx = (nums.size.floorDiv(2))
        for (element in nums) {
            hm[element] = hm.getOrDefault(element, 0) +1
            if (hm.containsKey(element) && hm[element]!! > mx)
                return element
        }
        return 0
    }

    override fun solve() {
        println(majorityElement(intArrayOf(3,2,3)))
        println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
    }
}