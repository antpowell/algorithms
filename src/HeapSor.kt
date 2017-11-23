/**
 * Created by powel on 11/7/2017.
 */
class HeapSort() {
//    var temp: Int = 0

    /*Both left and right subtrees must be
    * sorted*/
//    var parent = (index - 2) / 2
//    var leftChild = (index * 2) + 1e
//    var rightChild = (index * 2) + 2

    data class Tree(var parent: Int, var leftChild: Int, var rightChild: Int) {

        fun siftDown() {
            while (parent < leftChild || parent < rightChild)
                if (leftChild > parent && rightChild > parent) {
                    if (leftChild > rightChild) {
                        var temp = parent
                        parent = leftChild
                        leftChild = temp
                    } else {
                        var temp = parent
                        parent = rightChild
                        rightChild = temp
                    }
                } else if (leftChild > parent) {
                    var temp = parent
                    parent = leftChild
                    leftChild = temp
                } else if (rightChild > parent) {
                    var temp = parent
                    parent = rightChild
                    rightChild = temp
                }
        }


    }

    private fun parent(i: Int): Int {

        return if ((Math.ceil((i.toDouble() / 2.0)) - 1) < 0) {
            0
        } else {
            (Math.ceil((i.toDouble() / 2.0)) - 1).toInt()
        }

    }

    private fun swapLeft(parentIndex: Int, leftIndex: Int) {

    }

    private fun siftDown(a: IntArray, parentIndex: Int) {

        var parentIndex = parentIndex
        var returnArray = a
        val leftChild = (parentIndex * 2) + 1
        val rightChild = (parentIndex * 2) + 2

        if (leftChild < a.lastIndex && rightChild < a.lastIndex) {
            if (a[parentIndex] < a[leftChild] || a[parentIndex] < a[rightChild]) {
                if (a[parentIndex] < a[leftChild]) {
                    var temp = a[parentIndex]
                    a[parentIndex] = a[leftChild]
                    a[leftChild] = temp
                    parentIndex = leftChild
                    siftDown(returnArray, parentIndex)
                } else {
                    var temp = a[parentIndex]
                    a[parentIndex] = a[rightChild]
                    a[rightChild] = temp
                    parentIndex = rightChild
                    siftDown(returnArray, parentIndex)
                }
            }
        } else if (leftChild < a.lastIndex) {
            if (a[parentIndex] < a[leftChild]) {
                var temp = a[parentIndex]
                a[parentIndex] = a[leftChild]
                a[leftChild] = temp
                parentIndex = leftChild
                siftDown(returnArray, parentIndex)
            }

        } else if (rightChild < a.lastIndex) {

        }
    }

    private fun siftParentFromChild(a: IntArray, parentIndex: Int, leftIndex: Int, rightIndex: Int): IntArray {
        var returnArray = a
        if (returnArray[leftIndex] > returnArray[parentIndex] && returnArray[rightIndex] > returnArray[parentIndex]) {
            if (returnArray[leftIndex] > returnArray[rightIndex]) {
                var temp = returnArray[parentIndex]
                returnArray[parentIndex] = returnArray[leftIndex]
                returnArray[leftIndex] = temp
            } else {
                var temp = returnArray[parent(rightIndex)]
                returnArray[parent(rightIndex)] = returnArray[rightIndex]
                returnArray[rightIndex] = temp
            }
        } else {
            returnArray = siftParentFromLeftChild(a, parentIndex, leftIndex)
            returnArray = siftParentFromRightChild(a, parentIndex, rightIndex)
        }
        return returnArray
    }

    private fun siftParentFromParent(a: IntArray, parentIndex: Int): IntArray {
        var returnArray = a
        val leftChildIndex = 2 * parentIndex + 1
        val rightChildIndex = 2 * parentIndex + 2

        if (leftChildIndex < returnArray.lastIndex && rightChildIndex < returnArray.lastIndex) {
            if (returnArray[leftChildIndex] > returnArray[parentIndex] &&
                    returnArray[rightChildIndex] > returnArray[parentIndex]) {
                if (returnArray[leftChildIndex] > returnArray[rightChildIndex]) {
                    var temp = returnArray[parentIndex]
                    returnArray[parentIndex] = returnArray[leftChildIndex]
                    returnArray[leftChildIndex] = temp
                } else {
                    returnArray[parentIndex] = returnArray[rightChildIndex]
                }
            }
        } else if (leftChildIndex < returnArray.lastIndex) {
            if (returnArray[leftChildIndex] > returnArray[parentIndex]) {
                var temp = returnArray[parentIndex]
                returnArray[parentIndex] = returnArray[leftChildIndex]
                returnArray[leftChildIndex] = temp
            }
        } else if (rightChildIndex < returnArray.lastIndex) {
            if (returnArray[rightChildIndex] >= returnArray[parentIndex]) {
                var temp = returnArray[parentIndex]
                returnArray[parentIndex] = returnArray[rightChildIndex]
                returnArray[leftChildIndex] = temp
            }
        }
        return returnArray
    }

    private fun siftParentFromLeftChild(a: IntArray, parentIndex: Int, leftIndex: Int): IntArray {
        if (a[leftIndex] > a[parentIndex]) {
            var temp = a[parentIndex]
            a[parentIndex] = a[leftIndex]
            a[leftIndex] = temp
        }
        return a
    }

    private fun siftParentFromRightChild(a: IntArray, parentIndex: Int, rightIndex: Int): IntArray {
        if (a[rightIndex] > a[parentIndex]) {
            var temp = a[parentIndex]
            a[parentIndex] = a[rightIndex]
            a[rightIndex] = temp
        }
        return a
    }

    fun sort(arr: IntArray) {
        //Start from the bottom until tree is sorted
        var index = arr.lastIndex
        var sortedArray: IntArray = arr

        while (sortedArray[index] > sortedArray[parent(index)]) {

            while (index > 0) {
                println(sortedArray.toList().toString())
                sortedArray = siftParentFromParent(sortedArray, index)
                if (parent(index) == parent(index - 1)) {
                    sortedArray = siftParentFromChild(arr, parent(index), index - 1, index)
//                    print("Index: $index, value: ${sortedArray[index]} ---> Parent: ${parent(index)}, value: ${sortedArray[parent(index)]}\n")
                    index -= 2
                } else {
                    siftParentFromLeftChild(sortedArray, parent(index), index)
                    siftParentFromRightChild(sortedArray, parent(index), index)
                    index--
                }

            }
        }
        println(sortedArray.toList().toString())
    }

}


fun main(args: Array<String>) {
    println(Math.floor(Math.log(25.00) / Math.log(2.0)))
    var list = IntArray(25)
    list = IntRange(1, 25).toList().toIntArray()
//    var heap = HeapSort().sort(list)
//    var maxHeap = BuildMaxHeap().buildHea (list)

}