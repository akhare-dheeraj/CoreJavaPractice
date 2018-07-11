package com.practice.multithreading;

class Resource {
	public String name;
	public void print() {
		System.out.println("Calling print in resource "+name);
	}
}

class FirstThread extends Thread {
	Resource r1;
	Resource r2;

	public FirstThread() {
	}

	public FirstThread(Resource r1, Resource r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void run() {
		try {
			synchronized (r1) {
				r1.print();
//				r1.notify();
//				r1.wait();
				synchronized (r2) {
					r2.print();
//					r2.notify();
//					r2.wait();
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class SecondThread extends Thread {
	Resource r1;
	Resource r2;

	public SecondThread() {
	}

	public SecondThread(Resource r1, Resource r2) {
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void run() {
		try {
			synchronized (r2) {
				r2.print();
//				r2.notify();
//				r2.wait();
				synchronized (r1) {
					r1.print();
//					r1.notify();
//					r1.wait();
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class DeadLockClass {
	public static void main(String[] args) throws Exception {
		Resource r1 = new Resource();
		Resource r2 = new Resource();
		r1.name = "Resource1";
		r2.name = "Resource2";
		FirstThread t1 = new FirstThread(r1, r2);
		SecondThread t2 = new SecondThread(r1, r2);
		t1.start();
		t2.start();
//		t1.join();
//		t2.join();
	}
}
