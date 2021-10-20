package structure.heap

fun main() {
    val heap = Heap(31)

    heap.insertNode(120)
    heap.insertNode(40)
    heap.insertNode(50)
    heap.insertNode(80)
    heap.insertNode(20)
    heap.insertNode(100)
    heap.insertNode(150)
    heap.insertNode(30)
    heap.insertNode(210)
    heap.insertNode(180)
    heap.insertNode(10)
    heap.insertNode(90)

    heap.printHeap()
}