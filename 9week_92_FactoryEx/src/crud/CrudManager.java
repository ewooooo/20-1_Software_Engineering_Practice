package crud;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;
import mgr.Manager;

public class CrudManager extends Manager {
	Scanner keyin = null;
	public CrudManager(Scanner keyin) {
		this.keyin = keyin;
	}
	
	public void addOne(Crudable e) {
		e.readOnLine(keyin);
		mList.add(e);
		System.out.print("==> "); e.print();
		System.out.println("==> "+ e+" 추가되었습니다.");
	}
	public Crudable selectElem() {//?
		ArrayList<Manageable> arr = null;
		int indx = 1;
		System.out.print("==> 검색어 : ");
		String kwd = keyin.next();
		keyin.nextLine();
		arr = findAll(kwd);
		if (arr.size() == 0)
			return null;
		if (arr.size() == 1)
			return (Crudable)arr.get(indx-1);
		indx = 1;
		for (Manageable m : arr) {
			System.out.printf("[%d] ", indx++);
			m.print();
		}
		do {
			System.out.print("==> 번호를 고르시오... ");
			indx = keyin.nextInt();
		} while (indx <= 0 || indx > arr.size());
		Crudable e = (Crudable)arr.get(indx-1);
		return e;
	}
	public void removeOne() {
		Crudable e = selectElem();
		if (e == null) 
			return;
		System.out.print("==> "); e.print();
		if(!e.checkRemove()) {
			return;
		}
		System.out.print("==> 삭제하시겠습니까?(y/n) ");
		String sel = keyin.next();
		if(sel.equals("y"))
			if(mList.remove(e))
				System.out.println("==> "+ e+" 삭제되었습니다.");

	}
	public void updateOne() {
		Crudable e = selectElem();
		if (e == null) 
			return;
		System.out.print("==> "); e.print();
		e.update(keyin);
		System.out.println("==> "+ e+" 수정되었습니다.");
		e.print();
	}
}
