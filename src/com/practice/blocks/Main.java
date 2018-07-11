package com.practice.blocks;
class Parent {
	static {
		System.out.println("Parent static block");
	}
	{
		System.out.println("Inside parent constructor block");
	}
}

class Child extends Parent {
	static {
		System.out.println("Child static block");
	}
	{
		System.out.println("Inside child constructor block");
	}
}
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
	}
}
