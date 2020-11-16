package com.walmartlabs.dsround;

public class PrintLeftViewTree {
  TreeNode root;

  public static void main(String[] args) {

    PrintLeftViewTree tree = new PrintLeftViewTree();
    tree.root = new TreeNode(1);
    tree.root.left = new TreeNode(2);
    tree.root.right = new TreeNode(3);
    tree.root.left.right = new TreeNode(4);
    tree.root.left.right.right = new TreeNode(5);
    tree.root.left.right.right.right = new TreeNode(6);

    System.out.println(tree.root.data);
    tree.leftView(tree.root);
  }

  private void leftView(TreeNode root) {

    if (root == null) {
      return;
    }
    if (root.left != null)
      System.out.println(root.left.data);
    else if (root.left == null && root.right != null) {
      System.out.println(root.right.data);
    }

    leftView(root.left);
    leftView(root.right);
    

  }

}
