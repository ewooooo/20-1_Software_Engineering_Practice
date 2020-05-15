package song;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;


public class Main extends Manager implements Factory {
	public static void main(String[] args) {
		Main a = new Main();
		a.mymain();
	}
	Scanner scan = new Scanner(System.in);
	void mymain() {
		readFile("song.txt", this);
		printAll();
	}
	@Override
	public Manageable create(Scanner scan) {
		return new Song();
	}
}






