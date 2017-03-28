/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import ToolBox.ADTs.Set.impl.RBTSet;
import ToolBox.ADTs.Set.Set;

/**
 *
 * @author manny
 */
public class RBTSetTester {

  public static void main(String[] args) throws Exception {
	RBTSet<Integer> set = new RBTSet<>();
	//TODO: replace to SET<>

//	set.add(1);
//	System.out.println(1 + ":\n" + set);
	int N = 10;
	int maxVal = N * 2;
	for (int i = 0; i < N; i++) {
	  int val = (int) (Math.random() * maxVal);
//	  int val = i;
//	  if (i % 2 == 0)
//		val *= -1;
	  set.add(val);
	  System.out.println(set.isOk());
//	  System.out.println(val + ":\n" + set);
	}
	System.out.println(set);

	for (int i = 0; i <= maxVal; i++) {
	  if (set.contains(i)) {
		System.out.println(i + "+");
	  }
	}
	System.out.println(set);
	System.out.println(set.out());

	set.removeAny();
	System.out.println(set.isOk());
//	for (int i = 0; i <= maxVal; i++) {
//	  if (set.remove(i)) {
//		System.out.println("removed " + i + " " + set);
////		return;
//	  }
//	}
  }
}
