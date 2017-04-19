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
	int choose = 12;
	switch (choose) {
	  case 0:
		//Store Tester
		System.out.println("StoreTest:");
		lab7.StoreTest.main(args);
		break;
	  case 1:
		//Deque Tester
		System.out.println("DequeTester:");
		testers.DequeTester.main(args);
		break;
	  case 2:
		//SortedQueue Tester
		System.out.println("SortedQueueTester:");
		testers.SortedQueueTester.main(args);
		break;
	  case 3:
		//Stack Tester
		System.out.println("StackTester:");
		testers.StackTester.main(args);
		break;
	  case 4:
		//Lab8
		System.out.println("lab8.ProblemSolver:");
		lab8.ProblemSolver.main(args);
		break;
	  case 5:
		//Treap Tester
		System.out.println("testers.TreapTester:");
		testers.TreapTester.main(args);
		break;
	  case 6:
		//Red-Black Tree Set Tester
		System.out.println("testers.RBTSetTester:");
		testers.RBTSetTester.main(args);
		break;
	  case 7:
		//LAB 10.Employee Tester
		System.out.println("lab10.EmployeeTester:");
		lab10.EmployeeTester.main(args);
		break;
	  case 8:
		//Set Tester
		System.out.println("testers.SetTester:");
		testers.SetTester.main(args);
		break;
	  case 9:
		//LAB 11.SetTimeTester
		System.out.println("lab11.SetTimeTester:");
		lab11.SetTimeTester.main(args);
		break;
	  case 10:
		//LAB 12.HashTableTester
		System.out.println("lab12.HashTableTester:");
		lab12.HashTableTester.main(args);
		break;
	  case 11:
		//Map Tester
		System.out.println("testers.MapTester:");
		testers.MapTester.main(args);
		break;
	  case 12:
		//Lab 14 Fibonacci
		System.out.println("lab14.Fibonacci:");
		lab14.Fibonacci.main(args);
		break;
	  default:
		System.out.println("Nothing to run");
		break;
	}
  }
}
