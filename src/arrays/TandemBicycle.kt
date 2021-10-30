package arrays

import Problem
import java.util.*
import kotlin.math.max

/*
* I am given two arrays of positive integers,
* one containing the speeds of riders with red shirts and another one containing the speeds of riders with blue shirt.
* The number of red-shirt riders and the number of blue-shirt riders are equal.
* I will also receive a third input parameter called fastest and it is going to be a Boolean value.
* I am asked to write a function that is going to pair every red-shirt rider with a blue-shirt rider
* to ride a tandem bicycle; and if the Boolean is true,
* the function will return the total maximum speed of all tandem bicycles being ridden;
* otherwise it will return the total minimum speed.
* A tandem bicycle is a bicycle operated by two people.
* The speed of the bicycle is dictated by the rider who pedals faster, for instance,
* if the speed of one rider is 5 and the speed of the other rider is 3, then the speed of the bicycle is 5.
*
* */
class TandemBicycle : Problem {

    private fun computeMaxSpeed(redArray: IntArray, blueArray: IntArray, fastest: Boolean): Int {
        if (fastest) blueArray.sortDescending()
        else blueArray.sort()
        redArray.sort()

        var speedSum = 0
        for (index in redArray.indices) {
            val redSpeed = redArray[index]
            val blueSpeed = blueArray[index]
            speedSum += max(redSpeed, blueSpeed)
        }
        return speedSum
    }

    override fun solve() {
        val blue = intArrayOf(8, 5, 3)
        val red = intArrayOf(7, 2, 4)
        println(computeMaxSpeed(red, blue, false))
        println(computeMaxSpeed(red, blue, true))
    }
}