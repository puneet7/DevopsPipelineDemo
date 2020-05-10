package com.calculator;

public class Calculator {

	public static void main(String[] args){
		System.out.println("7 + 7 = " + add(7, 7));
		System.out.println("7 - 7 = " + subtract(7,7));
		System.out.println("7 / 7 = " + divide(7,7));
		System.out.println("7 * 7 = " + multiply(7,7));
	}
	
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int subtract(int a, int b) {
		return a - b;
	}

	public static long multiply(int a, int b) {
		return a * b;
	}

	public static double divide(int a, int b) {
		double result;
		if (b == 0) {
			throw new IllegalArgumentException("Divisor cannot divide by zero");
		} else {
			result = Double.valueOf(a)/Double.valueOf(b);
		}
		return result;
	}
}
