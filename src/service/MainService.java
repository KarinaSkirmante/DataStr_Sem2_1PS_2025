package service;

import java.util.List;

import datastr.MyLinkedList;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new  MyLinkedList<>();
		try {
			
			System.out.println("----------------ADD--------------");
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
			System.out.println("----------------DELETE--------------");
			linkedListForInt.remove(1);
			linkedListForInt.print();// 1000 45 -777 -100 200 1 -33
			linkedListForInt.remove(7);
			linkedListForInt.print();// 1000 45 -777 -100 200 1
			linkedListForInt.remove(3);
			linkedListForInt.print();// 1000 45 -100 200 1
			System.out.println("----------------GET--------------");
			System.out.println(linkedListForInt.get(3));//-100
			
			System.out.println("----------------SEARCH--------------");
			System.out.println("-100 ? -> " + linkedListForInt.search(-100));//true
			System.out.println("-3000 ? -> " + linkedListForInt.search(-3000));//false
			
			System.out.println("----------------MAKE EMPTY--------------");
			linkedListForInt.makeEmpty();
			linkedListForInt.add(-10000);
			linkedListForInt.print();//-10000
			
			System.out.println("-----------------------------------------");
			System.out.println("----------------STUDENTS-----------------");
			System.out.println("-----------------------------------------");
			//TODO veikt pāŗbaudi uz studentiem
			MyLinkedList<Student> linkedListForStudents = new MyLinkedList<>();

			Student st1 = new Student();// Lara Bernardes student
			Student st2 = new Student("Viktors", "Kokin", "123456-09876");
			Student st3 = new Student("Davyd", "Akimov", "121298-67894");
			
			System.out.println("----------------ADD--------------");
			linkedListForStudents.add(st1);//Lara
			linkedListForStudents.add(st2, 1);//Viktors Lara
			linkedListForStudents.add(st3,1);//Davyd Viktors Lara
			linkedListForStudents.print();//Davyd Viktors Lara
			System.out.println("----------------DELETE--------------");
			linkedListForStudents.remove(2);//Viktors tiks dzēsts
			linkedListForStudents.print();//Davyd Lara
			System.out.println("----------------GET--------------");
			System.out.println(linkedListForStudents.get(2));//Lara
			System.out.println("----------------SEARCH--------------");
			System.out.println("Vai Davyds ir sarakstā ? -> " + linkedListForStudents.search(st3));//true
			System.out.println("Vai Viktors ir sarakstā ? -> " + linkedListForStudents.search(st2));//false

			System.out.println("----------------MAKE EMPTY--------------");
			linkedListForStudents.makeEmpty();
			linkedListForStudents.add(new Student("Janis", "Berzins", "123456-65432"));
			linkedListForStudents.print();//Janis
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
