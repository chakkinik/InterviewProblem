package com.walmartlabs.dsround;

public class PrintBorderBinaryTree {

  static void printLeaves(TreeNode node) {
    if (node == null)
      return;

    printLeaves(node.left);
    // Print it if it is a leaf node
    if (node.left == null && node.right == null)
      System.out.print(node.data + " ");
    printLeaves(node.right);
  }

  // A function to print all left boundary nodes, except a leaf node.
  // Print the nodes in TOP DOWN manner
  static void printBoundaryLeft(TreeNode node) {
    if (node == null)
      return;

    if (node.left != null) {
      // to ensure top down order, print the node
      // before calling itself for left subtree
      System.out.print(node.data + " ");
      printBoundaryLeft(node.left);
    } else if (node.right != null) {
      System.out.print(node.data + " ");
      printBoundaryLeft(node.right);
    }

    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
  }

  // A function to print all right boundary nodes, except a leaf node
  // Print the nodes in BOTTOM UP manner
  static void printBoundaryRight(TreeNode node) {
    if (node == null)
      return;

    if (node.right != null) {
      // to ensure bottom up order, first call for right
      // subtree, then print this node
      printBoundaryRight(node.right);
      System.out.print(node.data + " ");
    } else if (node.left != null) {
      printBoundaryRight(node.left);
      System.out.print(node.data + " ");
    }
    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
  }

  // A function to do boundary traversal of a given binary tree
  static void printBoundary(TreeNode node) {
    if (node == null)
      return;

    System.out.print(node.data + " ");

    // Print the left boundary in top-down manner.
    printBoundaryLeft(node.left);

    // Print all leaf nodes
    printLeaves(node.left);
    printLeaves(node.right);

    // Print the right boundary in bottom-up manner
    printBoundaryRight(node.right);
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
    printBoundary(tree.root);
  }

}
