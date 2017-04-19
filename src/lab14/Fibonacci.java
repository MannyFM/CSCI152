package lab14;

import ToolBox.ADTs.Map.Map;
import ToolBox.ADTs.Map.impl.BSTHashTableMap;

public class Fibonacci {

  /////////////////////////
  // Version One
  /////////////////////////
  private static int callCount1;

  public static long fibCalc1(int n) {
	callCount1++;
	if (n < 2) {
	  return n;
	}
	return fibCalc1(n - 1) + fibCalc1(n - 2);
  }

  public static void testFibCalc1(int n) {
	callCount1 = 0;
	System.out.println("fibCalc1(" + n + ") = " + fibCalc1(n)
			+ "; takes " + callCount1 + " calls.");
  }

  /////////////////////////
  // Version Two
  /////////////////////////
  private static int callCount2;
  private static Map<Integer, Long> ansMap = new BSTHashTableMap<>();

  public static long fibCalc2(int n) {

	callCount2++;
	if (n < 2) {
	  return n;
	}
	Long ans = ansMap.getValue(n);
	if (ans == null) {
	  ans = fibCalc2(n - 1) + fibCalc2(n - 2);
	  ansMap.define(n, ans);
	}
	return ans;
  }

  public static void testFibCalc2(int n) {
	callCount2 = 0;

	System.out.println("fibCalc2(" + n + ") = " + fibCalc2(n)
			+ "; takes " + callCount2 + " calls.");
  }

  ///////////
  public static void main(String[] args) {

	for (int x = 0; x < 30; x++) {
	  testFibCalc1(x);
	}

	for (int x = 30; x > 0; x--) {
	  testFibCalc2(x);
	}

  }
}
