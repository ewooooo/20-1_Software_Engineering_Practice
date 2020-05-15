package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

import song.DSong;
import song.Song;
import student.Student;
import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;


public class Main {
	public static void main(String[] args) {
		Main a = new Main();
		a.mymain();
	}
	Manager<Student> stMgr = new Manager<>();
	Manager<Song> songMgr = new Manager<>();
	Scanner scan = new Scanner(System.in);
	void mymain() {
		StFactory stfac = new StFactory();
		stMgr.readFile("students.txt", stfac);
		Collections.sort(stMgr.stList);
		songMgr.readFile("i-song.txt", new SongFactory());
		Collections.sort(songMgr.stList);
		stMgr.printAll();
		songMgr.printAll();
		search();
	}
	void search() {
		String kwd;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			stMgr.search(kwd);
			songMgr.search(kwd);
		}
	}
	class StFactory implements Factory<Student> {
		public Student create(Scanner scan) {
			return new Student();
		}
	}

	class SongFactory implements Factory<Song> {
		public Song create(Scanner scan) {
			int t = scan.nextInt();
			if (t == 1)
				return new Song();
			else
				return new DSong();
		}
	}
}







