/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 * Class used to represent a store with three check-out lanes
 * @author manny
 */
public class Store {

  private StoreLane[] lanes;

  public Store() {
	 this.lanes = new StoreLane[3];
	 for (int i = 0; i < 3; i++)
	   this.lanes[i] = new StoreLane(i);
  }
  
  /* Adds the given customer to the given lane; an exception is thrown
  if laneNum is not 1, 2, or 3 */
  public void addCustomerToLane(Customer c, int laneNum) throws Exception {
	if (3 < laneNum || laneNum < 1) {
	  throw new Exception("Cannot add " + c.getName() + ". There is no lane #" + laneNum);
	}
	lanes[laneNum - 1].addNewCustomer(c);
  }

  /* All three lanes scan an item */
  public void allLanesScanOneItem() {
	for (int i = 0; i < 3; i++) {
	  lanes[i].scanOneItem();
	}
  }
  
  @Override
  public String toString() {
	String res = "\n";
	for (int i = 0; i < 3; i++)
	  res += "\t" + this.lanes[i] + "\n";
	return "{ " + res + "}";
  }
}
