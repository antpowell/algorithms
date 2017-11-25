/**
 * Created by powel on 10/15/2017.
 */
public class trees {
 class Node {

  Node left, right;
  int data;

  public Node(int data) {
   this.data = data;
  }

  public void insert(int value) {
   if (value >= data) {
    if (right == null) {
     right = new Node(value);
    }else{
     right.insert(value);
    }
   }else{
     if(left == null){
      left = new Node(value);
     }else{
      left.insert(value);
    }
   }
  }

  public boolean contains(int value){
   if(value == data){
    return true;
   }else if(value >= data ){
    if(right == null){
     return false;
    }else{
     return right.contains(value);
    }
   }else{
    if(left == null){
     return false;
    }else{
     left.contains(value);
    }
   }
   return true;
  }

/**
 *
 * In-Order Traversal
 *
 * */
  public void printInOrder(){
   if(left != null){
    left.printInOrder();
   }
   System.out.printf("%d\n", data);
   if(right!= null){
    right.printInOrder();
   }
  }

  /**
   *
   * Pre-Order Traversal
   *
   * */
  public void printPreOrder(){
   System.out.printf("%d\n", data);
   if(left != null){
    left.printPreOrder();
   }
   if(right!=null){
    right.printPreOrder();
   }
  }

  /**
   *
   * Post-Order Traversal
   *
   * */
  public void printPostOrder(){
   if(right != null){
    right.printPostOrder();
   }
   if(left != null){
    left.printPostOrder();
   }
   System.out.printf("%d\n",data);
  }

 }

}
