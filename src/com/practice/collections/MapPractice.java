package com.practice.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class Key {
	int num;
	
	public Key(int num) {
		// TODO Auto-generated constructor stub
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return num;
	}
	
	@Override
	public String toString() {
		return num+"";
	}
}
public class MapPractice {
	public static void main(String[] args) {
		Map<Key, Integer> duplicateMap = new HashMap<>();
		
		Key key = new Key(7);
		Key key1 = new Key(7);
		
		duplicateMap.put(key, 10);
		duplicateMap.put(key1, 12);
		System.out.println(duplicateMap);
		System.out.println(duplicateMap.size());
		
		System.out.println(duplicateMap.get(new Key(7)));
		
		new Hashtable<>();
	}
}
