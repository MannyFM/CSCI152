/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author manny
 */
public class StoreTest {

  public static void main(String[] args) {
// Create a Store object called galmart
	Store galmart = new Store();
	Customer[] customers = new Customer[5];
	
// Create several customers, and have them each pick up several items to buy
	for (int i = 0; i < customers.length; i++) {
	  customers[i] = new Customer("John #" + i);
	  for (int j = 0; j <= i; j++) {
		customers[i].pickUpItemToBuy("item " + j);
	  }
	}

// Add the customers to different lanes of galmart
	for (int i = 0; i < customers.length; i++) {
	  try {
		galmart.addCustomerToLane(customers[i], i % 4 + 1);
	  } catch (Exception ex) {
		System.out.println(ex);
	  }
	}
	
// Call allLanesScanOneItem many, many times, until all of the customers are
// finished scanning all of their items
	System.out.println(galmart);
	for (int i = 0; i < 7; i++) {
	  galmart.allLanesScanOneItem();
	  System.out.println(galmart);
	}
  }
}
