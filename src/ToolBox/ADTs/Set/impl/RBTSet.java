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
  private static final boolean BLACK = true;
  private Node root;
  private Node nil;
  private int size;

  private class Node {

	private Node left, right, parent;
	private boolean color;
	private T value;

	public Node(T value) {
	  this.left = null;
	  this.right = null;
	  this.parent = null;
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
	  if (left != null) {
		res += left + ", ";
	  }
	  res += value;
	  if (right != null) {
		res += ", " + right;
	  }
	  return res;
	}

  }

  public RBTSet() {
	//Nil Node initialize
	nil = new Node(null, nil, nil, nil, BLACK);

	root = nil;
	size = 0;
  }

  @Override
  public void add(T value) {
	throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean contains(T value) {
	throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean remove(T value) {
	throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public T removeAny() throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public int getSize() {
	throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void clear() {
	throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String toString() {
//	return out(root, 0) + "[" + root + "]";
	return "[" + root + "]";
  }

  private String out(Node tree, int lvl) {
	String res = "";
	if (tree == null) {
	  return res;
	}
	for (int i = 0; i < lvl; i++) {
	  res += " ";
	}
	res += tree.value + "\n";
	if (tree.left != null) {
	  res += "l" + out(tree.left, lvl + 1);
	}
	if (tree.right != null) {
	  res += "r" + out(tree.right, lvl + 1);
	}
	return res;
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

}
