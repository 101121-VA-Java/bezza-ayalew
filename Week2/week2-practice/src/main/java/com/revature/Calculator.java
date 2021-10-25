package com.revature;

public class Calculator {

	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	
	public double add(double x, double y) {
		return x + 1;
	}
	
	public double subtract(double x, double y) {
		return x-y;
	}
	
	public double multiply(double x, double y) {
		return x*y;
	}
	
	public double divide(double x, double y) {
		return x/y;
	}
	
	public boolean isPrime(int num) {
		if (num <= 1) {
            return false;
        }
		boolean res = false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res = false;
                break;
            }
  
        }
        return res;
	}
}
