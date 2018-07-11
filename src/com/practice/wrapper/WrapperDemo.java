package com.practice.wrapper;

public class WrapperDemo {
	public static void changeIt(Object i) {
		Integer d = (Integer)i;
		d++;
	}
	
	public static void main(String[] args) {
		Object i = new Integer(0);
		changeIt(i);
		System.out.println(i);
	}
}
