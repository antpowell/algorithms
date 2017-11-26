/**
 * Created by powel on 11/21/2017.
 */


/**
* This class should take an array as its only argument.
* That array will be passed by value, so the results will
* be stored inside the variable passed into this class.
**/
class BuildMaxHeap(private var unsortedArray: IntArray) {

    private var largest = 0
    private var heapSize: Int = unsortedArray.size - 1

    init {
        heapSort()
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

    private fun heapSort(): IntArray {
        buildHeap()
        var i = unsortedArray.size - 1
        while (i >= 1) {

            var temp = unsortedArray[0]
            unsortedArray[0] = unsortedArray[i]
            unsortedArray[i] = temp
            heapSize--
            heapify(0)
            i--
        }
        return unsortedArray
    }

    private fun buildHeap() {

        var i = Math.floor(unsortedArray.size / 2.0).toInt()

        while (i >= 0) {
            heapify(i)
            i--
        }

    }

    private fun heapify(index: Int) {
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
            heapify(largest)
        }
        println(unsortedArray.toList().toString())
    }

}

fun main(args: Array<String>) {

    /*Array of 25 element starting at 25 down to 1*/
    var list = IntArray(25) /*Use this section to change array size if needed*/
    list = IntRange(1, 25).reversed().toList().toIntArray() /*Use this section to change the range of the array defined above*/
    /*End of array with 25 elements*/

    /*Array with random numbers*/
    var largerList = intArrayOf(934, 592, 575, 760, 627, 991, 635, 854, 117, 260, 508, 47, 409, 559, 40, 945,
            446, 995, 31, 837, 68, 93, 939, 386, 453, 594, 778, 444, 333, 584, 612, 318, 458, 97, 488) /*Enter n random numbers into this array*/
    /*End of array with random numbers*/


    BuildMaxHeap(largerList)
    println("Should now be sorted: ${largerList.toList()}")
}