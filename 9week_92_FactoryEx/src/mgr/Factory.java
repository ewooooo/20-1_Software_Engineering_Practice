package mgr;

import java.util.Scanner;

public interface Factory<T extends Manageable> {
	T create(Scanner scan);
}
