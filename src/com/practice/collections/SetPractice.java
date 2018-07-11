package com.practice.collections;

import java.util.HashSet;
import java.util.Set;

class Node {
	int num;
	static int i=0;
	public Node(int num) {
		// TODO Auto-generated constructor stub
		this.num = num;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public String toString() {
		return num+"";
	}
}

public class SetPractice {
	static Set<Node> duplicateNodeSet;
	public static void main(String[] args) {
		duplicateNodeSet = new HashSet<>();
		Node n1 = new Node(7);
		
		duplicateNodeSet.add(n1);
		
		duplicateNodeSet.add(new Node(7));
		duplicateNodeSet.add(n1);
		
		System.out.println(duplicateNodeSet);
	}
}
