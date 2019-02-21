package com.uttara.mvc;

public class Constants {

	
	public static int count_A=0;
	public static int count_B=0;
	public static int count_C=0;
	public static int count_D=0;
	public static boolean isPollAvailable=false;
	public static int getCount_A() {
		return count_A;
	}
	public static void setCount_A(int count_A) {
		Constants.count_A = count_A;
	}
	public static int getCount_B() {
		return count_B;
	}
	public static void setCount_B(int count_B) {
		Constants.count_B = count_B;
	}
	public static int getCount_C() {
		return count_C;
	}
	public static void setCount_C(int count_C) {
		Constants.count_C = count_C;
	}
	public static int getCount_D() {
		return count_D;
	}
	public static void setCount_D(int count_D) {
		Constants.count_D = count_D;
	}
	public static boolean isPollAvailable() {
		return isPollAvailable;
	}
	public static void setPollAvailable(boolean isPollAvailable) {
		Constants.isPollAvailable = isPollAvailable;
	}
	public static void clearValue() {
		// TODO Auto-generated method stub
		count_A=0;
		count_B=0;
		count_C=0;
		count_D=0;
	}
	
	
	
	
}
