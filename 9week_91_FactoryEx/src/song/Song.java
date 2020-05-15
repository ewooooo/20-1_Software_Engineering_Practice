package song;

import java.util.Scanner;

import mgr.Manageable;

public class Song implements Manageable {
	// 1 ��� ���� 2015
	int id;
	String name;
	String songTitle;
	int year;
	@Override
	public void read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		songTitle = scan.next();
		year = scan.nextInt();		
	}
	@Override
	public void print() {
		System.out.printf("[%2d] %s %s (%d년)\n",
				id, name, songTitle, year);
	}
	@Override
	public boolean matches(String n) {
		if (songTitle.contains(n))
			return true;
		return name.equals(n);
	}
}