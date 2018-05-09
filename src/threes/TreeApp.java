package threes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Приложение для работы с двоичным деревом
 * 
 * @author dima
 *
 */
public class TreeApp {
	public static void main(String[] args) throws IOException {
		int value;
		Tree theThree = new Tree();
		theThree.insert(50, 1.5);
		theThree.insert(25, 1.2);
		theThree.insert(75, 1.7);
		theThree.insert(12, 1.5);
		theThree.insert(37, 1.2);
		theThree.insert(43, 1.7);
		theThree.insert(30, 1.5);
		theThree.insert(33, 1.2);
		theThree.insert(87, 1.7);
		theThree.insert(93, 1.5);
		theThree.insert(97, 1.5);

		while (true) {
			System.out.print("Enter first letter of show, ");
			System.out.print("intert, find, delete, or traverse");
			int choise = getChar();
			switch (choise) {
			case 's':
				theThree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				theThree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				Node found = theThree.find(value);
				if (found != null) {
					System.out.print("Found: ");
					found.displayNode();
					System.out.println("\n");
				}
				break;
			case 'd':
				System.out.print("Enter value to delete: ");
				value = getInt();
				theThree.delete(value);
				theThree.displayTree();
				break;
			case 't':
				System.out.print("Enter type of travesre: ");
				value = getInt();
				theThree.traverse(value);
				break;
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
