/**
 * Created by powel on 11/21/2017.
 */

class BuildMaxHeap(var unsortedArray: IntArray) {

    private var largest = 0
    private var heapSize: Int = unsortedArray.size - 1

    init {
        print(heapSort(unsortedArray).toList().toString())
    }

    private fun parent(index: Int): Int {
        return if ((Math.ceil(index / 2.0) - 1) < 0)
            0
        else
            (Math.ceil(index / 2.0) - 1).toInt()
    }

    private fun left(index: Int): Int {
        return if (((index * 2) + 1) <= heapSize)
            (index * 2) + 1
        else
            return index
    }

    private fun right(index: Int): Int {
        return if (((index * 2) + 2) <= heapSize)
            (index * 2) + 2
        else
            return index
    }

    fun heapSort(a: IntArray): IntArray {
        buildHeap(unsortedArray)
        var i = unsortedArray.size - 1
        while (i >= 1) {

            var temp = unsortedArray[0]
            unsortedArray[0] = unsortedArray[i]
            unsortedArray[i] = temp
            heapSize--
            heapify(unsortedArray, 0)
            i--
        }
        return unsortedArray
    }

    private fun buildHeap(a: IntArray) {

        var i = Math.floor(unsortedArray.size / 2.0).toInt()

        while (i >= 0) {
            heapify(unsortedArray, i)
            i--
        }

    }

    private fun heapify(a: IntArray, index: Int) {
        var l = left(index)
        var r = right(index)

        if (l <= heapSize && unsortedArray[l] > unsortedArray[index])
            largest = l
        else largest = index
        if (r <= heapSize && unsortedArray[r] > unsortedArray[largest]) largest = r
        if (largest != index) {
            var temp = unsortedArray[index]
            unsortedArray[index] = unsortedArray[largest]
            unsortedArray[largest] = temp
            heapify(unsortedArray, largest)
        }
    }

}

fun main(args: Array<String>) {
    var list = IntArray(25)
    list = IntRange(1, 25).toList().toIntArray()

    var buildHeap = BuildMaxHeap(list)
}