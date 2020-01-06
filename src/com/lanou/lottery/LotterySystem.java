package com.lanou.lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LotterySystem {

	public static void main(String[] args) {
		List<Lottery> list = new ArrayList<>();
		boolean isExit = false;
		int money = 100;
		while (isExit == false) {
			Menu();
		int choose = getChoose();
		switch (choose) {
		case 1:{
			System.out.println("余额为"+money+"元");
			break;
		}
		case 2:{
			System.out.println("充值活动，充50送20，充10r送50，充200送100");
			 int inputMoney = Chanrge();
			 int recharge = rellayCharge(inputMoney);
			 money+=recharge;
			 System.out.println("账户余额为"+money);
			break;
		}
		case 3:{
			if(money<2) {
				System.out.println("金额不足，请去充值");
				break;
			} 
			
			 String type = ChooseLotteryType();
			 System.out.println("请输入");
			 int[] numbers = getNumber();
			 Lottery lottery = new Lottery(type, numbers[0], numbers[1], numbers[2]);
			 list.add(lottery);
			money-=2;
			break;
		}
		case 4:{
			System.out.println("请输入要购买的注数");
			Scanner scanner = new Scanner(System.in);
			int count = scanner.nextInt();
			while(true) {
				if(count<1) {
					System.out.println("最少购买一注，请重新购买");
					 count = scanner.nextInt();
				}else {
					break;
				}
			}
			
			if(count>money) {
				System.out.println("最多购买"+count/2+"注");
				break;
			}
			 String type = ChooseLotteryType();
			 Random random  = new Random();
			 for(int i =0;i<count;i++) {
				 int a = random.nextInt(10);
				 int b = random.nextInt(10);
				 int c = random.nextInt(10);
				 Lottery lottery = new Lottery(type, a, b, c);
				 list.add(lottery);
				 
			 }
			money-=count*2;
			System.out.println("已购买"+count+"注");
			break;
			 
			
		}
		case 5:{
			if(list.size()==0) {
				System.out.println("没有购买");
			}else {
				System.out.println("购买成功");
				for(Lottery t:list)
					System.out.println(t);
			}
			break;
		}
		case 6:{
			System.out.println("显示开奖号码");
			int[] number = getPrizeNumber();
			System.out.println(number[0]+" "+number[1]+" "+number[2]);
			for(Lottery t:list) {
				int prize = t.checkNumber(number);
				money+=prize;
			}
			list.clear();
			break;
		}
		case 7:{
			
			System.out.println("是否退出(Y/N)");
			Scanner scanner = new Scanner(System.in);
			String string  = scanner.nextLine().toUpperCase();
			if(string.equals("Y")) {
				isExit = true;
			}
			
			break;
		}
		}
		
		
		
		
		}
		

	}

	public static void Menu() {
		System.out.println("..........主页面..........");
		System.out.println("1.查看余额");
		System.out.println("2.充值");
		System.out.println("3.直选");
		System.out.println("4.机选");
		System.out.println("5.查看已购买的彩票");
		System.out.println("6.开奖");
		System.out.println("7.退出");
		
	}
	
	public static int getChoose() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入0-7的选择");
		int choose = scanner.nextInt();
		while(true) {
			if(choose<0||choose>7) {
				System.out.println("输入错误，请重新输入");
				choose = scanner.nextInt();
			}else {
				break;
			}
			
		}
		
		return choose;
		
	}
	
	public static int Chanrge() {
		System.out.println("请选择充值金额");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		while(true) {
			if(input<0) {
				System.out.println("充值失败，请重新输入");
				input = scanner.nextInt();
			}else {
				break;
			}
		}
		
		 return input;
		
	}
	
	private static int rellayCharge(int input) {
		int account  = 0;
		if(input<50) {
			account = input;
		}else if(input>=50&&input<100) {
			account = input+20;
		}else if(input >=100&&input<200) {
			account = input+50;
		}else {
			account = input+100;
		}
		
		return account;
	}
	
	public static String ChooseLotteryType() {
		System.out.println("请选择彩票类型，1.直选2.组六");
		Scanner scanner  = new Scanner(System.in);
		int type = scanner.nextInt();
		while(true) {
			if(type<1||type>2) {
				System.out.println("选择错误，请重新选择");
				type = scanner.nextInt();
			}else {
				break;
			}
		}
		
		return type==1?"直选":"组六";
	}
	
	public static int[] getNumber() {
		Scanner scanner = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		while(true) {
			num1 = scanner.nextInt();
			num2 = scanner.nextInt();
			num3 = scanner.nextInt();
			if(num1>=0&&num1<9&&num2>=0&&num2<9&&num3>=0&&num3<9) {
				break;
			}else {
				System.out.println("输入错误，请重新输入");
			}
		}
		int[] number = new int[3];
		number[0] = num1;
		number[1] = num2;
		number[2] = num3;
		return number;
		
	}
	
	public static int[] getPrizeNumber() {
		Random random  = new Random();
		int a =random.nextInt(10);
		int b =random.nextInt(10);
		int c =random.nextInt(10);
		int[] number = {a,b,c};
		
		return number;
	}
	
	
}
