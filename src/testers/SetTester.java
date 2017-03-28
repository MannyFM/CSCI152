/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import ToolBox.ADTs.Set.Set;
import ToolBox.ADTs.Set.impl.LLQSHashTable;
import ToolBox.ADTs.Set.impl.LLQueueSet;
/**
 *
 * @author manny
 */
public class SetTester {
  
  public static void main(String[] args) throws Exception {
	Set<Integer> set;
	set = new LLQSHashTable<>();
	
	int N = 10;
	int maxVal = N * 2;
	for (int i = 0; i < N; i++) {
	  int val = (int) (Math.random() * maxVal);
//	  int val = i;
//	  if (i % 2 == 0)
//		val *= -1;
	  set.add(val);
//	  System.out.println(val + ":\n" + set);
	}
	System.out.println(set);

	for (int i = 0; i <= maxVal; i++) {
	  if (set.contains(i)) {
		System.out.println(i + "+");
	  }
	}
	for (int i = 0; i < 3; i++)
	  System.out.println(set.removeAny());
	System.out.println(set);
	
	for (int i = 0; i <= maxVal; i++) {
	  if (set.remove(i)) {
		System.out.println(i + "+");
	  }
	}
  }
}
