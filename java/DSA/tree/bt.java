
import java.util.*;

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

    public static void preorderTraversal(TreeNode root) {

        if (root == null) {
            System.out.print(-1 + ", ");
            return;
        }

        System.out.print(root.data + ", ");

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + ", ");
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + ", ");
        inorderTraversal(root.right);

        return;
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + ", ");
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + ", ");

        return;
    }

    public static void leavelorderTraversal(TreeNode root) {

        Deque<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);

        while (!que.isEmpty()) {

            TreeNode node = que.remove();
            if (node == null) {
                System.out.println();

                if (que.isEmpty())
                    break;

                que.add(null);
            } else {

                System.out.print(node.data + ", ");

                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);
            }

        }
    }

    // Inorder build
    public static TreeNode buildTreeLevelorder(int[] nums) {

        if()

        TreeNode node = new TreeNode();

        node.left = buildTreeInOrder(nums);
    }

    public static void main(String args[]) {
        System.out.println("Welcome to Tree");

        int[] nums = { 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        int[] inorder = { -1, 2, -1, 1, -1, 4, -1, 3, -1, 5, -1, };
        int[] postorder = { -1, -1, 2, -1, -1, 4, -1, -1, 5, 3, 1, };
        int[] levelorder = {1, 2, 3, -1, -1, 4, }

        // TreeNode root = buildTree(nums);
        TreeNode root = buildTreeInOrder(nums);

        System.out.println(root.data + " " + root.left.data + " " + root.right.data);

        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
        System.out.println();
        leavelorderTraversal(root);
    }
}
