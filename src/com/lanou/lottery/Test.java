package com.lanou.lottery;


import java.util.List;
import java.util.Scanner;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Test {

	public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
		Scanner scanner  = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		boolean exit =false;
		while(exit==false) {
			Menu();
			int c = choose();
			
			switch (c) {
			case 1:{
				System.out.println("����������");
				String name = scanner.nextLine();
				System.out.println("�������ֻ���");
				String phone = scanner.nextLine();
				Contact a = new Contact(name, phone);
				addressBook.addContact(a);
				
				
				break;
			}
			case 2:{
				addressBook.showAllContact();
				
				break;
			}	
			case 3:{
				System.out.println("һ���ѯ");
				String group = scanner.nextLine();
				List<Contact> list = addressBook.findContactsByGroup(group);
				addressBook.showContact(list);
				
				break;
			}
			case 4:{
				System.out.println("�����ֲ���");
				String name = scanner.nextLine();
				List<Contact> list = addressBook.findContactsByGroup(name);
				addressBook.showContact(list);
				
				break;
			}
			case 5:{
				System.out.println("���������");
				String number = scanner.nextLine();
				List<Contact> list = addressBook.findContactsByGroup(number);
				addressBook.showContact(list);
				break;
			}
			case 6:{
				System.out.println("����µ����ֺ��ֻ���");
				String name = scanner.nextLine();
				System.out.println("ԭ������");
				String newName = scanner.nextLine();
				System.out.println("����µ�����");
				String phone = scanner.nextLine();
				Contact h = new Contact(newName, phone);
				addressBook.modify(name, h);
				System.out.println();
				
				break;
			}
			case 7:{
				System.out.println("������ɾ��");
				String name = scanner.nextLine();
				addressBook.deleteContact(name);
				break;
			}
			case 8:{
				System.out.println("��Ҫ�˳���Y/N");
				String string = scanner.next();
				if(string.equalsIgnoreCase("Y")) {
				exit = 	true;
				}
				break;
			}
			
			}
		}
		

	}

	
	public static void Menu() {
		System.out.println(".............ͨѶ¼.............");
		System.out.println("1.�����ϵ��");
		System.out.println("2.��ʾ��ϵ��");
		System.out.println("3.����������");
		System.out.println("4.�����ֲ���");
		System.out.println("5.���������");
		System.out.println("6.�޸���ϵ��");
		System.out.println("7.ɾ��");
		System.out.println("8.�˳�");
	}
	
	public static int choose() {
		System.out.println("������1-8��ѡ��");
		Scanner scanner  = new Scanner(System.in);
		int choose = scanner.nextInt();
		while(true) {
			if(choose<1||choose>8) {
				System.out.println("�����������������");
				choose = scanner.nextInt();
			}else {
				break;
			}
		}
		
		return choose;
	}
	
	
}
