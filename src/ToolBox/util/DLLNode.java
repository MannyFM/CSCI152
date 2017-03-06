/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.util;

/**
 *
 * @author manny
 * @param <T>
 */
public class DLLNode<T> {
  private DLLNode<T> next, previous;
  private T value;
  
  public DLLNode(T value) {
	this.next = null;
	this.previous = null;
	this.value = value;
  }
  
  public DLLNode<T> getNext() {
	return this.next;
  }
  
  public DLLNode<T> getPrevious() {
	return this.previous;
  }
  
  public void setNext(DLLNode<T> link) {
	this.next = link;
  }
  
  public void setPrevious(DLLNode<T> link) {
	this.previous = link;
  }
  
  public T getValue() {
	return this.value;
  }
  
  public void setValue(T value) {
	this.value = value;
  }
  
  @Override
  public String toString() {
	return this.value.toString();
  }
}
