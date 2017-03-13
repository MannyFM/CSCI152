/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Set.impl;

import ToolBox.ADTs.Queue.Queue;
import ToolBox.ADTs.Queue.impl.LinkedListQueue;
import ToolBox.ADTs.Set.Set;

/**
 *
 * @author manny
 * @param <T>
 */
public class LLQueueSet<T extends Comparable<? super T>> implements Set<T> {

  Queue<T> queue;

  LLQueueSet() {
	queue = new LinkedListQueue<>();
  }

  @Override
  public void add(T value) {
	if (this.contains(value)) {
	  return;
	}
	queue.enqueue(value);
  }

  @Override
  public boolean contains(T value) {
	try {
	  for (int i = 0; i < queue.getSize(); i++) {
		T val = queue.dequeue();
		queue.enqueue(val);
		if (val.equals(value)) {
		  return true;
		}
	  }
	} catch (Exception ex) {
	  System.out.print("<---------------------->");
	  System.out.print(ex);
	}
	return false;
  }

  @Override
  public boolean remove(T value) {
	try {
	  for (int i = 0; i < queue.getSize(); i++) {
		T val = queue.dequeue();
		if (val.equals(value)) {
		  return true;
		} else {
		  queue.enqueue(val);
		}
	  }
	} catch (Exception ex) {
	  System.out.print("<---------------------->");
	  System.out.print(ex);
	}
	return false;
  }

  @Override
  public T removeAny() throws Exception {
	try {
	  return queue.dequeue();
	} catch (Exception ex) {
		throw new Exception("Set is empty");
	}
  }

  @Override
  public int getSize() {
	return this.queue.getSize();
  }

  @Override
  public void clear() {
	queue.clear();
  }

  @Override
  public String toString() {
	return queue + "";
  }
}
