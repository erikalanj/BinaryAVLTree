package hw5part1;
import java.util.Random;
class AVLNode {

  int value;

  AVLNode left, right;

  AVLNode(int item) {

    value = item;

    left = right = null;

  }
}
public class task2 {

  AVLNode root;

  task2() {

    root = null;

  }

  boolean search(AVLNode root, int key) {

    if (root == null) {

      return false;

    }

    if (root.value == key) {

      return true;

    }

    if (key < root.value) {

      return search(root.left, key);

    } else {

      return search(root.right, key);

    }

  }

  AVLNode insert(AVLNode node, int value) {

    if (node == null) {

      return new AVLNode(value);

    }

    if (value < node.value) {

      node.left = insert(node.left, value);

    } else if (value > node.value) {

      node.right = insert(node.right, value);

    } else {

      return node;

    }

    return balance(node);

  }

  AVLNode balance(AVLNode node) {

    int balance = getBalance(node);

    // Left Heavy

    if (balance > 1) {

      if (getBalance(node.left) < 0) {

        System.out.println("Double left-right rotation at node: " + node.value);

        node.left = leftRotate(node.left);

      }

      System.out.println("Right rotation at node: " + node.value);

      return rightRotate(node);

    }

    // Right Heavy

    if (balance < -1) {

      if (getBalance(node.right) > 0) {

        System.out.println("Double right-left rotation at node: " + node.value);

        node.right = rightRotate(node.right);

      }

      System.out.println("Left rotation at node: " + node.value);

      return leftRotate(node);

    }

    return node;

  }

  int getBalance(AVLNode node) {

    if (node == null) {

      return 0;

    }

    return height(node.left) - height(node.right);

  }

  int height(AVLNode node) {

    if (node == null) {

      return -1;

    }

    return Math.max(height(node.left), height(node.right)) + 1;

  }

  AVLNode rightRotate(AVLNode y) {

    AVLNode x = y.left;

    AVLNode T2 = x.right;

    x.right = y;

    y.left = T2;

    return x;

  }

  AVLNode leftRotate(AVLNode x) {

    AVLNode y = x.right;

    AVLNode T2 = y.left;

    y.left = x;

    x.right = T2;

    return y;

  }

  void printTree(AVLNode root, int height) {

    if (root != null) {

      printTree(root.right, height + 1);

      System.out.println(root.value);

      printTree(root.left, height + 1);

    }

  }

  AVLNode deleteRoot(AVLNode root) {

    if (root == null) {

      return null;

    }

    if (root.left == null) {

      return root.right;

    }

    if (root.right == null) {

      return root.left;

    }

    AVLNode successor = getSuccessor(root.right);

    root.value = successor.value;

    root.right = deleteNode(root.right, successor.value);

    return balance(root);

  }

  AVLNode deleteNode(AVLNode root, int key) {

    if (root == null) {

      return root;

    }

    if (key < root.value) {

      root.left = deleteNode(root.left, key);

    } else if (key > root.value) {

      root.right = deleteNode(root.right, key);

    } else {

      return deleteRoot(root);

    }

    return balance(root);

  }

  AVLNode getSuccessor(AVLNode node) {

    while (node.left != null) {

      node = node.left;

    }

    return node;

  }

  private int checkBalance(AVLNode node) throws Exception {

    if (node == null) return -1;

    int leftHeight = checkBalance(node.left);

    int rightHeight = checkBalance(node.right);

    if (Math.abs(leftHeight - rightHeight) > 1 || height(node.left) != leftHeight || height(node.right) != rightHeight) {

      throw new Exception("Unbalanced tree detected.");

    }

    return height(node);

  }

  public static void main(String[] args) {

    task2 tree = new task2();

    Random rand = new Random();

    try {

      for (int i = 0; i < 35; i++) {

        int value = rand.nextInt((99 - 10) + 1) + 10;

        System.out.println("Inserting: " + value);

        tree.root = tree.insert(tree.root, value);

        System.out.println("Tree after insertion:");

        tree.printTree(tree.root, 0);

        tree.checkBalance(tree.root);

        System.out.println();

      }

      System.out.println("\nDeletion Process:");

      while (tree.root != null) {

        System.out.println("Deleting root " + tree.root.value + ":");

        tree.root = tree.deleteRoot(tree.root);

        if (tree.root != null) {

          System.out.println("Resulting tree:");

          tree.printTree(tree.root, 0);

          tree.checkBalance(tree.root);

        } else {

          System.out.println("Tree is empty now.");

        }

        System.out.println();

      }

    } catch (Exception e) {

      System.out.println("Error: " + e.getMessage());

    }

  }
}
