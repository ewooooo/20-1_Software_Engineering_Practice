package crud;

import java.util.Scanner;

import mgr.Manageable;

public interface Crudable extends Manageable {
	void readOnLine(Scanner keyin);
	boolean checkRemove();
	void update(Scanner keyin);
}
