package com.moli.manager.thread;

public class TestThread {

	public static void main(String[] args) {
//		new Thread(new Runnable(){
//			public void run() {
//				System.out.println("i am Runnable");
//			}
//		}){
//			public void run() {
//				System.out.println("i am Thread");
//				super.run();
//			}
//		}.start();
//		
//		MyRunnable mr = new MyRunnable();
//		mr.run();
//		
//		System.out.println("-----------");
//		
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread thread = new Thread(new MyRunnable());
//		thread.start();
		
		System.out.println("--------------我是分割线--------------");
		
		final MyThread1 thread1 = new MyThread1();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				for(int i = 0; i < 5; i++){
					thread1.sub();
				}
			}
		});
		
		t1.start();
		t1.isDaemon();
		
		for(int j = 0; j < 5; j++){
			thread1.main();
		}
		
//		System.out.println("------------i:"+thread1.getI());
	}

}


class MyRunnable implements Runnable{

	public void run() {
		for(int i = 0; i < 10 ; i++){
			System.out.println("i am i:" +i);
		}
		System.out.println("i am Runnable");
	}
	
}

class MyThread extends Thread{
	public void run() {
		for(int j = 0; j < 10 ; j++){
			System.out.println("i am j:" +j);
		}
		System.out.println("i am Thread");
	}
}


class MyThread1{
	private boolean flag = true;
	private int i = 0;
	
	public synchronized void sub(){
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j = 1; j <= 10; j++){
			System.out.println("sub "+j);
			this.i++;
		}
		
		flag = true;
		this.notify();
	}
	
	public synchronized void main(){
		while(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int j = 1; j <= 20; j++){
			System.out.println("main "+j);
			this.i++;
		}
		
		flag = false;
		this.notify();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
