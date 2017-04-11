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
public class LLQSHashTable<T extends Comparable<? super T>> implements HashTableSet<T> {

  private LLQueueSet<T>[] buckets;
  final private int numberOfBuckets;
  private int size;

  public LLQSHashTable() {
	this.numberOfBuckets = 10;
	buckets = new LLQueueSet[numberOfBuckets];
	size = 0;
  }

  public LLQSHashTable(int numberOfBuckets) {
	this.numberOfBuckets = numberOfBuckets;
	buckets = new LLQueueSet[this.numberOfBuckets];
	size = 0;
  }

  private int getIndex(T value) {
	int index = value.hashCode() % numberOfBuckets;
	if (index < 0) {
	  index += numberOfBuckets;
	}
	return index;
  }

  @Override
  public void add(T value) {
	int index = getIndex(value);
	if (buckets[index] == null) {
	  buckets[index] = new LLQueueSet<>();
	}
	size -= buckets[index].getSize();
	buckets[index].add(value);
	size += buckets[index].getSize();
  }

  @Override
  public boolean contains(T value) {
	int index = getIndex(value);
	if (buckets[index] == null) {
	  return false;
	}
	return buckets[index].contains(value);
  }

  @Override
  public boolean remove(T value) {
	int index = getIndex(value);
	if (buckets[index] == null) {
	  return false;
	}
	boolean result = buckets[index].remove(value);
	if (result) {
	  size--;
	}
	return result;
  }

  @Override
  public T removeAny() throws Exception {
	if (size == 0) {
	  throw new Exception("Set is empty");
	}
	for (int i = 0; i < numberOfBuckets; i++) {
	  if (buckets[i] == null || buckets[i].getSize() <= 0) {
		continue;
	  }
	  return buckets[i].removeAny();
	}
	throw new Exception("Something bad happened");
  }

  @Override
  public int getSize() {
	return size;
  }

  @Override
  public void clear() {
	buckets = new LLQueueSet[numberOfBuckets];
	size = 0;
  }

  @Override
  public String toString() {
	String res = "";
	for (int i = 0; i < numberOfBuckets; i++) {
	  if (i > 0) {
		res += ", ";
	  }
	  res += buckets[i];
	}
	return "{" + res + "}";
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
