package item;
import java.util.Scanner;

import crud.Crudable;

public class Item implements Crudable {
	static int serialNo = 1;
	int id;
	String name;
	String code;
	int price;

	public void read(Scanner scan) {
		id = serialNo++;
		code = scan.next();
		name = scan.next();
		price = scan.nextInt();
	}

	public void print() {
		System.out.printf("[%d %s] %s (%d원)\n", 
				id, code, name, price);
	}
	public boolean matches(String kwd) {
		if (kwd.equals(id+""))
			return true;
		if (name.contains(kwd) || code.equals(kwd))
			return true;
		return false;
	}

	public void readOnLine(Scanner keyin) {
		System.out.print("==> 코드 상품명 가격: ");
		id = serialNo++;
		code = keyin.next();
		name = keyin.next();
		price = keyin.nextInt();
		
	}
	public boolean checkRemove() {
		if(price < 1000) {
			System.out.println("==> "+ this+" 1000원 이하 상품 삭제 불가");
			return false;
		}
		return true;
	}
	public void update(Scanner keyin) {
		System.out.println("==> 수정하지 않는 값은 - 표시 (예 - - 3000)");
		System.out.print("==> 코드 상품명 가격: ");
		String kwd = keyin.next();
		if(!kwd.equals("-"))
			code = kwd;
		kwd = keyin.next();
		if(!kwd.equals("-"))
			name = kwd;
		kwd = keyin.next();
		if(!kwd.equals("-"))
			price = Integer.parseInt(kwd);
	}
	@Override
	public String toString() {
		return name;
	}
	
}
