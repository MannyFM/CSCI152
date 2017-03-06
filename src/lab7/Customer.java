/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import ToolBox.ADTs.Queue.Queue;
import ToolBox.ADTs.Queue.impl.LinkedListQueue;

/**
 * Used to represent customers in a store
 *
 * @author manny
 */

public class Customer {

  private String name;
  private Queue<String> itemsToScan;

  public Customer(String name) {
	this.name = name;
	this.itemsToScan = new LinkedListQueue<>();
  }

  /* Adds the given item name to the queue. */
  public void pickUpItemToBuy(String itemName) {
	this.itemsToScan.enqueue(itemName);
  }

  /* Removes the first item from the queue, and output a message saying what
  has been scanned, and for which customer */
  public void scanOneItem() {
	String scannedItem;
	try {
	  scannedItem = itemsToScan.dequeue();
	} catch (Exception ex) {
//	  System.out.println(ex);
	  return;
	}
	System.out.println("Person " + this.name + " scanned " + scannedItem);
  }

  /* Returns true if and only if the customer has no items left to scan */
  public boolean noItemsLeft() {
	return this.itemsToScan.getSize() == 0;
  }

  public String getName() {
	return this.name;
  }
  
  @Override
  public String toString() {
	return this.name + ", " + this.itemsToScan;
  }
}
