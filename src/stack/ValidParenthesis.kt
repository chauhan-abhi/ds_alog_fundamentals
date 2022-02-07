package stack

import Problem
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet

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

    private fun minRemoveToMakeValid(s: String): String {
        val stack = Stack<Int>()
        val set = HashSet<Int>()

        for (i in s.toCharArray().indices) {
            if (s[i] == '(') stack.push(i)
            else if (s[i] == ')') {
                if (stack.isEmpty()) set.add(i)
                else stack.pop()
            }
        }
        set.addAll(stack)
        val sb = StringBuilder()
        for (i in s.toCharArray().indices) {
            if (!set.contains(i)) sb.append(s[i])
        }
        return sb.toString()
    }

    override fun solve() {
        //println(isValid("()[]{}"))
        //println(isValid("(]"))
        println(minRemoveToMakeValid("a)b(c)d"))
        println(minRemoveToMakeValid("))(("))
        println(minRemoveToMakeValid("lee(t(c)o)de)"))
    }
}