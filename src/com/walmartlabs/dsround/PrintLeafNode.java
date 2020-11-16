package com.walmartlabs.dsround;

public class PrintLeafNode {
  TreeNode root;

  void printLeaf(TreeNode root) {

    if (root == null) {
      return;
    }
    if (root != null && root.left == null && root.right == null) {
      System.out.println(root.data);
    }
    printLeaf(root.left);
    printLeaf(root.right);

  }

  public static void main(String[] args) {
    PrintLeafNode tree = new PrintLeafNode();
    tree.root = new TreeNode(1);
    tree.root.left = new TreeNode(2);
    tree.root.right = new TreeNode(3);
    tree.root.left.right = new TreeNode(4);
    tree.root.left.right.right = new TreeNode(5);
    tree.root.left.right.right.right = new TreeNode(6);

    // System.out.println(tree.root.data);
    tree.printLeaf(tree.root);
  }

}
