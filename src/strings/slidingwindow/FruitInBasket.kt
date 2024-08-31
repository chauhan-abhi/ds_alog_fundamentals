package strings.slidingwindow

import Problem
import kotlin.math.max

class FruitInBasket : Problem {

    private fun totalFruit(fruits: IntArray): Int {
        val L = fruits.size
        if (L == 1) return 1
        val hm = HashMap<Int, Int>()
        var i = 0
        var j = 0

        var result = 0
        while (j < L) {

            hm[fruits[j]] = hm.getOrDefault(fruits[j], 0) + 1

            if (hm.size <= 2) {
                result = max(result, hm.values.sum())
            } else {
                hm[fruits[i]] = hm.getOrDefault(fruits[i], 0) - 1
                if (hm[fruits[i]] == 0) {
                    hm.remove(fruits[i])
                }
                i++
            }
            j++
        }
        return result
    }


    override fun solve() {
        println(totalFruit(intArrayOf(1, 2, 1)))
        println(totalFruit(intArrayOf(0, 1, 2, 2)))
        println(totalFruit(intArrayOf(1, 2, 3, 2, 2)))
        println(totalFruit(intArrayOf(1, 1)))
    }
}