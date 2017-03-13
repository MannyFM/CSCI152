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

  public static void main(String[] args) throws Exception {
	int choose = 6;
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
//	Stack Tester
	  System.out.println("StackTester:");
	  testers.StackTester.main(args);
	}

	if (choose == 4) {
//	Lab8
	  System.out.println("lab8.ProblemSolver:");
	  lab8.ProblemSolver.main(args);
	}

	if (choose == 5) {
//	Treat Tester
	  System.out.println("testers.TreapTester:");
	  testers.TreapTester.main(args);
	}
	
	if (choose == 6) {
//	Red-Black Tree Set Tester
	  System.out.println("testers.RBTSetTester:");
	  testers.RBTSetTester.main(args);
	}
  }
}
