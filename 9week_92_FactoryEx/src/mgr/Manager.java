package mgr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	protected ArrayList<Manageable> mList = new ArrayList<>();
	public void readAll(String filename,Factory fac) {
		Manageable st = null;
		Scanner fs = openFile(filename);
		while (fs.hasNext()) {
			st = fac.create();
			st.read(fs);
			if (mList.contains(st))
				continue;
			mList.add(st);
		}
		fs.close();
	}
	public void printAll() {
		for (Manageable st : mList)
			st.print();
	}
	
	
	//?
	public ArrayList<Manageable> findAll(String kwd) {
		ArrayList<Manageable> returnArr = new ArrayList<>();
		for(Manageable m :mList) {
			if(m.matches(kwd))
				returnArr.add(m);
		}
		return returnArr;
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
	public void search(String kwd) {
		for (Manageable st : mList)
			if(st.matches(kwd))
				st.print();
	}
}
