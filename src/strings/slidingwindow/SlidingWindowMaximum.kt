package strings.slidingwindow

import BaseProblem
import Problem
import java.util.Deque
import java.util.LinkedList

// Sliding Window
// https://leetcode.com/problems/sliding-window-maximum/description/

class SlidingWindowMaximum : Problem, BaseProblem() {

    private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val L = nums.size
        val resultMax = arrayListOf<Int>()

        val maxQueue = ArrayDeque<Int>()

        var i = 0
        var j = 0
        while (j < L) {
            // calculation

            // remove elements smaller than nums[j] because they are of no use to us
            while (maxQueue.isNotEmpty() && nums[j] > maxQueue.last()) {
                maxQueue.removeLast()
            }
            // now push nums[j] to queue
            maxQueue.add(nums[j])

            if (j - i + 1 == k) {
                resultMax.add(maxQueue.first())

                // slide the window
                // now i is not part of sliding window so remove this calculation
                // undo that calculation done above on line #24

                if (nums[i] == maxQueue.first()) {
                    // pop the element
                    maxQueue.removeFirst()
                }
                i++
            }
            j++
        }
        return resultMax.toIntArray()

    }

    override fun solve() {
        printArray(maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3))
        println()
        printArray(maxSlidingWindow(intArrayOf(1,3,1,2,0,5), 3))
    }
}