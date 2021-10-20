package structure.heap

class Heap(private val maxSize: Int) {

    private val heapArray: Array<Node?> = arrayOfNulls(maxSize)
    private var currentSize = 0

    fun printHeap() {
        println("elements: ")

        for (n in 0 until currentSize) {
            if (heapArray[n] != null) {
                println(heapArray[n]?.value.toString() + " ")
            } else {
                println("-")
            }
        }

        println()
        var countOfGaps = 32
        var itemsPerRow = 1
        var columnNumber = 0
        val lines = "___________________________________________________________________"
        println(lines)
        for (i in 0 until currentSize) {
            if (columnNumber == 0) {
                for (k in 0 until countOfGaps) {
                    print(' ')
                }
            }
            print(heapArray[i]?.value)
            if (++columnNumber == itemsPerRow) {
                countOfGaps /= 2
                itemsPerRow *= 2
                columnNumber = 0
                println()
            } else {
                for (k in 0 until countOfGaps * 2 - 2) {
                    print(' ')
                }
            }
        }
        println(
            """
                
                $lines
                """.trimIndent()
        )
    }

    /**
     * add new element
     */
    fun insertNode(value: Int): Boolean {
        if (currentSize == maxSize) {
            return false
        }
        val newNode = Node(value)
        heapArray[currentSize] = newNode
        displaceUp(currentSize++)
        return true
    }

    fun removeNode(index: Int): Node? {
        if (index in 1 until currentSize) {
            val root = heapArray[index]
            heapArray[index] = heapArray[--currentSize]
            heapArray[currentSize] = null
            displaceDown(index)
            return root
        }
        return null
    }

    fun changeNode(index: Int, newValue: Int): Boolean {
        if (index < 0 || currentSize <= index) {
            return false
        }
        val oldValue = heapArray[index]!!.value
        if (oldValue == newValue) {
            return true
        }

        heapArray[index]!!.value = newValue
        if (oldValue < newValue) {
            displaceUp(index)
        } else {
            displaceDown(index)
        }
        return true
    }

    private fun displaceUp(indexElement: Int) {
        var index = indexElement
        var parentIndex = (index - 1) / 2
        val bottom = heapArray[index]
        while (index > 0 && heapArray[parentIndex]!!.value < bottom!!.value) {
            heapArray[index] = heapArray[parentIndex]
            index = parentIndex
            parentIndex = (parentIndex - 1) / 2
        }
        heapArray[index] = bottom
    }

    private fun displaceDown(indexElement: Int) {
        var index = indexElement
        var largerChild: Int
        val top = heapArray[index]
        while (index < currentSize / 2) {
            val leftChild = 2 * index + 1
            val rightChild = leftChild + 1
            largerChild =
                if (rightChild < currentSize && heapArray[leftChild]!!.value < heapArray[rightChild]!!.value) {
                    rightChild
                }
                else {
                    leftChild
                }
            if (top!!.value >= heapArray[largerChild]!!.value) {

                break
            }
            heapArray[index] = heapArray[largerChild]
            index = largerChild
        }
        heapArray[index] = top
    }
}