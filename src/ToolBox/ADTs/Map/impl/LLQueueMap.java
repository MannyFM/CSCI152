/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Map.impl;

import ToolBox.ADTs.Map.Map;
import ToolBox.util.KeyValuePair;
import ToolBox.ADTs.Queue.impl.LinkedListQueue;

/**
 *
 */
public class LLQueueMap<K, V> implements Map<K, V> {

  private final LinkedListQueue<KeyValuePair<K, V>> queue;

  public LLQueueMap() {
	queue = new LinkedListQueue<>();
  }

  @Override
  public void define(K key, V value) {
	try {
	  for (int i = 0; i < queue.getSize(); i++) {
		KeyValuePair<K, V> tmp = queue.dequeue();
		queue.enqueue(tmp);
		if (tmp.getKey().equals(key)) {
		  tmp.setValue(value);
		  return;
		}
	  }
	} catch (Exception ex) {
	  System.out.println("Something really bad happened " + ex);
	}
	KeyValuePair<K, V> newVal = new KeyValuePair(key, value);
	queue.enqueue(newVal);
  }

  @Override
  public V getValue(K key) {
	try {
	  for (int i = 0; i < queue.getSize(); i++) {
		KeyValuePair<K, V> tmp = queue.dequeue();
		queue.enqueue(tmp);
		if (tmp.getKey().equals(key)) {
		  return tmp.getValue();
		}
	  }
	} catch (Exception ex) {
	  System.out.println("Something really bad happened " + ex);
	}
	return null;
  }

  @Override
  public V remove(K key) {
	try {
	  for (int i = 0; i < queue.getSize(); i++) {
		KeyValuePair<K, V> tmp = queue.dequeue();
		if (tmp.getKey().equals(key)) {
		  return tmp.getValue();
		}
		queue.enqueue(tmp);
	  }
	} catch (Exception ex) {
	  System.out.println("Something really bad happened " + ex);
	}
	return null;
  }

  @Override
  public KeyValuePair<K, V> removeAny() throws Exception {
	if (queue.getSize() <= 0) {
	  throw new Exception("Map is empty");
	}
	try {
	  return queue.dequeue();
	} catch (Exception ex) {
	  System.out.println("Something really bad happened " + ex);
	}
	return null;
  }

  @Override
  public int getSize() {
	return queue.getSize();
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
