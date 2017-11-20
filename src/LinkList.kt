/**
 * Created by powel on 11/7/2017.
 */
class LinkList {

    var head:Link? = null
    var current = head
    var next = head?.next
    var last:Link? = null

    fun findEnd(link:Link):Link{

        var currentLink = link

        while (currentLink.next!=null) currentLink = currentLink.next!!
        return currentLink
    }

    fun findLink(lookupData: Any): Link?{

        if(!isEmpty()){
            while (current?.next != null){
                if (current != lookupData){
                    current = current?.next
                }else{
                    return null
                }
            }
        }

        return current!!
    }

    fun removeLink(removeData: Any): Link?{
        return null
    }

    fun isEmpty(): Boolean {
        return (head == null)
    }

    fun insertLink(data: Any){
        var newLink = Link(data)

        newLink.next = head

        head = newLink
    }

    fun removeLink(){
        var holdLink = head
        head = head?.next
        println(holdLink)
    }

}