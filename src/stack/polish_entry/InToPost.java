package stack.polish_entry;

import stack.StackX;

/**
 * Класс для перевода выражения из интфиксной записи в постфиксную.
 * 
 * @author Dima Ropay
 *
 */
public class InToPost {

	private StackX stackX;
	private String input;
	private String output = "";

	public InToPost(String input) {
		this.input = input;
		int stackSize = input.length();
		stackX = new StackX(stackSize);
	}

	public String doTrans() {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			stackX.displayStack("For " + ch + " ");

			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				stackX.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		}

		while (!stackX.isEmpty()) {
			stackX.displayStack("While ");
			output = output + stackX.pop();
		}

		stackX.displayStack("End ");
		return output;
	}

	public void gotOper(char opThis, int prec1) {

		while (!stackX.isEmpty()) {
			char opTop = stackX.pop();
			if (opTop == '(') {
				stackX.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;

				if (prec2 < prec1) {
					stackX.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		stackX.push(opThis);
	}

	public void gotParen(char ch) {
		while (!stackX.isEmpty()) {
			char chx = stackX.pop();
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}
}
