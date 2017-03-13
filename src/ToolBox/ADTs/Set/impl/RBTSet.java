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
public class RBTSet<T extends Comparable<T>> implements Set<T> {

  private static final boolean RED = true;
  private static final boolean BLACK = true;
  private Node root;
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
	
  @Override
  public String toString() {
	String res = "";
	if (left != null)
	  res += left + ", ";
	res += value;
	if (right != null)
	  res += ", " + right;
	return res;
	}
  
  }

  public RBTSet() {
	root = null;
	size = 0;
  }

  Node getGrandparent(Node node) {
	if (node == null) {
	  return node;
	}
	Node batya = node.parent;
	if (batya == null) {
	  return null;
	}
	return batya.parent;
  }

  Node getUncle(Node node) {
	if (node == null) {
	  return node;
	}
	Node batya = node.parent;
	if (batya == null) {
	  return null;
	}
	Node grandbatya = batya.parent;
	if (grandbatya == null) {
	  return null;
	}
	if (grandbatya.left == batya) {
	  return grandbatya.right;
	} else {
	  return grandbatya.left;
	}
  }

  private void rotateLeft(Node tree) {
	Node pivot = tree.right;

	pivot.parent = tree.parent;
	if (tree.parent == null) {
	  root = pivot;
	} else {
	  if (tree.parent.left == tree) {
		tree.parent.left = pivot;
	  } else {
		tree.parent.right = pivot;
	  }
	}
	tree.right = pivot.left;
	if (pivot.left != null) {
	  pivot.left.parent = tree;
	}

	tree.parent = pivot;
	pivot.left = tree;
  }

  private void rotateRight(Node tree) {
	Node pivot = tree.left;

	pivot.parent = tree.parent;
	if (tree.parent == null) {
	  root = pivot;
	} else {
	  if (tree.parent.right == tree) {
		tree.parent.right = pivot;
	  } else {
		tree.parent.left = pivot;
	  }
	}
	tree.left = pivot.right;
	if (pivot.right != null) {
	  pivot.right.parent = tree;
	}

	tree.parent = pivot;
	pivot.right = tree;
  }

  private void add(Node tree, Node newNode) {
	if (tree == null) {
	  return;
	}
	if (tree.value.compareTo(newNode.value) > 0) {
	  if (tree.left == null) {
		tree.left = newNode;
		newNode.parent = tree;
	  } else {
		add(tree.left, newNode);
	  }
	} else {
	  if (tree.right == null) {
		tree.right = newNode;
		newNode.parent = tree;
	  } else {
		add(tree.right, newNode);
	  }
	}
  }

  private void insert_case1(Node node) {
	if (node.parent == null) {
	  node.color = BLACK;
	} else
	  insert_case2(node);
  }

  private void insert_case2(Node node) {
	if (node.parent.color == BLACK)
	  return;
	else
	  insert_case3(node);
  }

  private void insert_case3(Node node) {
	Node uncle, grandbatya, batya;
	uncle = getUncle(node);
	grandbatya = getGrandparent(node);
	batya = node.parent;
	
	if ((uncle != null) && (uncle.color == RED) && batya.color == RED) {
	  batya.color = BLACK;
	  uncle.color = BLACK;
	  grandbatya.color = RED;
	  insert_case1(grandbatya);
	} else 
	  insert_case4(node);
  }

  private void insert_case4(Node node) {
	Node grandbatya, batya;
	grandbatya = getGrandparent(node);
	batya = node.parent;
	if ((node == batya.right) && (batya == grandbatya.left)) {
	  rotateLeft(batya);
	  node = node.left;
	} else if ((node == batya.left) && (batya == grandbatya.right)) {
	  rotateRight(batya);
	  node = node.right;
	}
	insert_case5(node);
  }

  private void insert_case5(Node node) {
	Node grandbatya, batya;
	grandbatya = getGrandparent(node);
	batya = node.parent;
	
	batya.color = BLACK;
	grandbatya.color = RED;
	if ((node == batya.left) && (batya == grandbatya.left)) {
	  rotateLeft(grandbatya);
	} else {
	  rotateRight(grandbatya);
	}
  }

  private boolean contains(Node root, T value) {
	if (root == null) {
	  return false;
	}
	int cmp = root.value.compareTo(value);
	if (cmp == 0) {
	  return true;
	}
	if (cmp < 0) {
	  return contains(root.left, value);
	} else {
	  return contains(root.right, value);
	}
  }

  private String out(Node tree, int lvl) {
	String res = "";
	if (tree == null)
	  return res;
	for (int i = 0; i < lvl; i++)
	  res += " ";
	res += tree.value + "\n";
	if (tree.left != null) {
	  res += "l" + out(tree.left, lvl + 1);
	}
	if (tree.right != null) {
	  res += "r" + out(tree.right, lvl + 1);
	}
	return res;
  }

  @Override
  public void add(T value) {
	if (this.contains(value)) {
	  return;
	}
	size++;
	Node newNode = new Node(value);
	if (root == null) {
	  root = newNode;
	} else {
	  add(root, newNode);
	}
	insert_case1(newNode);
  }

  @Override
  public boolean contains(T value) {
	return contains(root, value);
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
	return this.size;
  }

  @Override
  public void clear() {
	root = null;
	size = 0;
  }

  @Override
  public String toString() {
//	return out(root, 0) + "[" + root + "]";
	return "[" + root + "]";
  }
}
