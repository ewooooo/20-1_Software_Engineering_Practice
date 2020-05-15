package student;

import java.util.Scanner;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class StudentMain extends Manager implements Factory{
	public static void main(String[] args) {
		StudentMain a = new StudentMain();
		a.doit();
	}
	public Manageable create(Scanner scan) {
		return new Student();
	}
		
	void doit() {
		readFile("students.txt", this);
		printAll();
	}

}