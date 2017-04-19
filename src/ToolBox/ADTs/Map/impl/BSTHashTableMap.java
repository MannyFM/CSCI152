/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Map.impl;

import ToolBox.util.KeyValuePair;

/**
 *
 * @author manny
 * @param <K>
 * @param <V>
 */
public class BSTHashTableMap<K extends Comparable<K>, V> implements HashTableMap<K, V> {

  private final BSTMap<K, V>[] buckets;
  private int numberOfBuckets;
  private int size;
  
  public BSTHashTableMap() {
	this.numberOfBuckets = 10;
	this.buckets = new BSTMap[numberOfBuckets];
	this.size = 0;
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
	  buckets[index] = new BSTMap<>();
	}
	this.size -= buckets[index].getSize();
	buckets[index].define(key, value);
	this.size += buckets[index].getSize();
  }

  @Override
  public V getValue(K key) {
	int index = getIndex(key);
	if (buckets[index] == null) {
	  return null;
	}
	return buckets[index].getValue(key);
  }

  @Override
  public V remove(K key) {
	int index = getIndex(key);
	if (buckets[index] == null) {
	  return null;
	}
	this.size -= buckets[index].getSize();
	V result = buckets[index].remove(key);
	this.size += buckets[index].getSize();
	return result;
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
		KeyValuePair kvp = buckets[index].removeAny();
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
	  if (res.length() > 0)
		res += ", ";
	  res += buckets[i].getElements();
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
