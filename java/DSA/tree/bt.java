
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

    public static void main(String args[]) {
        System.out.println("Welcome to Tree");

        int[] nums = { 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1 };

        TreeNode root = buildTree(nums);

        System.out.println(root.data + " " + root.left.data + " " + root.right.data);
    }
}
