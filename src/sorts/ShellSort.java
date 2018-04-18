package sorts;
/**
 * Сортировка Шелла
 * В интервале от O(N^3/2) до O(N^7/6)
 * @author dima
 *
 */
public class ShellSort {

	private long[] theArray;
	private int nElems;

	public ShellSort(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public ShellSort(long[] theArray) {
		this.theArray = theArray;
		this.nElems = theArray.length;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		System.out.print("A = ");
		for (int i = 0; i < theArray.length; i++)
			System.out.print(theArray[i] + " ");
		System.out.println("");
	}

	public void shellSort() {
		int inner, outer;
		long temp;
		int h = 1;

		while (h <= nElems / 3)
			h = h * 3 + 1;

		while (h > 0) { //Уменьшение h до 1
			//h сортировка
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;

				while (inner > h - 1 && theArray[inner - h] >= temp) { //Для подмасивов
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
}
