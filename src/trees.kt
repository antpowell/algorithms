/**
 * Created by powel on 10/15/2017.
 */
class Node constructor(data: Int){
    var data = data
    abstract var left: Node
    abstract var right: Node

    fun insert(value: Int){
        if(value >= data){
            if(right == null){
                right = Node(value)
            }else{
                right.insert(value)
            }
        }else{
            if(value <= data){
                if(left == null){
                    left = new Node(value)
                }else{
                    left.insert(value)
                }
            }
        }
    }


}