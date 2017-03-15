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
 */
public class BSTSet<T extends Comparable<? super T>> implements Set<T> {

  private Node root;
  private int size;

  private class Node {

	private Node left, right, parent;
	private T value;

	public Node(T value) {
	  this.left = null;
	  this.right = null;
	  this.parent = null;
	  this.value = value;
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

  @Override
  public void add(T value) {
	Node newNode = new Node(value);
	Node previous = null, tmp = root;
	while (tmp != null) {
	  previous = tmp;
	  int compareResult = value.compareTo(tmp.value);
	  if (compareResult == 0) {
		return;
	  }
	  if (compareResult < 0) {
		tmp = tmp.left;
	  } else {
		tmp = tmp.right;
	  }
	}
	if (previous == null) {
	  //Tree is empty
	  root = newNode;
	  return;
	}
	if (value.compareTo(previous.value) < 0) {
	  previous.left = newNode;
	  newNode.parent = previous;
	  size++;
	} else {
	  previous.right = newNode;
	  newNode.parent = previous;
	  size++;
	}
  }

  @Override
  public boolean contains(T value) {
	Node node = find(value);
	return node != null;
  }

  @Override
  public boolean remove(T value) {
	Node node = find(value);
	if (node == null) {
	  return false;
	}
	removeHelper(node);
	return true;
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
	return "[" + (root == null ? " " : root) + "]";
  }

  private Node find(T value) {
	Node cur = root;
	while (cur != null) {
	  int compareResult = value.compareTo(cur.value);
	  if (compareResult == 0) {
		return cur;
	  }
	  if (compareResult < 0) {
		cur = cur.left;
	  } else {
		cur = cur.right;
	  }
	}
	return null;
  }

  private void removeHelper(Node node) {
	if (node == null) {
	  return;
	}
	if (node.left == null && node.right == null) {
	  //No children
	  if (node.parent == null) {
		root = null;
	  } else {
		if (node.parent.left == node) {
		  node.parent.left = null;
		} else {
		  node.parent.right = null;
		}
	  }
	  return;
	}
	if (node.left == null) {
	  node.right.parent = node.parent;
	  if (node.parent == null) {
		root = node.right;
	  } else {
		if (node.parent.left == node) {
		  node.parent.left = node.right;
		} else {
		  node.parent.right = node.right;
		}
	  }
	  return;
	}
	if (node.right == null) {
	  node.left.parent = node.left;
	  if (node.parent == null) {
		root = node.left;
	  } else {
		if (node.parent.left == node) {
		  node.parent.left = node.left;
		} else {
		  node.parent.right = node.left;
		}
	  }
	  return;
	}
	Node newNode = node;
	while (newNode.left != null) {
	  newNode = newNode.left;
	}
	node.value = newNode.value;
	removeHelper(newNode);
  }
}
