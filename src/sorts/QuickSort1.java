package sorts;

/**
 * Простая версия быстрой сортировки (Хоара)
 * O(N*log(N))
 * @author dima
 *
 */
public class QuickSort1 {

	private long[] theArray;
	private int nElems;

	public QuickSort1(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public QuickSort1(long[] theArray) {
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
	}

	public void recQuickSort(int left, int right) {
		if (right - left <= 0) { //Если рамер <= 1 массив отсортирован
			return;
		} else { //Если размер 2 и более
			long pivot = theArray[right];//крайний правый елемент
			int partition = partitionIt(left, right, pivot);//разбиение диапазона
			recQuickSort(left, partition - 1);//Сортировка левой части
			recQuickSort(partition + 1, right);//Сортировка правой части
		}
	}

	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1; //левая граница после++
		int rightPtr = right; //правая граница -1 
		
		while(true) { 
			while(theArray[++leftPtr] < pivot); //поиск большего елемента
			while(rightPtr > 0 && theArray[--rightPtr] > pivot); //поиск меньшего елемента
			
			if(leftPtr >= rightPtr) //Если указатели сошлись, то разбиение закончилось
				break;
			else
				swap(leftPtr, rightPtr); //в противном случае менять местами
		}
		swap(leftPtr, right);//перестановка опорного элемента
		return leftPtr;//возврат позиции опорного элемента
	}
	
	public void swap(int dex1, int dex2) {
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}

}
