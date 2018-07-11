package com.practice.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SharedVar {
	public SharedVar(int j) {
		this.i = j;
	}

	public volatile int i;
}

class IteratorThread implements Runnable {
	List<String> sharedList;
	SharedVar sharedVar;

	public IteratorThread(List<String> sharedList, SharedVar i) {
		this.sharedList = sharedList;
		this.sharedVar = i;
	}

	@Override
	public void run() {
		synchronized (sharedList) {
			try {
				this.sharedVar.i++;
				while (!sharedList.isEmpty() && this.sharedVar.i<sharedList.size()) {
					String item = sharedList.get(this.sharedVar.i);
					if (item.startsWith("A")) {
						System.out.println("Notifying the action thread");
						sharedList.notify();
						System.out.println("IteratorThread calling wait on sharedList");
						sharedList.wait();
						
					} else
						this.sharedVar.i++;
				}
				System.out.println("Iterator thread finished its work");
			} catch (Exception e) {
				e.printStackTrace();
			}
			sharedList.notify();
		}
	}
}

class ActionThread implements Runnable {
	List<String> sharedList;
	SharedVar sharedVar;

	public ActionThread(List<String> sharedList, SharedVar i) {
		this.sharedList = sharedList;
		this.sharedVar = i;
	}

	@Override
	public void run() {
		synchronized (sharedList) {
			try {
//				sharedList.wait();
				while (!sharedList.isEmpty() && this.sharedVar.i<sharedList.size()) {
					if(this.sharedVar.i==-1) {
						sharedList.notify();
						sharedList.wait();
					}
					sharedList.remove((int)this.sharedVar.i);
					System.out.println("Bro i just removed an element. Now waiting for you dickhead..give me next");
					sharedList.notify();
					System.out.println("Action thread calling wait on sharedList");
					sharedList.wait();
					
				}
				System.out.println("I am having party today..just finished the whole list.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

public class MultiThreadingMain {
//	public static volatile Integer i = -1;
	public static void main(String[] args) throws Exception{
		List<String> sharedList = new ArrayList<>(Arrays.asList("Dheeraj","Aafreen","Romeo","Milkha","Asin","Salma","Menka","Bulla","Akabar","Asshole","Piku"));
		SharedVar sharedVar =new SharedVar(-1);
		Thread iteratorThread = new Thread(new IteratorThread(sharedList, sharedVar));
		Thread actionnThread = new Thread(new ActionThread(sharedList, sharedVar));
		
		iteratorThread.start();
		actionnThread.start();
		
		iteratorThread.join();
		actionnThread.join();
		System.out.println(sharedList);
	}
}
