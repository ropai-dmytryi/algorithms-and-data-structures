package threes.three234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234App {

	public static void main(String[] args) throws IOException {
		long value;
		Tree234 theTree = new Tree234();

		theTree.inser(50);
		theTree.inser(40);
		theTree.inser(60);
		theTree.inser(30);
		theTree.inser(70);

		while (true) {
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, or find: ");

			char choice = getChar();
			switch (choice) {

			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.println("Enter value to insert: ");
				value = getInt();
				theTree.inser(value);
				break;
			case 'f':
				System.out.println("Enter value to find: ");
				value = getInt();
				int found = theTree.find(value);
				if (found != -1)
					System.out.println("Found " + value);
				else
					System.out.println("Could not find " + value);
				break;
			default:
				System.out.print("Invalid entry\n");
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
