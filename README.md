# BinaryAVLTree
This is a compilation of two different implementations of extremely important data structs, the BST and the AVL Tree. Below is the following functionality of the BST:
- BinarySearchTree Class (10 Points):
  - Develop a `BinarySearchTree` class encapsulating the `BSTNode` inner class.
  - Implement foundational methods: `isEmpty()` to check if the tree is empty and `makeEmpty()` to clear the tree.

- Core Functionalities (30 Points):
  - `put(String s)`: Implement this method to insert a new string into the BST. Ensure that the tree maintains its BST properties post-insertion.
  - `contains(String s)`: Develop a method to verify whether a particular string exists within the tree, leveraging the tree's structure for efficient searching.

- Deletion Mechanism (35 Points):
  - `delete(String s)`: Craft a method to remove a specified string from the BST, adjusting the tree's structure to fill any gaps left by the removed node while maintaining BST properties.

- Traversal Methods (25 Points):
- 
  - Implement `inOrder()`, `preOrder()`, and `postOrder()` traversal methods. Each should return a `MyQueue` object containing the tree's elements in the respective order, showcasing different perspectives of the tree's structure.

And this is the functionality of the AVL tree: 

1. Construct an AVL Tree: Gradually create an AVL tree by inserting 35 unique random integers ranging from 10 to 99. After each insertion, print the tree to confirm it remains balanced.

2. Rebalancing Feedback: Whenever a rebalancing is performed, print a message specifying the type of rotation used and the pivotal node involved. For example, "Double left-right rotation: 76."

3. Root Deletion: Similar to the BST, repeatedly delete the root from your AVL tree and print the tree post-deletion to verify balance maintenance. Continue until no nodes remain.
