/**
 * Created by powel on 11/7/2017.
 */
class Link(var data: Any, var next:Link? = null) {

    init {
        data = data
        next = null
    }

    fun display(){
        println("Data: $data")
    }

}