package tasks

import java.util.Stack

fun isValidBrackets(brackets: String): Boolean {
    val stack: Stack<String> = Stack()
    val open = "([{<"
    val pairs: HashMap<String, String> = hashMapOf(
        ")" to "(",
        "}" to "{",
        "]" to "[",
        ">" to "<"
    )

    for (bracket in brackets.toList()) {

        if (open.contains(bracket)) {
            stack.push(bracket.toString())
        } else {
            //closing
            val value = pairs[bracket.toString()]
            if (value == stack.peek()) {
                stack.pop()
            } else {
                return false
            }
        }
    }

    return stack.isEmpty()
}

fun main() {
    val sequence1 = "{((())){{{}}}[][][]}"
    println(isValidBrackets(sequence1))
}
