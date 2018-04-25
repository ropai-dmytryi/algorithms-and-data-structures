package sorts;
/**
 * Быстрая сортировка с применением сортировки методом вставки
 * @author dima
 *
 */
public class QuickSort3 {

	private long[] theArray;
	private int nElems;

	public QuickSort3(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public QuickSort3(long[] theArray) {
		this.theArray = theArray;
		nElems = theArray.length;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < theArray.length; i++)
			System.out.print(theArray[i] + " ");
		System.out.println("");
	}

	public void quickSort() {
		recQuickSort(0, nElems - 1);
		// insertionSort(0, nElems - 1);
	}

	public void recQuickSort(int left, int right) {
		int size = right - left + 1;
		if (size < 10)
			insertionSort(left, right);
		else {
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}
	
	public long medianOf3(int left, int right) { //Определение медианы
		int center = (left + right) / 2;

		if (theArray[left] > theArray[center]) //Упорядочение left и center
			swap(left, center);

		if (theArray[left] > theArray[right]) //Упорядочение left и right
			swap(left, right);

		if (theArray[center] > theArray[right]) //Упорядочение center и right
			swap(center, right);

		swap(center, right - 1); //размещение медианы на правом краю
		return theArray[right - 1]; //Метод возвращает медиану
	}

	public void swap(int dex1, int dex2) { //Перестановка
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left; //Справа от первого элемента
		int rightPtr = right - 1; //Слева от опорного элемента

		while (true) {
			while (theArray[++leftPtr] < pivot) //Поиск большего элемента
				;

			while (theArray[--rightPtr] > pivot) //Поиск меньшего элемента
				;

			if (leftPtr >= rightPtr)//Если указатели сошлись, разбиение закончилось
				break;
			else //В противном случае поменять элементы местами
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1); //Восстановление опорного элемента
		return leftPtr; //Позиция разбиения
	}
	/**
	 * Сортировка методом вставки
	 * @param left
	 * @param right
	 */
	public void insertionSort(int left, int right) {
		int in, out;
		
		for(out = left + 1; out <= right; out++) {
			long temp = theArray[out];
			in = out;
			
			while(in > left && theArray[in-1] >= temp) {
				theArray[in] = theArray[in - 1];
				--in;
			}
			theArray[in] = temp;
		}
	}
}
