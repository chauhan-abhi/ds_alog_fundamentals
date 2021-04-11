package arrays

class ValidSubsequence {

    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        val size = sequence.size
        var idx = 0
        for (element in array) {
            if (idx == size) return true
            if (element == sequence[idx]) idx++
        }
        return idx == size
    }
}