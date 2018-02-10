package com.moli.manager.thread;

/**
 * 开启3个线程，这3个线程的ID分别为A、B、C，每个线程将自己的ID在屏幕上打印10遍，
 * 要求输出结果必须按ABC的顺序显示；如：ABCABC….依次递推
 * @author Administrator
 *
 */
public class TestThread2 {
	private int flag = 1;
	
	public synchronized void sayA(){
		while(flag != 1){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("my name is " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = 2;
		this.notifyAll();
	}
	
	public synchronized void sayB(){
		while(flag != 2){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("my name is " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = 3;
		this.notifyAll();
	}
	
	public synchronized void sayC(){
		while(flag != 3){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("my name is " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = 1;
		this.notifyAll();
	}
	
	public static void main(String[] args) {
		final TestThread2 tt = new TestThread2();
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					tt.sayA();
				}
			}
		},"A").start();
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					tt.sayB();
				}
			}
		},"B").start();
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					tt.sayC();
				}
			}
		},"C").start();
	}
}

