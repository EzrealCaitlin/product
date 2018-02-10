package com.moli.manager.thread;
/**
 *
 * @author Liuk
 * @create_date 2018年2月3日
 *
 */
public class EnergySystem {
	
	private final Object objLock = new Object();
	
	private final double[] energyBox;
	
	public EnergySystem(int boxNum, double initEnergy) {
		energyBox = new double[boxNum];
		for(int i = 0; i < boxNum; i++){
			energyBox[i] = initEnergy;
		}
	}
	
	public void transEnergy(int from, int to, double transEnergy){
		synchronized (objLock) {
			while(energyBox[from] < transEnergy){
				try {
					objLock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			energyBox[from] = energyBox[from] - transEnergy;
			energyBox[to] = energyBox[to] + transEnergy;
			System.out.print(Thread.currentThread().getName());
			System.out.printf("==>%d号盒子向%d号盒子转移了%10.2f能量",from,to,transEnergy);
			System.out.printf("==>能量总和为%10.2f%n",sumEnergy());
			
			objLock.notifyAll();
		}
	}
	
	private double sumEnergy(){
		double sum = 0d;
		for(int i = 0; i < energyBox.length; i++){
			sum += energyBox[i];
		}
		return sum;
	}
	
	public int getBoxCount(){
		return energyBox.length;
	}
}
