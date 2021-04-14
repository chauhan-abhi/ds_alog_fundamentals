package arrays

class TwoSun {

    fun twoSum(list: List<Int>, sum: Int): List<Int> {
        var diff: Int
        val map = HashSet<Int>()
        for(element in list) {
            diff = sum - element
            if(map.contains(diff)) return listOf(element, diff)
            else map.add(element)
        }
        return listOf()
    }
}