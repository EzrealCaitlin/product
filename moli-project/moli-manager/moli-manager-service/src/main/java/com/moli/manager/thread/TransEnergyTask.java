package com.moli.manager.thread;
/**
 *
 * @author Liuk
 * @create_date 2018年2月3日
 *
 */
public class TransEnergyTask extends Thread {
	private EnergySystem energySystem;
	
	private double maxTrans;
	
	private int fromBox;
	
	public TransEnergyTask(EnergySystem energySystem, double maxTrans, int fromBox) {
		this.energySystem = energySystem;
		this.maxTrans = maxTrans;
		this.fromBox = fromBox;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				int to = (int) (energySystem.getBoxCount()*Math.random());
				double transEnergy = maxTrans*Math.random();
				energySystem.transEnergy(fromBox, to, transEnergy);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
