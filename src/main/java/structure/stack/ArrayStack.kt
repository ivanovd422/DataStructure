package structure.stack

import java.lang.Exception

class ArrayStack<T>(private val size: Int) {

    private val array: Array<T?> = Array<Any?>(size) { null } as Array<T?>
    private var position: Int = 0

    fun push(element: T) {
        if (position < size) {
            array[position++] = element
        } else {
            throw Exception("Stack is full!")
        }
    }

    fun pop(): T {
        if (position > 0) {
            return array[--position]!!
        } else {
            throw Exception("Stack is empty!")
        }
    }

    fun top(): T {
        if (position > 0) {
            return array[position]!!
        } else {
            throw Exception("Stack is empty!")
        }
    }

    fun isEmpty(): Boolean {
        return position == 0
    }
}


fun main() {
    val elements = listOf("one", "two", "free", "four", "five", "six", "seven")
    val size = elements.size

    val arrayStack = ArrayStack<String>(size)
    println("is empty - " + arrayStack.isEmpty())

    for (element in elements) {
        println("add - $element")
        arrayStack.push(element)
    }

    println("is empty - " + arrayStack.isEmpty())

    for (i in 0 until size) {
        println("take - ${arrayStack.pop()}")
    }

    println("is empty - " + arrayStack.isEmpty())
}