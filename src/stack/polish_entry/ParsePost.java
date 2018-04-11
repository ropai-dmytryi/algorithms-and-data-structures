package stack.polish_entry;

import stack.StackXForInteger;

/**
 * Парсинг постфиксного выражения.(Зачем я это делаю?)
 * @author Dima Ropay
 *
 */
public class ParsePost {

	private StackXForInteger theStack;
	private String input;
	
	public ParsePost(String string) {
		this.input = string;
	}
	
	public int doParse() {
		theStack = new StackXForInteger(20);
		char ch;
		int j;
		int num1, num2, interAns;
		
		for(j = 0; j < input.length(); j++) {
			ch = input.charAt(j);
			theStack.displayStack("" + ch + " ");
			if(ch >= '0' && ch <= '9')
				theStack.push((char)(ch-'0'));
			else {
				num2 = theStack.pop();
				num1 = theStack.pop();
				switch (ch) {
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
				}
				theStack.push((char) interAns);
			}
		}
		interAns = theStack.pop();
		return interAns;
	}
}
