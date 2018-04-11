package stack.bracket_checker;

import stack.StackX;

/**
 * Программа для проверки парности скобок.
 * 
 * @author Dima Ropay
 *
 */
public class BracketChecker {

	private String input;

	public BracketChecker(String input) {
		this.input = input;
	}

	public void check() {

		int stackSize = input.length();
		StackX stackX = new StackX(stackSize);

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			switch (ch) {
			case '{':
			case '[':
			case '(':
				stackX.push(ch);
				break;

			case '}':
			case ']':
			case ')':
				if (!stackX.isEmpty()) {
					char chFromStack = stackX.pop();
					if ((ch == '}' && chFromStack != '{') || (ch == ']' && chFromStack != '[')
							|| (ch == ')' && chFromStack != '('))
						System.out.println("Error: " + ch + " at " + i);
				} else { // Преждевременная нехватка элементов
					System.out.println("Error: " + ch + " at " + i);
				}
				break;

			default:
				break;
			}
		}

		if (!(stackX.isEmpty()))

		{
			System.out.println("Error: missing right delimiter");
		}
	}

}
