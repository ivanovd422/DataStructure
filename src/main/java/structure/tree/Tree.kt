package structure.tree

class Tree {

    var root: Node? = null

    /**
     * Find element by key
     */
    fun find(key: Int): Node? {
        var current = root
        while (current!!.key != key) {
            current = if (current.key < key) {
                current.leftChild
            } else {
                current.rightChild
            }
            if (current == null) {
                return null
            }
        }
        return current
    }

    /**
     * add element by ket with data
     */
    fun insert(key: Int, data: String?) {
        val node = Node()
        node.key = key
        node.data = data
        if (root == null) {
            root = node
        } else {
            var current = root
            var prev: Node? = null
            while (true) {
                prev = current
                if (key < prev!!.key) {
                    current = current!!.leftChild
                    if (current == null) {
                        prev.leftChild = node
                        return
                    }
                } else {
                    current = current!!.rightChild
                    if (current == null) {
                        prev.rightChild = node
                        return
                    }
                }
            }
        }
    }


    fun print(startNode: Node?) {
        if (startNode != null) {
            print(startNode.leftChild)
            startNode.printNode()
            print(startNode.rightChild)
        }
    }
}