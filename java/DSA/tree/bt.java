
class TreeNode {
    int data;
    TreeNode left;;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class bt {

    public static int i = -1;

    public static TreeNode buildTree(int[] nums) {
        i++;

        if (i >= nums.length || nums[i] == -1)
            return null;

        TreeNode node = new TreeNode(nums[i]);

        node.left = buildTree(nums);
        node.right = buildTree(nums);

        return node;
    }
    
    public static void preorderTraversal(TreeNode root){
      
      if(root == null){
        System.out.print(-1+", ");
        return;
      }
      
      System.out.print(root.data+", ");
      
      preorderTraversal(root.left);
      preorderTraversal(root.right);
      
      return;
    }
    
    
    public static void inorderTraversal(TreeNode root){
      if(root == null){
        return;
      }
      
      inorderTraversal(root.left);
      System.out.print(root.data+", ");
      inorderTraversal(root.right);
      
      return;
    }
    public static void postorderTraversal(TreeNode root){
      if(root == null){
        return;
      }
      
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      System.out.print(root.data+", ");
      
      return;
    }
    

    public static void main(String args[]) {
        System.out.println("Welcome to Tree");

        int[] nums = { 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1 };

        TreeNode root = buildTree(nums);

        System.out.println(root.data + " " + root.left.data + " " + root.right.data);
        
        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }
}
