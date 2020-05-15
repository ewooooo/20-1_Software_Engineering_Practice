package item;

import java.util.Scanner;

import crud.CrudManager;
//import crud.Crudable;
import mgr.Factory;
import mgr.Manageable;
//import mgr.Manager;

public class Main {

	Scanner keyin = new Scanner(System.in);
	CrudManager mgr = new CrudManager(keyin);



	void runMenu() {
		int menu = 1;
		while (menu != 0) {
			System.out.print("(1) 전체보기  (2) 추가   ");
			System.out.print("(3) 삭제   (4) 수정   (0) 종료 ");
			menu = keyin.nextInt();
			switch (menu) {
			case 1:
				mgr.printAll();
				break;
			case 2:
				mgr.addOne(new Item());
				break;
			case 3:
				mgr.removeOne();
				break;
			case 4:
				mgr.updateOne();
				break;
			default:
				break;
			}
		}
	}
	
	void doit() {
		CrudFactory cfactory = new CrudFactory();
		mgr.readAll("items.txt", cfactory);
		mgr.printAll();
		runMenu();
	}
	
	class CrudFactory implements Factory{
		@Override
		public Manageable create() {
			return new Item();
		}
		
	}
	public static void main(String[] args) {
		Main demo = new Main();
		demo.doit();
	}

}
