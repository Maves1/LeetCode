package T200;

import java.util.*;

public class T104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();

        if (root == null) return zigzag;

        Deque<TreeNode> currQueue = new LinkedList<>();
        Deque<TreeNode> nextQueue = new LinkedList<>();

        int index = 0;

        nextQueue.addFirst(root);

        while (!nextQueue.isEmpty()) {
            currQueue = nextQueue;
            nextQueue = new LinkedList<>();

            zigzag.add(new ArrayList<>());

            while (!currQueue.isEmpty()) {
                TreeNode currNode;

                if (index % 2 == 0) {
                    currNode = currQueue.pollFirst();

                    if (currNode.left != null) nextQueue.add(currNode.left);
                    if (currNode.right != null) nextQueue.add(currNode.right);
                } else {
                    currNode = currQueue.pollLast();

                    if (currNode.right != null) nextQueue.addFirst(currNode.right);
                    if (currNode.left != null) nextQueue.addFirst(currNode.left);
                }

                zigzag.get(index).add(currNode.val);
            }

            index++;
        }

        return zigzag;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = zigzagLevelOrder(null);
    }
}
