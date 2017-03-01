/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Queue.impl;

import ToolBox.ADTs.Queue.Queue;

/**
 *
 * @author manny
 */
public class ArrayQueue<T> implements Queue<T>{

  private T[] values;
  private int front, size;

  public ArrayQueue() {
	values = (T[]) new Object[10];
	front = size = 0;
  }

  @Override
  public void enqueue(T value) {
	if (this.size >= values.length) {
	  T[] newValues = (T[]) new Object[2 * values.length];
	  for (int i = 0; i < size; i++) {
		newValues[i] = values[(front + i) % values.length];
	  }
	  front = 0;
	  values = newValues;
	}
	values[(front + size) % values.length] = value;
	size++;
  }

  @Override
  public T dequeue() throws Exception {
	if (size <= 0) {
	  throw new Exception("Queue is empty");
	}
	T result = values[front];
	values[front] = null;
	front = (front + 1) % values.length;
	size--;
	return result;
  }

  @Override
  public int getSize() {
	return this.size;
  }

  @Override
  public void clear() {
	for (int i = 0; i < size; i++) {
	  values[(front + i) % values.length] = null;
	}
	front = 0;
	size = 0;
  }

  @Override
  public String toString() {
	String res = "";
	for (int i = 0; i < size; i++) {
	  if (i > 0)
		res += ", ";
	  res += values[(front + i) % values.length];
	}
	return "[" + res + "]";
  }

}
