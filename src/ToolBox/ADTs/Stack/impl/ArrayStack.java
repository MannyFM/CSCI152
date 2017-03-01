/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Stack.impl;

import ToolBox.ADTs.Stack.Stack;

/**
 *
 * @author manny
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] array;
    private int size;
    
    public ArrayStack() {
        this.array = (T[])new Object[10];
        this.size = 0;
    }
    
    @Override
    public T pop() throws Exception {
        if (size <= 0) {
            throw new Exception("Stack is empty");
        }
        return this.array[--size];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size = 0;
    }
    
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < size; i++) {
            if (i > 0)
                res += ", ";
            res += this.array[i];
        }
        return "[" + this.size + ": " + res + "]";
    }

  @Override
  public void push(T value) {
	if (size >= this.array.length) {
		T[] newArray = (T[])new Object[this.array.length * 2];
		for (int i = 0; i < this.size; i++)
			newArray[i] = array[i];
		this.array = newArray;
	}
	this.array[size++] = value;
  }
    
}
