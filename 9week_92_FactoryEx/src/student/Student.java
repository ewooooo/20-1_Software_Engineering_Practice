package student;

import java.util.Scanner;

import mgr.Manageable;
import mgr.Manager;

public class Student implements Manageable, Comparable<Student>{
	int id;
	String name;
	String dept;
	int year;
	String phone;
	public void read(Scanner in) {
		id = in.nextInt();
		name = in.next();
		dept = in.next();
		year = in.nextInt();
		phone = in.next();
	}
		
	public void print() {
		System.out.printf("%d %s %s %2d학년 %s%n", 
				id, name, dept, year, phone);
	}
	boolean compare(String kwd) {
		if (kwd.matches("-?\\d+")) {
			int temp = Integer.parseInt(kwd);
			if (id == temp) return true;
			if (year == temp) return true;
		}
		if (kwd.equals(name) || kwd.equals(dept) 
			|| kwd.equals(phone))
			return true;
		return false;
	}

	@Override
	public boolean matches(String kwd) {
		if (kwd.matches("[0-9]+")) {
			int intKwd = Integer.parseInt(kwd);
			if(intKwd == id || intKwd == year)
				return true;
		}
		if (name.contains(kwd) || kwd.equals(dept) || phone.contains(kwd))
			return true;
		return false;
	}

	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		if(name.equals(arg0.name)) {
			if(year>arg0.year)
				return 1;
			else if(year == arg0.year) 
				return 0;
			return -1;
		}
		return name.compareTo(arg0.name);
	}
}