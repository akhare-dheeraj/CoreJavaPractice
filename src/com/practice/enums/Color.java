package com.practice.enums;
import java.lang.Enum;

interface ColorInterface {
	String colour = "InterfaceColor";
	
	public void printColor();
}
enum ColorEnum implements ColorInterface{
	RED,
	BLACK,
	BLUE,
	YELLOW;

	private ColorEnum() {
		
	}
	@Override
	public void printColor() {
		System.out.println(this);
		System.out.println(colour);
	}
}

public class Color {
	public static void main(String[] args) {
		ColorEnum.BLACK.printColor();
	}
}
