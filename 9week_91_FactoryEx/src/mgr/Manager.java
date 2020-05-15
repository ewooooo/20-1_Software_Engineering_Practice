package mgr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import student.Student;
import student.StudentMain;

public class Manager<T extends Manageable> {	
	public ArrayList<T> stList = new ArrayList<>();
	
	public void readFile(String filename, Factory<T> fac) {
		T m = null;
		Scanner fs = openFile(filename);
		while (fs.hasNext()) {
			m = fac.create(fs);
			m.read(fs);
			if (stList.contains(m))
				continue;
			stList.add(m);
		}
		fs.close();
	}
	public void printAll() {
		for (T st : stList)
			st.print();
	}
	private Scanner openFile(String filename) {
	    Scanner scan = null;
	    try{
	    	scan = new Scanner(new File(filename));
	    } catch(FileNotFoundException e){
	    	throw new RuntimeException(e);
	    }
	    scan.nextLine();
	    return scan;
	}
	
	public T find(String kwd) {
		for (T m : stList)
			if (m.matches(kwd))
				return m;
		return null;
	}
	public ArrayList<T> findAll(String kwd) {
		ArrayList<T> resultList = new ArrayList<>();
		// var resultList = new ...  Java 9
		for (T m : stList)
			if (m.matches(kwd))
				resultList.add(m);
		return resultList;
	}
	public void search(String kwd) {
		for (T m : stList)
			if (m.matches(kwd))
				m.print();
	}
}






