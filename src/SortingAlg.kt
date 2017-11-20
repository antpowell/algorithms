import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by powel on 11/5/2017.
 */


class QuickSort(a: Array<Int>, max:Int, min: Int) {

    private val random = Random()
    //choose random index
    // if index > random index move right
    // if index < random index more left
    var pivotIndex = random.nextInt(a.size + 1)


    fun pivotOperation(a: Array<Int>, pIndex: Int): IntArray {
        var left = 0
        var right = a.size - 1
        var emptySpot = 0
        var newPivotArray = IntArray(a.size)
        for (index in a) {
            if (pIndex == a[index]) {
                emptySpot = index
                continue
            } else if (a[pIndex] > a[index]){
                newPivotArray[left] = a[index]
                left ++
            } else if (a[pIndex] < a[index]){
                newPivotArray[right] = a[index]
                right --
            }
        }
        newPivotArray[right]  = a[emptySpot]
        return newPivotArray
    }

//    fun find

    fun print() {

    }
}

fun printHeapFromArray(array: Array<Int>){
    /*Base Case
    * Array is empty
    * */
    var index: Int = 0

    for (element in array){
        print("| $element ")
    }
    println("|\n\n")

//    while(index <= array.size-1){
//        println("          | parent: ${array[index]} |")
//
//        if(index*2+1 > array.size-1){
//            print("| leftChild: empty |")
//        }else{
//            print("| leftChild: ${array[(index * 2 )+1]} |")
//        }
//        if(index*2+2 > array.size-1){
//            print("| rightChild: empty |")
//        }else{
//            print("| rightChild: ${array[(index * 2 )+2]} |")
//        }
//
//        println("")
//
//        index ++
//    }

    /*Get left side
    * child = array[parent*2+1]*/

    var parent = 0
    var leftChild = "|"
    while(parent <= array.size -1){
        leftChild += "\n"
        print("|leftChild: ${array[parent]}")
//        println("| ${array[parent]} |")
        parent = parent*2+1
    }

}


fun main(args: Array<String>) {
    var myArray = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14)

    printHeapFromArray(array = myArray)

}