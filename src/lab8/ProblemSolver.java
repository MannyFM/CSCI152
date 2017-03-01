/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import ToolBox.ADTs.Deque.Deque;
import ToolBox.ADTs.Deque.impl.DLLDeque;

/**
 *
 * @author manny
 */
public class ProblemSolver {

  public static void main(String[] args) {
	Deque<Integer> deq = new DLLDeque();
	for (int i = 1; i <= 10; i++) {
	  deq.pushToBack(i);
	}
	System.out.println(deq);

	Deque<Integer> tmp;
	try {
	  tmp = copyDeque(deq);
	  int step = 0;
	  do {
		step++;
		shuffle(tmp);
		System.out.println(step + ": " + tmp);
	  } while (!areEqual(deq, tmp));
	
	  System.out.println("It took " + step + " steps");
	} catch (Exception ex) {
	  System.out.println("<-------------------------------------->");
	  System.out.println(ex);
	}
  }

  public static Deque<Integer> copyDeque(Deque<Integer> deq) throws Exception {
	Deque<Integer> res = new DLLDeque();
	for (int i = 0; i < deq.getSize(); i++) {
	  int tmp = deq.popFromFront();
	  res.pushToBack(tmp);
	  deq.pushToBack(tmp);
	}
	return res;
  }

  public static boolean areEqual(Deque<Integer> deq1, Deque<Integer> deq2) throws Exception {
	if (deq1.getSize() != deq2.getSize()) {
	  return false;
	}
	boolean fl = true;
	for (int i = 0; i < deq1.getSize(); i++) {
	  int x = deq1.popFromFront();
	  int y = deq2.popFromFront();
	  fl &= (x == y);
	  deq1.pushToBack(x);
	  deq2.pushToBack(y);
	}
	return fl;
  }

  public static void shuffle(Deque<Integer> deq) throws Exception {
	Deque<Integer> tmp = new DLLDeque();
	while (deq.getSize() > 0) {
	  int x = deq.popFromFront();
	  int y = deq.popFromBack();
	  tmp.pushToBack(x);
	  tmp.pushToBack(y);
	}
	while (tmp.getSize() > 0) {
	  int x = tmp.popFromFront();
	  deq.pushToBack(x);
	}
  }
}
