/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import ToolBox.ADTs.Queue.Queue;
import ToolBox.ADTs.Queue.impl.LinkedListQueue;
import ToolBox.ADTs.Stack.Stack;
import ToolBox.ADTs.Stack.impl.LinkedListStack;

/**
 *
 * @author manny
 */
public class Lab6Tester {

  public static void main(String[] args) {
	Queue<Character> q = new LinkedListQueue<>();
	for (char a = 'a'; a <= 'd'; a++) {
	  q.enqueue(a);
	}

	System.out.println(q);

	try {
	  Queue<Character> tmp = copyQueue(q);
	  reverseQueue(tmp);

	  System.out.println(tmp);

	  while (tmp.getSize() > 0) {
		q.enqueue(tmp.dequeue());
	  }
	} catch (Exception ex) {
	  System.out.println(ex);
	}
	q.enqueue('A');

	System.out.println(q);

	try {
	  System.out.println(isPalindrome(q));
	} catch (Exception ex) {
	  System.out.println(ex);
	}

	System.out.println(q);
  }

  public static void reverseQueue(Queue<Character> q) throws Exception {
	Stack<Character> tmp = new LinkedListStack<>();
	while (q.getSize() > 0) {
	  tmp.push(q.dequeue());
	}
	while (tmp.getSize() > 0) {
	  q.enqueue(tmp.pop());
	}
  }

  public static boolean isPalindrome(Queue<Character> q) throws Exception {
	Queue<Character> tmp = copyQueue(q);
	reverseQueue(tmp);
	boolean flag = true;
	while (tmp.getSize() > 0) {
	  char tVal = tmp.dequeue();
	  char qVal = q.dequeue();
	  q.enqueue(qVal);

	  if (tVal != qVal) {
		flag = false;
	  }
	}
	return flag;
  }

  public static Queue<Character> copyQueue(Queue<Character> q) throws Exception {
	Queue<Character> tmp = new LinkedListQueue<>();
	for (int i = 0; i < q.getSize(); i++) {
	  char val = q.dequeue();
	  q.enqueue(val);
	  tmp.enqueue(val);
	}
	return tmp;
  }
}
