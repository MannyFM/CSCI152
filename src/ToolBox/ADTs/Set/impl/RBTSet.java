/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Set.impl;

import ToolBox.ADTs.Set.Set;

/**
 *
 * @author manny
 * @param <T>
 */
public class RBTSet<T extends Comparable<? super T>> implements Set<T> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private Node root;
  private Node nil;
  private int size;

  private class Node {

	private Node left, right, parent;
	private boolean color;
	private final T value;

	public Node(T value) {
	  this.left = nil;
	  this.right = nil;
	  this.parent = nil;
	  this.value = value;
	  this.color = RED;
	}

	public Node(T value, Node left, Node right, Node parent, boolean color) {
	  this.value = value;
	  this.left = left;
	  this.right = right;
	  this.parent = parent;
	  this.color = color;
	}

	@Override
	public String toString() {
	  String res = "";
	  if (left != nil) {
		res += left + ", ";
	  }
	  res += value;
	  if (right != nil) {
		res += ", " + right;
	  }
	  return res;
	}

  }

  public RBTSet() {
	//Nil Node initialize
	nil = new Node(null);
	nil.left = nil;
	nil.right = nil;
	nil.parent = nil;
	nil.color = BLACK;

	root = nil;
	size = 0;
  }

  @Override
  public void add(T value) {
	if (this.contains(value)) {
	  return;
	}
	size++;
	Node newNode = new Node(value);
	this.insert(newNode);
  }

  @Override
  public boolean contains(T value) {
	Node node = this.find(value);
	return node != nil;
  }

  @Override
  public boolean remove(T value) {
	Node node = find(value);
	if (node == nil)
	  return false;
	remove(node);
	return true;
  }

  @Override
  public T removeAny() throws Exception {
	if (size == 0) {
	  throw new Exception("Set is empty");
	}
	T result = root.value;
	remove(result);
	return result;
  }

  @Override
  public int getSize() {
	return this.size;
  }

  @Override
  public void clear() {
	root = nil;
	size = 0;
  }

  @Override
  public String toString() {
//	return out(root, 0) + "[" + root + "]";
	return "[" + root + "]";
  }

  private String out(Node tree, int lvl) {
	String res = "";
	if (tree == nil) {
	  return res;
	}
	for (int i = 0; i < lvl; i++) {
	  res += " ";
	}
	res += tree.value + "\n";
	if (tree.left != nil) {
	  res += "l" + out(tree.left, lvl + 1);
	}
	if (tree.right != nil) {
	  res += "r" + out(tree.right, lvl + 1);
	}
	return res;
  }
  
  public String out() {
	return out(root, 0);
  }

  private void rotateLeft(Node tree) {
	Node pivot = tree.right;
	tree.right = pivot.left;
	if (pivot.left != nil) {
	  pivot.left.parent = tree;
	}
	pivot.parent = tree.parent;
	if (tree.parent == nil) {
	  root = pivot;
	} else if (tree == tree.parent.left) {
	  tree.parent.left = pivot;
	} else {
	  tree.parent.right = pivot;
	}
	pivot.left = tree;
	tree.parent = pivot;
  }

  private void rotateRight(Node tree) {
	Node pivot = tree.left;
	tree.left = pivot.right;
	if (pivot.right != nil) {
	  pivot.right.parent = tree;
	}
	pivot.parent = tree.parent;
	if (tree.parent == nil) {
	  root = pivot;
	} else if (tree == tree.parent.right) {
	  tree.parent.right = pivot;
	} else {
	  tree.parent.left = pivot;
	}
	pivot.right = tree;
	tree.parent = pivot;
  }

  private void insert(Node newNode) {
	Node previous = nil;
	Node tmp = this.root;
	while (tmp != nil) {
	  previous = tmp;
	  if (newNode.value.compareTo(tmp.value) < 0) {
		tmp = tmp.left;
	  } else {
		tmp = tmp.right;
	  }
	}
	if (previous == nil) {
	  this.root = newNode;
	} else if (newNode.value.compareTo(previous.value) < 0) {
	  previous.left = newNode;
	} else {
	  previous.right = newNode;
	}
	newNode.left = nil;
	newNode.right = nil;
	newNode.color = RED;
	insertFix(newNode);
  }

  private void insertFix(Node node) {
	while (node.parent.color == RED) {
	  if (node.parent == node.parent.parent.left) {
		//Parent is left child
		Node uncle = node.parent.parent.right;
		if (uncle.color == RED) {
		  node.parent.color = BLACK;
		  uncle.color = BLACK;
		  node.parent.parent.color = RED;
		  node = node.parent.parent;
		} else {
		  if (node == node.parent.right) {
			node = node.parent;
			rotateLeft(node);
		  }
		  node.parent.color = BLACK;
		  node.parent.parent.color = RED;
		  rotateRight(node.parent.parent);
		}
	  } else {
		//Parent is right child
		Node uncle = node.parent.parent.left;
		if (uncle.color == RED) {
		  node.parent.color = BLACK;
		  uncle.color = BLACK;
		  node.parent.parent.color = RED;
		  node = node.parent.parent;
		} else {
		  if (node == node.parent.left) {
			node = node.parent;
			rotateRight(node);
		  }
		  node.parent.color = BLACK;
		  node.parent.parent.color = RED;
		  rotateLeft(node.parent.parent);
		}
	  }
	}
	this.root.color = BLACK;
  }

  private Node find(T value) {
	Node node = this.root;
	while (node != nil) {
	  int compareResult = value.compareTo(node.value);
	  if (compareResult == 0) {
		return node;
	  }
	  if (compareResult < 0) {
		node = node.left;
	  } else {
		node = node.right;
	  }
	}
	return nil;
  }

  /**
   * Negative value -> black height is bad non-negative -> OK
   */
  private int checkBlackHeight(Node node) {
	if (node == nil) {
	  return 1;
	}
	int left = checkBlackHeight(node.left);
	int right = checkBlackHeight(node.right);
	if (left < 0 || right < 0 || left != right) {
	  return -1;
	}
	if (node.color == BLACK) {
	  left++;
	} else {
	  if (node.parent.color == RED) {
		return -1;
	  }
	}
	return left;
  }

  public boolean isOk() {
	return checkBlackHeight(root) >= 0;
  }

  private void transplant(Node tree, Node newNode) {
	if (tree.parent == nil) {
	  //tree is root
	  root = newNode;
	} else {
	  if (tree.parent.left == tree) {
		tree.parent.left = newNode;
	  } else {
		tree.parent.right = newNode;
	  }
	}
	newNode.parent = tree.parent;
  }

  private void remove(Node tree) {
	if (tree == nil) {
	  return;
	}
	Node successor = tree;
	Node doubleSuccessor = nil;
	boolean successorColor = successor.color;
	if (tree.left == nil) {
	  doubleSuccessor = tree.right;
	  transplant(tree, tree.right);
	} else if (tree.right == nil) {
	  doubleSuccessor = tree.left;
	  transplant(tree, tree.left);
	} else {
	  successor = getMinimum(tree.right);
	  successorColor = successor.color;
	  doubleSuccessor = successor.right;
	  if (successor.parent == tree) {
		doubleSuccessor.parent = successor;
	  } else {
		transplant(successor, successor.right);
		successor.right = tree.right;
		successor.right.parent = successor;
	  }
	  transplant(tree, successor);
	  successor.left = tree.left;
	  successor.left.parent = tree;
	  successor.color = tree.color;
	}
	if (successorColor == BLACK)
	  deleteFix(doubleSuccessor);
  }

  private void deleteFix(Node tree) {
	throw new UnsupportedOperationException("Not supported yet.");
  }
  
  private Node getMinimum(Node tree) {
	while (tree.left != nil) {
	  tree = tree.left;
	}
	return tree;
  }
}
