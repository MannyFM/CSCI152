/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manny
 */
public class MainRunner {

  public static void main(String[] args) {
	int choose = 3;
	if (choose == 0) {
//	Store Tester
	  System.out.println("StoreTest:");
	  lab7.StoreTest.main(args);
	}

	if (choose == 1) {
//	Deque Tester
	  System.out.println("DequeTester:");
	  testers.DequeTester.main(args);
	}

	if (choose == 2) {
//	SortedQueue Tester
	  System.out.println("SortedQueueTester:");
	  testers.SortedQueueTester.main(args);
	}
	
	if (choose == 3) {
//	SortedQueue Tester
	  System.out.println("lab8.ProblemSolver:");
	  lab8.ProblemSolver.main(args);
	}
  }
}
