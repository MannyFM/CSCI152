/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testers;

import ToolBox.ADTs.Map.Map;
import ToolBox.ADTs.Map.impl.BSTMap;
import ToolBox.ADTs.Map.impl.LLQHashTableMap;

/**
 *
 * @author manny
 */
public class MapTester {

  public static void main(String[] args) {
	Map<Integer, String> map = new LLQHashTableMap<>();
	try {
	  map.removeAny();
	} catch (Exception ex) {
	  System.out.println(ex);
	}
	System.out.println(map + ": " + map.getSize());

	for (int i = 0; i < 5; i++) {
	  map.define(i, "John " + i);
	}
	System.out.println(map + ": " + map.getSize());

	System.out.println("removing " + 4 + ": " + map.remove(4));
	System.out.println(map + ": " + map.getSize());

	System.out.println("removing " + 4 + ": " + map.remove(4));
	System.out.println(map + ": " + map.getSize());

	for (int i = 0; i < 2; i++) {
	  map.define(i, "Sudano " + i);
	}
	System.out.println(map + ": " + map.getSize());

	for (int i = 10; i < 13; i++) {
	  map.define(i, "Deadman" + i);
	}
	System.out.println(map + ": " + map.getSize());

	for (int i = 0; i < 2; i++) {
	  try {
		System.out.println(map.removeAny());
	  } catch (Exception ex) {
		System.out.println(ex);
	  }
	}
	System.out.println(map + ": " + map.getSize());

	map.clear();
	System.out.println(map + ": " + map.getSize());

	for (int i = 0; i < 2; i++) {
	  map.define(i * 10, "Sudano " + i * 10);
	}
	System.out.println(map + ": " + map.getSize());

  }
}
