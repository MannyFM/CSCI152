/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Map.impl;

import ToolBox.ADTs.Map.Map;
import ToolBox.util.KeyValuePair;

/**
 *
 * @author manny
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

  private Node root;
  private int size;

  private class Node {

	private Node left, right, parent;
	private KeyValuePair<K, V> value;

	public Node(KeyValuePair<K, V> value) {
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

  public BSTMap() {
	root = null;
	size = 0;
  }
  
  @Override
  public void define(K key, V value) {
	KeyValuePair<K, V> kvp = new KeyValuePair<>(key, value);
	Node newNode = new Node(kvp);
	Node previous = null, tmp = root;
	while (tmp != null) {
	  previous = tmp;
	  int compareResult = key.compareTo(tmp.value.getKey());
	  if (compareResult == 0) {
		return;
	  }
	  if (compareResult < 0) {
		tmp = tmp.left;
	  } else {
		tmp = tmp.right;
	  }
	}
	size++;
	if (previous == null) {
	  //Tree is empty
	  root = newNode;
	  return;
	}
	if (key.compareTo(previous.value.getKey()) < 0) {
	  previous.left = newNode;
	  newNode.parent = previous;
	} else {
	  previous.right = newNode;
	  newNode.parent = previous;
	}
  }

  @Override
  public V getValue(K key) {
	Node node = find(key);
	if (node == null)
	  return null;
	return node.value.getValue();
  }

  @Override
  public V remove(K key) {
	Node node = find(key);
	if (node == null) {
	  return null;
	}
	removeHelper(node);
	size--;
	return node.value.getValue();
  }

  @Override
  public KeyValuePair<K, V> removeAny() throws Exception {
	if (root == null) {
	  if (size != 0) {
		throw new Exception("Something really bad happened");
	  }
	  throw new Exception("Set is empty");
	}
	KeyValuePair<K, V> kvp = root.value;
	remove(kvp.getKey());
	return kvp;
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
//	return "[" + (root == null ? "" : root) + "(" + size + ")]";
	return "[" + (root == null ? "" : root) + "]";
  }

  private Node find(K key) {
	Node cur = root;
	while (cur != null) {
	  int compareResult = key.compareTo(cur.value.getKey());
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
