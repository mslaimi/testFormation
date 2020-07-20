package com.example.demo.model;

import javax.persistence.Entity;

@Entity
public class Chercheur extends Emprunteur {
	private int currentEmp;
	private static final int maxEmp = 1;
	public int getCurrentEmp() {
		return currentEmp;
	}
	public void setCurrentEmp(int currentEmp) {
		this.currentEmp = currentEmp;
	}
	public static int getMaxemp() {
		return maxEmp;
	}
	@Override
	public boolean verifierLimite() {
		return (maxEmp-currentEmp>0);
	}
	
}
