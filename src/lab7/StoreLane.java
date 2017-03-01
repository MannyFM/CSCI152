/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import ToolBox.ADTs.Queue.Queue;
import ToolBox.ADTs.Queue.impl.LinkedListQueue;

/**
 * Represents a single check-out lane in a store
 *
 * @author manny
 */
public class StoreLane {

  private int laneNumber;
  private Queue<Customer> line;
  private Customer beingServed;

  public StoreLane(int laneNumber) {
	this.laneNumber = laneNumber;
	this.line = new LinkedListQueue();
	this.beingServed = null;
  }

  /* If nobody is currently being served, then c will be served immediately;
  otherwise, c will be added to the queue; this should also output a message
  saying that c has entered this lane */
  public void addNewCustomer(Customer c) {
	System.out.println(c.getName() + " entered lane #" + this.laneNumber);
	
	line.enqueue(c);
	
	nextCustomer();
  }

  /* If there is a customer being served, scan one of their items; After the
  scanning, if the customer has no more items, output a message saying that the
  customer is finished, and then replace the customer being served with the
  next customer in the queue, and output a message saying the new customer is
  being served. However, if the queue is empty at this point, then simply set
  beingServed to null */
  public void scanOneItem() {
	if (beingServed == null && line.getSize() == 0) {
	  return;
	}

	beingServed.scanOneItem();
	
	nextCustomer();
  }

  void nextCustomer() {
	if (beingServed != null && beingServed.noItemsLeft()) {
	  beingServed = null;
	}
	if (beingServed == null && line.getSize() > 0) {
	  try {
		beingServed = line.dequeue();
	  } catch (Exception ex) {
		System.out.println(ex);
	  }
	}
  }

  @Override
  public String toString() {
//	String res = this.beingServed == null ? "null" : this.beingServed.getName();
	String res = this.beingServed + ", lane #" + this.laneNumber;
	res += ": " + this.line;
	return res;
  }
}
