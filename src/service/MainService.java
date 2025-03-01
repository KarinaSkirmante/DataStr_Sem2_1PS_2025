package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new  MyLinkedList<>();
		linkedListForInt.add(45);
		linkedListForInt.add(-100);
		linkedListForInt.add(200);
		linkedListForInt.add(1);
		
		
		try {
			linkedListForInt.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
