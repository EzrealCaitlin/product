package com.moli.manager.thread;

public class TestThread1 {
	public static void main(String[] args) {
		Student s = new Student();
		
		Thread setThread = new Thread(new SetStudent(s));
		Thread getThread = new Thread(new GetStudent(s));
		
		setThread.start();
		getThread.start();
	}
}

class Student{
	private String name;
	private int age;
	private boolean flag;//属性是否赋值
	
	public synchronized void getStudent(){
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//已赋值，则可以取里面的属性值
		System.out.println(this.name + "," + this.age);
		this.flag = false;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.notify();
	}
	
	public synchronized void setStudent(String name, int age){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//已赋值，则可以取里面的属性值
		this.name = name;
		this.age = age;
		this.flag = true;
		this.notify();
	}
}

class GetStudent implements Runnable{
	private Student student;
	
	GetStudent(Student student){
		this.student = student;
	}
	
	public void run() {
		while(true){
			this.student.getStudent();
		}
	}
}

class SetStudent implements Runnable{
	private Student student;
	
	private int temp = 0;
	
	SetStudent(Student student){
		this.student = student;
	}
	
	public void run() {
		while(true){
			if(this.temp % 2 == 0){
				this.student.setStudent("刘康", 24);
			}else{
				this.student.setStudent("彭梦君", 22);
			}
			temp ++;
		}
	}
}
