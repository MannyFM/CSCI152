/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Deque.impl;

import ToolBox.ADTs.Deque.Deque;
import ToolBox.util.DLLNode;

/**
 *
 * @author manny
 * @param <T>
 */
public class DLLDeque<T> implements Deque<T> {

  private DLLNode<T> head, tail;
  private int size;

  public DLLDeque() {
	head = tail = null;
	size = 0;
  }

  @Override
  public void pushToFront(T value) {
	DLLNode<T> newNode = new DLLNode(value);
	if (size == 0) {
	  head = tail = newNode;
	} else {
	  head.setPrevious(newNode);
	  newNode.setNext(head);
	  head = newNode;
	}
	size++;
  }

  @Override
  public void pushToBack(T value) {
	DLLNode<T> newNode = new DLLNode(value);
	if (size == 0) {
	  head = tail = newNode;
	} else {
	  tail.setNext(newNode);
	  newNode.setPrevious(tail);
	  tail = newNode;
	}
	size++;
  }

  @Override
  public T popFromFront() throws Exception {
	if (size == 0) {
	  throw new Exception("Deque is empty");
	}

	T result = head.getValue();
	size--;
	if (size == 0) {
	  head = tail = null;
	} else {
	  head = head.getNext();
	  head.setPrevious(null);
	}
	return result;
  }

  @Override
  public T popFromBack() throws Exception {
	if (size == 0) {
	  throw new Exception("Deque is empty");
	}

	T result = tail.getValue();
	size--;
	if (size == 0) {
	  head = tail = null;
	} else {
	  tail = tail.getPrevious();
	  tail.setNext(null);
	}
	return result;
  }

  @Override
  public int getSize() {
	return this.size;
  }

  @Override
  public void clear() {
	head = tail = null;
	size = 0;
  }

  @Override
  public String toString() {
	String res = "";
	DLLNode tmp = head;
	while (tmp != null) {
	  res += tmp;
	  if (tmp.getNext() != null)
		res += ", ";
	  tmp = tmp.getNext();
	}
	return "[" + res + "]";
  }
}
