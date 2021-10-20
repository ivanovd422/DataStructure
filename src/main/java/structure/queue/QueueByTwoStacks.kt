package structure.queue

import java.util.Stack

/**
 * Custom Queue implementation with two stacks.
 */
class QueueByTwoStacks<T> {
    private val inbox: Stack<T> = Stack()
    private val outbox: Stack<T> = Stack()

    /**
     * Put item in the end of queue
     */
    fun enqueue(item: T) {
        inbox.push(item)
    }

    /**
     * Return item from queue
     */
    fun dequeue(): T {
        if (outbox.isEmpty()) {
            while (inbox.isEmpty().not()) {
                outbox.push(inbox.pop())
            }
        }

        return outbox.pop()
    }

    fun isEmpty(): Boolean {
        return inbox.isEmpty() && outbox.isEmpty()
    }

    fun size(): Int {
        return inbox.size + outbox.size
    }
}


fun main() {
    val elements = listOf("one", "two", "free", "four", "five", "six", "seven")
    val customQueue = QueueByTwoStacks<String>()

    println("----------Inserting----------")

    for (element in elements) {
        customQueue.enqueue(element)
        println("add $element to queue")
    }

    println("queue size - ${customQueue.size()}")

    println("----------Extracting----------")

    while (customQueue.isEmpty().not()) {
        val element = customQueue.dequeue()
        println("extract $element from queue")
    }
}