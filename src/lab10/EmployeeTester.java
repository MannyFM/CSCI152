/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import ToolBox.ADTs.Set.Set;
import ToolBox.ADTs.Set.impl.BSTSet;
/**
 *
 * @author manny
 */
public class EmployeeTester {
  public static void main(String[] args) {
	Set <Employee> set = new BSTSet<>();
	for (int i = 1; i <= 5; i++) {
	  long taxID = i + (long)(Math.random() * 1000);
	  Employee person = new Employee("Jonh" + i, taxID, i * 123);
	  set.add(person);
	}
	System.out.println(set.getSize() + ":" + set);
	
	for (int i = 1; i <= 2; i++) {
	  long taxID = i;
	  Employee person = new Employee("Jonh" + i, taxID, i * 123);
	  set.add(person);
	}
	System.out.println(set.getSize() + ":" + set);
	
	for (int i = 1; i <= 2; i++) {
	  long taxID = i;
	  Employee person = new Employee("Sherlock" + i, taxID, i);
	  set.add(person);
	}
	System.out.println(set.getSize() + ":" + set);
	
	set.clear();
	System.out.println(set.getSize() + ":" + set);
	
	for (int i = 1; i <= 2; i++) {
	  long taxID = i;
	  Employee person = new Employee("Sherlock" + i, taxID, i);
	  set.add(person);
	}
	System.out.println(set.getSize() + ":" + set);
  }
}
