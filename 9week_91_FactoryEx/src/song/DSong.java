package song;

import java.util.Scanner;

public class DSong extends Song {
	String lyric;
	@Override
	public void read(Scanner scan) {
		super.read(scan);
		lyric = scan.nextLine();
	}
	@Override
	public void print() {
		super.print();
		System.out.println('\t'+lyric);
	}
	@Override
	public boolean matches(String n) {
		if (super.matches(n))
			return true;
		return lyric.contains(n);
	}

}
