/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolBox.ADTs.Set.impl;

import ToolBox.ADTs.Set.Set;
import ToolBox.util.HashTableStats;

/**
 *
 * @author manny
 * @param <T>
 */
public interface HashTableSet<T extends Comparable<? super T>> extends Set<T>, HashTableStats{
  
}
