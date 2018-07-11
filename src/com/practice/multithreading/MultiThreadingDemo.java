package com.practice.multithreading;

class DemoThread extends Thread {
	public DemoThread() {
	}
	public DemoThread(Runnable thread) {
		super(thread);
	}
	
	@Override
	public void run() {
		System.out.println("Inside Thread");
	}
}

class DemoRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside Runnable");
	}
	
}

public class MultiThreadingDemo {
	public static void main(String[] args) {
		new DemoThread().start();
		new DemoThread(new DemoRunnable()).start();
		new Thread(new DemoRunnable()).start();
	}
}
