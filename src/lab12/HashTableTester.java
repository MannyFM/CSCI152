/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import ToolBox.ADTs.Set.impl.BSTHashTable;
import ToolBox.ADTs.Set.impl.HashTableSet;
import ToolBox.ADTs.Set.impl.LLQSHashTable;
import java.util.Random;

/**
 *
 * @author manny
 */
public class HashTableTester {

  public static void main(String[] args) throws Exception {
//	legacyMain(args);
	int N = 25 * 1000;
	int[] addData = new int[N];
	int[] containsData = new int[N];
	HashTableSet<Integer> qSet = new LLQSHashTable<>();
	HashTableSet<Integer> bstSet = new BSTHashTable<>();
	long[] res;

//	for (int i = 0; i < N; i++) {
//	  addData[i] = i;
//	  containsData[i] = i;
//	}
//	res = measureTime(qSet, 3, addData, containsData);
//	res = measureTime(bstSet, 3, addData, containsData);
//	for (int i = 0; i < N; i++) {
//	  addData[i] = i * 10;
//	  containsData[i] = i;
//	}
//	res = measureTime(qSet, 3, addData, containsData);
//	res = measureTime(bstSet, 3, addData, containsData);
	Random rand = new Random();
	for (int step = 0; step < 3; step++) {
	  addData = new int[N];
	  containsData = new int[N];
	  for (int i = 0; i < N; i++) {
		addData[i] = rand.nextInt();
		containsData[i] = i;
	  }
//	  res = measureTime(qSet, 1, addData, containsData);

	res = measureTime(bstSet, 1, addData, containsData);
	}
  }

  /**
   *
   * @param set Set on which test should be executed
   * @param measurementsCount how many tests should be executed
   * @param addData
   * @param containsData
   * @return array of duration in form of [a1, c1, a2, c2, ...]
   * @throws Exception if set is null
   */
  public static long[] measureTime(HashTableSet<Integer> set, int measurementsCount, int[] addData, int[] containsData) throws Exception {
	if (set == null) {
	  throw new Exception("Set is null");
	}

//	System.out.println("Starting timing tests...");
	long[] measurements = new long[measurementsCount * 2];
	for (int trial = 1; trial <= measurementsCount; trial++) {
	  set.clear();
	  System.out.println("Starting timing tests...");
	  long time1, time2, duration;

	  // Timing test for TABLE 1 – Change for the different columns
	  time1 = System.currentTimeMillis();
	  for (int i = 0; i < addData.length; i++) {
		set.add(addData[i]);
	  }
	  time2 = System.currentTimeMillis();
	  duration = time2 - time1;
	  System.out.println("Trial " + trial + " add time in ms: " + duration);
	  measurements[(trial - 1) * 2] = duration;

	  // Timing test for TABLE 2 – DO NOT CHANGE THIS CODE, EVER!!!
	  time1 = System.currentTimeMillis();
	  for (int i = 0; i < containsData.length; i++) {
		set.contains(containsData[i]);
	  }
	  time2 = System.currentTimeMillis();
	  duration = time2 - time1;
	  System.out.println("Trial " + trial + " contains time in ms: " + duration);
	  measurements[(trial - 1) * 2 + 1] = duration;
	  // Hash table stats for columns 3 and 4 – DO NOT CHANGE!!!
	  System.out.println("Load factor: " + set.getLoadFactor());
	  System.out.println("Bucket size standard deviation: "
			  + set.getBucketSizeStandardDev());
	}
	System.out.println("Finished timing tests");
	return measurements;
  }
}
