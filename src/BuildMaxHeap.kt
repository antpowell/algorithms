/**
 * Created by powel on 11/21/2017.
 */

class BuildMaxHeap {

    init {
        var unsortedArray = IntArray()
    }

    private fun parent(index: Int) {
        return if ((Math.ceil(index / 2.0) - 1) < 0)
            0
        else
            (Math.ceil(index / 2.0) - 1)
    }

    private fun left(index: Int) {
        return if (((index * 2) + 1) != null)
            (index * 2) + 1
        else
            return
    }

    private fun left(index: Int) {
        return if (((index * 2) + 2) != null)
            (index * 2) + 2
        else
            return
    }

    private fun heapify(a: IntArray, index: Int) {
        var l = left(index)
        var r = right(index)
        var largest: Int

        if (l <= a.size && a[l] > a[index]) {
            largest = l
        } else largest = index

        if (r <= a.size && a[r] > a[largest]) {
            largest = r
        }
        if (largest != index) {
            var temp = a[index]
            a[index] = a[largest]
            a[largest] = temp
            heapify(a, largest)
        }
    }

    private fun buildHeap(array: IntArray) {
        var heapSize = array.size
        var i = Math.floor(array.size / 2.0)
        var sortedArray = IntArray()
        /**Inner nodes (non leaf nodes) should start at floor(n/2)*/
        while (i >= 0){
            sortedArray = heapify(array, i)
        }
        return sortedArray
    }

//    fun build(array: IntArray): IntArray {
//        while (position >= 0) {
//            parSortedArray = heapify()
//        }
//        return
//    }
}