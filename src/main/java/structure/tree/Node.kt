package structure.tree

class Node {
    var key = 0
    var data: String? = null
    var leftChild: Node? = null
    var rightChild: Node? = null

    fun printNode() {
        println("KEY $key DATA: $data")
    }
}