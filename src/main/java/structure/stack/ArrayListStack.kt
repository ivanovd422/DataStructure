package structure.stack


class ArrayListStack<T> {

    private val stackList: ArrayList<T> = arrayListOf()


    fun push(element: T) {
        stackList.add(0, element)
    }

    fun pop(): T {
        return stackList.removeAt(0)
    }

    fun top(): T {
        return stackList[0]
    }

    fun isEmpty(): Boolean {
        return stackList.isEmpty()
    }
}


fun main() {

    val stack = ArrayListStack<String>()

    val firstElement = "first element"
    val secondElement = "second element"

    stack.push(firstElement)
    stack.push(secondElement)

    assert(stack.top() == secondElement)

    assert(stack.pop() == secondElement)
    assert(stack.pop() == firstElement)
    assert(stack.isEmpty())

}