package com.practice.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class Even implements Runnable {
	private List<Integer> nums;
	public Even(List<Integer> nums) {
		this.nums = nums;
	}
	@Override
	public void run() {
		synchronized (nums) {
			try {
				nums.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			for(int i=2;i<=10;i+=2) {
				nums.add(i);
				nums.notify();
				try {
					nums.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nums.notify();
		}
	}
	
}

class Odd implements Runnable {
	private List<Integer> nums;
	public Odd(List<Integer> nums) {
		this.nums = nums;
	}
	@Override
	public void run() {
		synchronized (nums) {
			for(int i=1;i<10;i+=2) {
				nums.add(i);
				nums.notify();
				try {
					nums.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			nums.notify();
		}
	}
	
}
public class EvenOdd {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> nums = new ArrayList<>();
		Thread even = new Thread(new Even(nums));
		Thread odd = new Thread(new Odd(nums));
		even.start();
		odd.start();
		even.join();
		odd.join();
		System.out.println(nums);
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("ramya", "fsk");
		ConcurrentHashMap<String, String> con = new ConcurrentHashMap<>();
		con.put("name", "name");
	}
}
