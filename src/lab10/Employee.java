/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

/**
 *
 * @author manny
 */
public class Employee implements Comparable<Employee> {

  private String name;
  private long taxID; // The compareTo method should use this field to order Employees
  private int monthlyPay;

  Employee(String name, long taxID, int monthlyPay) {
	this.name = name;
	this.taxID = taxID;
	this.monthlyPay = monthlyPay;
  }

  /**
   * @return the name
   */
  public String getName() {
	return name;
  }

  /**
   * @return the taxID
   */
  public long getTaxID() {
	return taxID;
  }

  /**
   * @return the monthlyPay
   */
  public int getMonthlyPay() {
	return monthlyPay;
  }

  /**
   * @param monthlyPay the monthlyPay to set
   */
  public void setMonthlyPay(int monthlyPay) {
	this.monthlyPay = monthlyPay;
  }

  @Override
  public boolean equals(Object other) {
	if (other == null) {
	  return false;
	}
	if (other == this) {
	  return true;
	}
	if (!(other instanceof Employee)) {
	  return false;
	}
	Employee otherMyClass = (Employee) other;
	return otherMyClass.taxID == this.taxID;
  }

  @Override
  public int compareTo(Employee other) {
	return Long.compare(this.taxID, other.taxID);
  }
  
  @Override
  public String toString() {
	return name + "(" + taxID + "): " + monthlyPay;
  }
}
