/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import ToolBox.ADTs.Set.Set;
import ToolBox.ADTs.Set.impl.BSTSet;
import ToolBox.ADTs.Set.impl.LLQueueSet;
import java.util.Random;

/**
 *
 * @author manny
 */
public class SetTimeTester {

  public static void main(String[] args) throws Exception {
//	legacyMain(args);
	int N = 25 * 1000;
	int[] addData = new int[N];
	int[] containsData = new int[N];
	Set<Integer> qSet = new LLQueueSet<>();
	Set<Integer> bstSet = new BSTSet<>();
	long[] res;

//	for (int i = 0; i < N; i++) {
//	  addData[i] = i;
//	  containsData[i] = i;
//	}
//	res = measureTime(qSet, 3, addData, containsData);
//	for (int i = 0; i < res.length; i += 2) {
//	  System.out.println(res[i] + ", " + res[i + 1]);
//	}
//	res = measureTime(bstSet, 3, addData, containsData);
//	for (int i = 0; i < res.length; i += 2) {
//	  System.out.println(res[i] + ", " + res[i + 1]);
//	}

//	for (int i = 0; i < N; i++) {
//	  addData[i] = N - i - 1;
//	  containsData[i] = i;
//	}
//	res = measureTime(qSet, 3, addData, containsData);
//	for (int i = 0; i < res.length; i += 2) {
//	  System.out.println(res[i] + ", " + res[i + 1]);
//	}
//	res = measureTime(bstSet, 3, addData, containsData);
//	for (int i = 0; i < res.length; i += 2) {
//	  System.out.println(res[i] + ", " + res[i + 1]);
//	}

	Random rand = new Random();
	for (int i = 0; i < N; i++) {
	  addData[i] = rand.nextInt();
	  containsData[i] = i;
	}
//	res = measureTime(qSet, 3, addData, containsData);
//	for (int i = 0; i < res.length; i += 2) {
//	  System.out.println(res[i] + ", " + res[i + 1]);
//	}
	res = measureTime(bstSet, 3, addData, containsData);
	for (int i = 0; i < res.length; i += 2) {
	  System.out.println(res[i] + ", " + res[i + 1]);
	}
  }

  public static void legacyMain(String[] args) throws Exception {
	for (int trial = 1; trial <= 3; trial++) {
	  // Change the next line for the two different implementations
	  Set<Integer> set = new LLQueueSet();
//	  Set<Integer> set = new BSTSet();
	  System.out.println("Starting timing tests...");
	  long time1, time2, duration;
	  // Timing test for TABLE 1 – Change for the different columns
	  time1 = System.currentTimeMillis();
	  for (int i = 0; i <= 25000; i++) {
		set.add(i);
	  }
	  time2 = System.currentTimeMillis();
	  duration = time2 - time1;
	  System.out.println("Trial " + trial + " add time in ms: " + duration);
	  // Timing test for TABLE 2 – DO NOT CHANGE THIS CODE, EVER!!!
	  time1 = System.currentTimeMillis();
	  for (int j = 0; j <= 25000; j++) {
		set.contains(j);
	  }
	  time2 = System.currentTimeMillis();
	  duration = time2 - time1;
	  System.out.println("Trial " + trial + " contains time in ms: " + duration);
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
  public static long[] measureTime(Set<Integer> set, int measurementsCount, int[] addData, int[] containsData) throws Exception {
	if (set == null) {
	  throw new Exception("Set is null");
	}

	System.out.println("Starting timing tests...");
	long[] measurements = new long[measurementsCount * 2];
	for (int trial = 1; trial <= measurementsCount; trial++) {
	  set.clear();
//	  System.out.println("Starting timing tests...");
	  long time1, time2, duration;

	  // Timing test for TABLE 1 – Change for the different columns
	  time1 = System.currentTimeMillis();
	  for (int i = 0; i < addData.length; i++) {
		set.add(addData[i]);
	  }
	  time2 = System.currentTimeMillis();
	  duration = time2 - time1;
//	  System.out.println("Trial " + trial + " add time in ms: " + duration);
	  measurements[(trial - 1) * 2] = duration;

	  // Timing test for TABLE 2 – DO NOT CHANGE THIS CODE, EVER!!!
	  time1 = System.currentTimeMillis();
	  for (int i = 0; i < containsData.length; i++) {
		set.contains(containsData[i]);
	  }
	  time2 = System.currentTimeMillis();
	  duration = time2 - time1;
//	  System.out.println("Trial " + trial + " contains time in ms: " + duration);
	  measurements[(trial - 1) * 2 + 1] = duration;
	}
	System.out.println("Finished timing tests");
	return measurements;
  }
}
