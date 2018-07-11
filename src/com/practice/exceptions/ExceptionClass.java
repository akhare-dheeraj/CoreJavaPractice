package com.practice.exceptions;

import java.io.IOException;

public class ExceptionClass {
	public static void main(String[] args) {
		try {
			throw new IOException("Hello");
		} catch(IOException e) {
			
		} catch(Exception e) {
			
		}
	}
}
