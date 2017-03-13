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
  public static void main(String[] args) {
	Set<Integer> set = new RBTSet<>();
	for (int i = 0; i < 10; i++) {
	  int val = i;
	  if (i % 2 == 0)
		val *= -1;
	  set.add(val);
	  System.out.println(val + ":\n" + set);
//	  System.out.println(set.out());
	}
  }
}
