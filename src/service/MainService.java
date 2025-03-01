package service;

import java.util.List;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new  MyLinkedList<>();
		try {
			linkedListForInt.add(45);
			linkedListForInt.add(-100);
			linkedListForInt.add(200);
			linkedListForInt.add(1);
			linkedListForInt.print();// 45 -100 200 1
			linkedListForInt.add(1000, 1);//1000 45 -100 200 1
			linkedListForInt.print();//1000 45  -100 200 1
			linkedListForInt.add(2000, 1);//2000 1000 45 -100 200 1
			linkedListForInt.print();//2000 1000 45 -100 200 1
			linkedListForInt.add(-33, 7);// 2000 1000 45 -100 200 1 -33
			linkedListForInt.print();// 2000 1000 45 -100 200 1 -33
			linkedListForInt.add(-777, 4);
			linkedListForInt.print();// 2000 1000 45 -777 -100 200 1 -33
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
