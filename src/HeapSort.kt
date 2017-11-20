/**
 * Created by powel on 11/7/2017.
 */
class HeapSort() {
//    var temp: Int = 0

    /*Both left and right subtrees must be
    * sorted*/
//    var parent = (index - 2) / 2
//    var leftChild = (index * 2) + 1
//    var rightChild = (index * 2) + 2
    private fun parent(i: Int): Int {

        return if ((Math.ceil((i.toDouble() / 2.0)) - 1) < 0) {
            0
        } else {
            (Math.ceil((i.toDouble() / 2.0)) - 1).toInt()
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
        }else if (leftChildIndex < returnArray.lastIndex){
                if (returnArray[leftChildIndex] > returnArray[parentIndex]) {
                    var temp = returnArray[parentIndex]
                    returnArray[parentIndex] = returnArray[leftChildIndex]
                    returnArray[leftChildIndex] = temp
                }
        }else if (rightChildIndex < returnArray.lastIndex){
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
    var heap = HeapSort().sort(list)

}