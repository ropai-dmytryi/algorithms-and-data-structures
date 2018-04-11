package stack.polish_entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntfixApp {

	public static void main(String[] args) throws IOException {

		String input, output;

		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();

			input = getString();
			if (input.equals(""))
				break;

			InToPost inToPost = new InToPost(input);
			output = inToPost.doTrans();

			System.out.println("Postfix is " + output + "\n");

		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String inputString = br.readLine();
		return inputString;
	}

}
