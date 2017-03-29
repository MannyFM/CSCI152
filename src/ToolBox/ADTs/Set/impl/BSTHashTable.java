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
public class BSTHashTable<T extends Comparable<? super T>> implements Set<T> {

  private BSTSet<T>[] buckets;
  final private int numberOfBuckets;
  private int size;

  public BSTHashTable() {
	this.numberOfBuckets = 10;
	buckets = new BSTSet[numberOfBuckets];
	size = 0;
  }

  public BSTHashTable(int numberOfBuckets) {
	this.numberOfBuckets = numberOfBuckets;
	buckets = new BSTSet[this.numberOfBuckets];
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
	  buckets[index] = new BSTSet<>();
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
	buckets = new BSTSet[numberOfBuckets];
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
}
