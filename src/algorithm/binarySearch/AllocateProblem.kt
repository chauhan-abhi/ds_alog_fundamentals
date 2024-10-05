package algorithm.binarySearch

import Problem

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
class AllocateProblem: Problem {
    override fun solve() {
        println(shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5))
        println(shipWithinDays(intArrayOf(3, 2, 2, 4, 1, 4), 3))
        println(shipWithinDays(intArrayOf(1, 2, 3, 1, 1), 4))
        println(minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
        println(minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
        println(minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))
    }

    private fun shipWithinDays(weights: IntArray, days: Int): Int {
        var start = Int.MIN_VALUE
        var end = 0
        for (weight in weights) {
            end += weight
            start = Math.max(weight, start)
        }

        while(start <= end) {
            val mid = start + (end-start)/2

            if(possible(weights, mid, days)) {
                end = mid -1
            } else {
                start = mid + 1
            }
        }
        return start
    }

    private fun possible(weights: IntArray, capacity: Int, days: Int): Boolean {
        var k = 1
        var sum = 0
        for (i in weights) {
            sum += i
            if (sum > capacity) {
                k++
                sum = i
            }
        }
        return k <= days
    }

    private fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var start = piles.min()
        var end = piles.max()

        while (start <= end) {
            val mid = start + (end - start) / 2

            if (canEatInTime(piles, mid, h)) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return start
    }

    private fun canEatInTime(piles: IntArray, mid: Int, h: Int): Boolean {
        var hours = 0.0
        for (pile in piles) {
            hours += Math.ceil(pile * 1.0 / mid)
            if (hours > h) return false
        }
        return true
    }
}