package com.lucaslucenak;


import java.util.LinkedList;
import java.util.Queue;

/**
 * This problem was asked by Google.
 *
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 */

class TreeNode {

    String val;
    TreeNode left;
    TreeNode right;

    TreeNode(String val) {
        this.val = val;
    }

}

public class Day3 {
    // Serialize a binary tree to a string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Deserialize a string to a binary tree
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String val : values) {
            queue.offer(val);
        }
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("root");
        root.left = new TreeNode("left");
        root.left.left = new TreeNode("left.left");
        root.right = new TreeNode("right");

        Day3 serializer = new Day3();
        String serialized = serializer.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = serializer.deserialize(serialized);
        System.out.println("Deserialized: " + serializer.serialize(deserialized));
    }
}
