package com.lanou.lottery;

import java.util.Arrays;

public class Lottery {
	private String type;
	private int num1;
	private int num2;
	private int num3;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	
	
	
	public Lottery(String type, int num1, int num2, int num3) {
		super();
		this.type = type;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	public Lottery() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return num1 + " " + num2 + " " + num3 + " " + type;
	}
	
		public int checkNumber(int[] number) {
			if(type.equals("Ö±Ñ¡")) {
				if(num1==number[0]&&num2==number[1]&&num3==number[2]) {
					System.out.println(num1+" "+num2+" "+num3+"  "+"ÖÐ½±1000Ôª");
					return 1000;
				}else {
					System.out.println(num1+" "+num2+" "+num3+"  "+"Ð»Ð»»Ý¹Ë");
					return 0;
				}
			}else {
				int[] type1 = {num1,num2,num3};
				Arrays.sort(type1);
				int[] type2 = {number[0],number[1],number[2]};
				Arrays.sort(type2);
				Boolean isEqual = Arrays.equals(type2, type1);
				if(isEqual==true) {
					System.out.println(num1+" "+num2+" "+num3+"  "+"ÖÐ½±160");
					return 160;
					
				}else {
					System.out.println(num1+" "+num2+" "+num3+"  "+"Ð»Ð»»Ý¹Ë");
					return 0;
				}
			}
			
		}
	
	
}
