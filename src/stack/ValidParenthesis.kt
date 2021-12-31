package stack

import Problem
import kotlin.collections.ArrayDeque

class ValidParenthesis: Problem {

    private companion object{
        private const val PAREN_OPEN1 = '('
        private const val PAREN_OPEN2 = '['
        private const val PAREN_OPEN3 = '{'
        private const val PAREN_CLOSED1 = ')'
        private const val PAREN_CLOSED2 = ']'
        private const val PAREN_CLOSED3 = '}'

    }

    private fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (ch in s.toCharArray()) {
           when(ch) {
               PAREN_OPEN1 -> stack.addLast(PAREN_CLOSED1)
               PAREN_OPEN2 -> stack.addLast(PAREN_CLOSED2)
               PAREN_OPEN3 -> stack.addLast(PAREN_CLOSED3)
               else -> {
                   if (stack.isEmpty()) return false
                   if (stack.removeLast() != ch) return false
               }
           }
        }
        if (stack.isNotEmpty()) return false
        return true
    }

    override fun solve() {
        println(isValid("()[]{}"))
        println(isValid("(]"))
    }
}