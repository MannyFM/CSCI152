/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Map.impl;

import ToolBox.util.KeyValuePair;
import ToolBox.ADTs.Queue.impl.LinkedListQueue;

/**
 *
 * @author manny
 */
public class LLQHashTableMap<K, V> implements HashTableMap<K, V> {

  private LinkedListQueue<KeyValuePair<K, V>>[] buckets;
  private int numberOfBuckets;
  private int size;

  public LLQHashTableMap() {
	this.numberOfBuckets = 10;
	buckets = new LinkedListQueue[numberOfBuckets];
	size = 0;
  }

  private int getIndex(K key) {
	int index = key.hashCode() % numberOfBuckets;
	if (index < 0) {
	  index += numberOfBuckets;
	}
	return index;
  }

  @Override
  public void define(K key, V value) {
	int index = getIndex(key);
	if (buckets[index] == null) {
	  buckets[index] = new LinkedListQueue<>();
	}
	for (int step = 0; step < buckets[index].getSize(); step++) {
	  try {
		KeyValuePair<K, V> tmp = buckets[index].dequeue();
		buckets[index].enqueue(tmp);
		if (tmp.getKey().equals(key)) {
		  tmp.setValue(value);
		  return;
		}
	  } catch (Exception ex) {
		System.out.println("Something really bad happened " + ex);
	  }
	}
	buckets[index].enqueue(new KeyValuePair<>(key, value));
	size++;
  }

  @Override
  public V getValue(K key) {
	int index = getIndex(key);
	if (buckets[index] == null) {
	  return null;
	}
	for (int step = 0; step < buckets[index].getSize(); step++) {
	  try {
		KeyValuePair<K, V> tmp = buckets[index].dequeue();
		buckets[index].enqueue(tmp);
		if (tmp.getKey().equals(key)) {
		  return tmp.getValue();
		}
	  } catch (Exception ex) {
		System.out.println("Something really bad happened " + ex);
	  }
	}
	return null;
  }

  @Override
  public V remove(K key) {
	int index = getIndex(key);
	if (buckets[index] == null) {
	  return null;
	}
	for (int step = 0; step < buckets[index].getSize(); step++) {
	  try {
		KeyValuePair<K, V> tmp = buckets[index].dequeue();
		if (tmp.getKey().equals(key)) {
		  size--;
		  return tmp.getValue();
		}
		buckets[index].enqueue(tmp);
	  } catch (Exception ex) {
		System.out.println("Something really bad happened " + ex);
	  }
	}
	return null;
  }

  @Override
  public KeyValuePair<K, V> removeAny() throws Exception {
	if (size <= 0) {
	  throw new Exception("Map is empty");
	}
	for (int index = 0; index < numberOfBuckets; index++) {
	  if (buckets[index] == null || buckets[index].getSize() <= 0) {
		continue;
	  }
	  try {
		KeyValuePair kvp = buckets[index].dequeue();
		return kvp;
	  } catch (Exception ex) {
		System.out.println("Something really bad happened " + ex);
		break;
	  }
	}
	throw new Exception("Something really bad happened");
//	return null;
  }

  @Override
  public int getSize() {
	return this.size;
  }

  @Override
  public void clear() {
	for (int i = 0; i < numberOfBuckets; i++) {
	  buckets[i] = null;
	}
	size = 0;
  }

  @Override
  public String toString() {
	String res = "";
	for (int i = 0; i < numberOfBuckets; i++) {
	  if (buckets[i] == null)
		continue;
	  for (int k = 0; k < buckets[i].getSize(); k++) {
		if (res.length() > 0) {
		  res += ", ";
		}
		try {
		  KeyValuePair kvp = buckets[i].dequeue();
		  buckets[i].enqueue(kvp);
		  res += kvp + " ";
		} catch (Exception ex) {
		  System.out.println("Something really bad happened " + ex);
		}
	  }
	}
	return "[" + res + "]";
  }

  @Override
  public int getNumberOfBuckets() {
	return this.numberOfBuckets;
  }

  @Override
  public int getBucketSize(int index) throws Exception {
	if (this.buckets[index] == null) {
	  return 0;
	}
	return this.buckets[index].getSize();
  }

  @Override
  public double getLoadFactor() {
	return (this.size + .0) / this.numberOfBuckets;
  }

  @Override
  public double getBucketSizeStandardDev() {
	double mean = getLoadFactor();
	double result = 0;
	for (int i = 0; i < this.numberOfBuckets; i++) {
	  try {
		result += (mean - getBucketSize(i)) * (mean - getBucketSize(i));
	  } catch (Exception ex) {
		System.out.println("Something really bad happened " + ex);
	  }
	}
	result /= this.numberOfBuckets;
	result = Math.sqrt(result);

	return result;
  }

  @Override
  public String bucketsToString() {
	String res = "";
	for (int i = 0; i < numberOfBuckets; i++) {
	  if (i > 0) {
		res += ", ";
	  }
	  res += buckets[i];
	}
	return "{" + res + "}";
  }
}
