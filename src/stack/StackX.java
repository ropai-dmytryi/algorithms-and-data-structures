package stack;

public class StackX {

	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackX(int s) {
		this.maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char elem) {
		stackArray[++top] = elem;
	}

	// extraction element
	public char pop() {
		return stackArray[top--];
	}

	// Read element
	public char peek() {
		return stackArray[top];
	}

	public char peekN(int n) {
		return stackArray[n];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isMaxSize() {
		return (top == maxSize - 1);
	}

	public int size() {
		return top + 1;
	}

	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (bottom --> top): ");
		for (int i = 0; i < size(); i++) {
			System.out.print(peekN(i));
			System.out.print(' ');
		}
		System.out.println("");
	}

}
