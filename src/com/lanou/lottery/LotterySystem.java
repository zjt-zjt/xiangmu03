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
			System.out.println("���Ϊ"+money+"Ԫ");
			break;
		}
		case 2:{
			System.out.println("��ֵ�����50��20����10r��50����200��100");
			 int inputMoney = Chanrge();
			 int recharge = rellayCharge(inputMoney);
			 money+=recharge;
			 System.out.println("�˻����Ϊ"+money);
			break;
		}
		case 3:{
			if(money<2) {
				System.out.println("���㣬��ȥ��ֵ");
				break;
			} 
			
			 String type = ChooseLotteryType();
			 System.out.println("������");
			 int[] numbers = getNumber();
			 Lottery lottery = new Lottery(type, numbers[0], numbers[1], numbers[2]);
			 list.add(lottery);
			money-=2;
			break;
		}
		case 4:{
			System.out.println("������Ҫ�����ע��");
			Scanner scanner = new Scanner(System.in);
			int count = scanner.nextInt();
			while(true) {
				if(count<1) {
					System.out.println("���ٹ���һע�������¹���");
					 count = scanner.nextInt();
				}else {
					break;
				}
			}
			
			if(count>money) {
				System.out.println("��๺��"+count/2+"ע");
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
			System.out.println("�ѹ���"+count+"ע");
			break;
			 
			
		}
		case 5:{
			if(list.size()==0) {
				System.out.println("û�й���");
			}else {
				System.out.println("����ɹ�");
				for(Lottery t:list)
					System.out.println(t);
			}
			break;
		}
		case 6:{
			System.out.println("��ʾ��������");
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
			
			System.out.println("�Ƿ��˳�(Y/N)");
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
		System.out.println("..........��ҳ��..........");
		System.out.println("1.�鿴���");
		System.out.println("2.��ֵ");
		System.out.println("3.ֱѡ");
		System.out.println("4.��ѡ");
		System.out.println("5.�鿴�ѹ���Ĳ�Ʊ");
		System.out.println("6.����");
		System.out.println("7.�˳�");
		
	}
	
	public static int getChoose() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������0-7��ѡ��");
		int choose = scanner.nextInt();
		while(true) {
			if(choose<0||choose>7) {
				System.out.println("�����������������");
				choose = scanner.nextInt();
			}else {
				break;
			}
			
		}
		
		return choose;
		
	}
	
	public static int Chanrge() {
		System.out.println("��ѡ���ֵ���");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		while(true) {
			if(input<0) {
				System.out.println("��ֵʧ�ܣ�����������");
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
		System.out.println("��ѡ���Ʊ���ͣ�1.ֱѡ2.����");
		Scanner scanner  = new Scanner(System.in);
		int type = scanner.nextInt();
		while(true) {
			if(type<1||type>2) {
				System.out.println("ѡ�����������ѡ��");
				type = scanner.nextInt();
			}else {
				break;
			}
		}
		
		return type==1?"ֱѡ":"����";
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
				System.out.println("�����������������");
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
