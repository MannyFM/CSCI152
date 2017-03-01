/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import ToolBox.ADTs.Deque.Deque;
import ToolBox.ADTs.Deque.impl.DLLDeque;

/**
 *
 * @author manny
 */
public class DequeTester {

  public static void main(String[] args) {
	Deque<Integer> deque = new DLLDeque();
	for (int i = 0; i < 7; i++) {
	  deque.pushToBack(i);
	}
	for (int i = 0; i < 7; i++) {
	  deque.pushToFront(-i);
	}
	System.out.println(deque);
	try {
	  for (int i = 0; i < 10; i++) {
		System.out.print(deque.popFromBack() + " + ");
	  }
	  System.out.println(deque);
	  for (int i = 0; i < 10; i++) {
		System.out.print(deque.popFromFront() + " + ");
	  }
	} catch (Exception ex) {
	  System.out.println("<--------------------------->");
	  System.out.println(ex);
	}
  }
}
