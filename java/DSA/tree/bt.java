
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

    // leavel build
    public static TreeNode buildTreeLevelorder(int[] nums) {
        Deque<TreeNode> que = new LinkedList<>();

        int j = 0;

        TreeNode root = new TreeNode(nums[j++]);
        que.add(root);

        while (!que.isEmpty()) {

            TreeNode curr = que.remove();

            if (j < nums.length) {
                if (nums[j] == -1) {
                    curr.left = null;
                    j++;
                } else {
                    curr.left = new TreeNode(nums[j++]);
                    que.add(curr.left);
                }
            }

            if (j < nums.length) {
                if (nums[j] == -1) {
                    curr.right = null;
                    j++;
                } else {
                    curr.right = new TreeNode(nums[j++]);
                    que.add(curr.right);
                }
            }

        }

        return root;
    }

    // Preorder + In order building tree
    static int pre = -1;

    private static TreeNode buildTreePreeIn(int[] preorder, int[] inorder, int st, int end) {
        if (st > end)
            return null;

        int currVal = preorder[++pre];
        TreeNode node = new TreeNode(currVal);

        int pos = st;
        for (int i = st; i <= end; i++) {
            if (inorder[i] == currVal) {
                pos = i;
                break;
            }
        }

        node.left = buildTreePreeIn(preorder, inorder, st, pos - 1);
        node.right = buildTreePreeIn(preorder, inorder, pos + 1, end);

        return node;
    }

    // Inorf=der + Postorder tree build
    static int post;

    private static TreeNode buildTreeInPost(int[] inorder, int[] postorder, int st, int end) {
        if (st > end)
            return null;

        int rootVal = postorder[--post];
        TreeNode root = new TreeNode(rootVal);

        int pos = st;
        for (int i = st; i <= end; i++) {
            if (inorder[i] == rootVal) {
                pos = i;
                break;
            }
        }

        root.right = buildTreeInPost(inorder, postorder, pos + 1, end);
        root.left = buildTreeInPost(inorder, postorder, st, pos - 1);

        return root;
    }


    private static void preorderIter(TreeNode root){

        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode node = s.pop();
            System.out.print(node.data+" ");
            
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        System.out.println();
    }

    private static void inorderIter(TreeNode root){
        Deque<TreeNode> s = new ArrayDeque<>();

        TreeNode curr = root;

        while(curr != null || !s.isEmpty()){

            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
        System.out.println();
    }


    private static void postorderIter(TreeNode root){
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();

        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode node = s1.pop();

            if(node.left != null) s1.push(node.left);
            if(node.right != null) s1.push(node.right);

            s2.push(node);
        }

        while(!s2.isEmpty()) System.out.print(s2.pop().data+" ");
        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println("Welcome to Tree");

        // int[] nums = { 1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        // int[] inorder = { -1, 2, -1, 1, -1, 4, -1, 3, -1, 5, -1, };
        // int[] postorder = { -1, -1, 2, -1, -1, 4, -1, -1, 5, 3, 1, };
        // int[] levelorder = { 1, 2, 3, -1, -1, 4, 5 };

        // TreeNode root = buildTree(nums);
        // TreeNode root = buildTreeLevelorder(levelorder);

        int[] preorder = { 1, 2, 3, 4, 5 };
        int[] inorder = { 2, 1, 4, 3, 5 };
        int[] postorder = { 2, 4, 5, 3, 1 };
        int[] levelorder = { 1, 2, 3, 4, 5 };

        // TreeNode root = buildTreePreeIn(preorder, inorder, 0, preorder.length - 1);
        post = inorder.length;
        TreeNode root = buildTreeInPost(inorder, postorder, 0, inorder.length - 1);

        System.out.println(root.data + " " + root.left.data + " " + root.right.data);

        // Recursive methods
        // preorderTraversal(root);
        // System.out.println();
        // inorderTraversal(root);
        // System.out.println();
        // postorderTraversal(root);
        // System.out.println();
        // leavelorderTraversal(root);





        // Itterative method
        preorderIter(root);
        inorderIter(root);
        postorderIter(root);
    }
}
