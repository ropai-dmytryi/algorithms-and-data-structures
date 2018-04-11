package stack;

public class StackXForInteger {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public StackXForInteger(int s) {
		this.maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(char elem) {
		stackArray[++top] = elem;
	}

	// extraction element
	public int pop() {
		return stackArray[top--];
	}

	// Read element
	public int peek() {
		return stackArray[top];
	}

	public int peekN(int n) {
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
