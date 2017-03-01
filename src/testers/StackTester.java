/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import ToolBox.ADTs.Stack.impl.ArrayStack;
import ToolBox.ADTs.Stack.impl.LinkedListStack;
import ToolBox.ADTs.Stack.Stack;

/**
 *
 * @author manny
 */
public class StackTester {

  public static void main(String[] args) throws Exception {
	Stack<Integer> st = new LinkedListStack();
	for (int i = 0; i < 5; i++) {
	  st.push(i);
	}
	System.out.println(st + "\n");

	repeater(st);
	System.out.println(st + "\n");

	Stack tmp = copy(st);
	for (int i = 0; i < 5; i++) {
	  tmp.pop();
	}
	System.out.println(st);
	System.out.println(tmp + "\n");
  }

  public static void repeater(Stack st) {
	try {
	  Stack tmp = new ArrayStack();
	  while (st.getSize() > 0) {
		Object val = st.pop();
		tmp.push(val);
	  }

	  while (tmp.getSize() > 0) {
		Object val = tmp.pop();
		st.push(val);
		st.push(val);
	  }

	} catch (Exception ex) {
	  System.out.println(ex);
	}
  }

  public static Stack copy(Stack st) {
	Stack tmp = new ArrayStack();
	Stack res = new ArrayStack();
	try {
	  while (st.getSize() > 0) {
		Object val = st.pop();
		tmp.push(val);
	  }

	  while (tmp.getSize() > 0) {
		Object val = tmp.pop();
		st.push(val);
		res.push(val);
	  }

	} catch (Exception ex) {
	  System.out.println(ex);
	}

	return res;
  }
}
