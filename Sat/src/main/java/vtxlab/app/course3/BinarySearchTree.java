package vtxlab.app.course3;


class TreeNode{
  private int value;
  private TreeNode left;
  private TreeNode right;

  public TreeNode(int value){
    this.value = value;
    this.left = null;
    this.right =null;
  }

  public int getValue(TreeNode value){
    return this.value;
  }

  public TreeNode getLeft(TreeNode left){
    return this.left;
  }

  public TreeNode getRight(TreeNode right){
    return this.right;
  }

}


public class BinarySearchTree {
  

  // public static TreeNode addRecursive(TreeNode current,int value){
  //   if(current== null){
  //     return new TreeNode(value);
  //   }

  //   if(value < current.){
  //     current.left = addRecursive(current.left, value);
  //   } else if (value > current.value){
  //     current.right = addRecursive(current.right, value);
  //   }else {
  //     return current;
  //   }
  // return current;
  // }
  public static void main(String[] args) {


    TreeNode t1 = new TreeNode(8);
    
  }


}


