package hw4;
import java.util.*;
class hw4BST {
  class BSTNode {
    String data;
    BSTNode left;
    BSTNode right;
    public BSTNode(String data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
  private static BSTNode root;
  public void instantiate() {
    root = null;
  }
  public boolean isEmpty() {
    return root == null;
  }
  public void makeEmpty() {
    root = null;
  }
  public void put(String data) {
    root = recursput(root, data);
  }
  private BSTNode recursput(BSTNode node, String data) {
    if (node == null) {
      return new BSTNode(data);
    }
    if (data.compareTo(node.data) < 0) {
      node.left = recursput(node.left, data);
    } else if (data.compareTo(node.data) > 0) {
      node.right = recursput(node.right, data);
    }
    return node;
  }
  public boolean contains(String data) {
    return recurscontains(root, data);
  }
  private boolean recurscontains(BSTNode node, String data) {
    if (node == null) {
      return false;
    }
    if (data.equals(node.data)) {
      return true;
    } else if (data.compareTo(node.data) < 0) {
      return recurscontains(node.left, data);
    } else {
      return recurscontains(node.right, data);
    }
  }
  public void delete(String data) {
    root = recursdelete(root, data);
  }
  private BSTNode recursdelete(BSTNode node, String data) {
    if (node == null) {
      return null;
    }
    if (data.compareTo(node.data) < 0) {
      node.left = recursdelete(node.left, data);
    } else if (data.compareTo(node.data) > 0) {
      node.right = recursdelete(node.right, data);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      }
      node.data = minValue(node.right);
      node.right = recursdelete(node.right, node.data);
    }
    return node;
  }
  private String minValue(BSTNode node) {
    String min = node.data;
    while (node.left != null) {
      min = node.left.data;
      node = node.left;
    }
    return min;
  }
  public void inOrder(Queue < String > result) {
    in(root, result);
  }
  private void in (BSTNode node, Queue < String > result) {
    if (node != null) {
      in(node.left, result);
      result.add(node.data);
      in(node.right, result);
    }
  }
  public void preOrder(Queue < String > result) {
    pre(root, result);
  }
  private void pre(BSTNode node, Queue < String > result) {
    if (node != null) {
      result.add(node.data);
      pre(node.left, result);
      pre(node.right, result);
    }
  }
  public void postOrder(Queue < String > result) {
    post(root, result);
  }
  private void post(BSTNode node, Queue < String > result) {
    if (node != null) {
      post(node.left, result);
      post(node.right, result);
      result.add(node.data);
    }
  }

  TEST CASES:

    For some reason my traversals were not working correctly, but were still producing unique results every traversal.Every other method was working fine though.
  Main:
    public static void main(String[] args) {
      hw4BST bst = new hw4BST();
      Queue < String > result = new LinkedList < String > ();
      bst.instantiate();

      bst.put("24");
      bst.put("5");
      bst.put("6");
      bst.put("4");
      bst.put("3");
      bst.put("0");

      System.out.println("empty? " + bst.isEmpty());

      System.out.println("in order");
      bst.inOrder(result);
      System.out.println(result);

      result.clear();
      System.out.println("pre order");
      bst.preOrder(result);
      System.out.println(result);

      result.clear();
      System.out.println("post order");
      bst.postOrder(result);
      System.out.println(result);

      System.out.println("is 5 there?" + bst.contains("5"));
      System.out.println("is 100000 there? " + bst.contains("100000"));

      bst.delete("0");

      result.clear();
      System.out.println("pre order after deleting 0:");
      bst.preOrder(result);
      System.out.println(result);

      bst.makeEmpty();

      System.out.println("is bst empty" + bst.isEmpty());

    }
