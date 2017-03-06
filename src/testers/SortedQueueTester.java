/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import ToolBox.ADTs.SortedQueue.SortedQueue;
import ToolBox.ADTs.SortedQueue.impl.LinkedListSortedQueue;

/**
 *
 * @author manny
 */
public class SortedQueueTester {

  public static void main(String[] args) {
	SortedQueue<Integer> q = new LinkedListSortedQueue<>();
	for (int i = 0; i < 5; i++) {
	  q.insert(i);
//	  System.out.println(q);
	}
	for (int i = 0; i < 5; i++) {
	  q.insert(-i);
//	  System.out.println(q);
	}
	System.out.println(q);
	for (int i = 0; i < 12; i++) {
	  try {
		System.out.println(q.dequeue());
	  } catch (Exception ex) {
		System.out.println(ex);
	  }
	}
  }
}
