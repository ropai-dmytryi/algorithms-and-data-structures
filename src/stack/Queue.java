package stack;

/**
 * Простая очередь.
 * 
 * @author Dima Ropay
 *
 */
public class Queue {

	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}

	/**
	 * Вставка в конец очереди.
	 * 
	 * @param j
	 *            - елемент
	 */
	public void insert(long j) {
		if (rear == maxSize - 1)
			rear = -1;

		queArray[++rear] = j;
		nItems++;
	}

	/**
	 * Извлечение элемента в начале очереди.
	 * 
	 * @return - элементе начала очереди
	 */
	public long remove() {
		long temp = queArray[front++];
		if (front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}

	/**
	 * Чтение эл начала очереди
	 * 
	 * @return - елемент начала очереди
	 */
	public long peekFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int size() {
		return nItems;
	}

}
