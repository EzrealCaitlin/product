package com.moli.manager.thread;
/**
 *
 * @author Liuk
 * @create_date 2018年2月3日
 *
 */
public class TransMain {

	public static void main(String[] args) {
		EnergySystem energySystem = new EnergySystem(100, 1000);
		
		for(int i = 0; i < 100 ; i++){
			TransEnergyTask task = new TransEnergyTask(energySystem, 1000, i);
			task.setName("Thread_"+i);
			task.start();
		}
	}

}
