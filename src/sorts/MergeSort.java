package sorts;
/**
 * Рекурсивная реализация сортировки слиянием
 * Скорость - O(N * log(N))
 * @author dima
 *
 */
public class MergeSort {
	
	private long[] theArray;
	private int nElems;
	
	public MergeSort(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public MergeSort(long [] theArray) {
		this.theArray = theArray;
		this.nElems = theArray.length;
	}
	
	public void insert(long value) {
		theArray[nElems++] = value;
	}
	
	public void display() {
		for(int j = 0; j < nElems; j++) 
			System.out.print(theArray[j] + " ");
		System.out.println("");
	}
	
	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}
	
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		
		if(lowerBound == upperBound) { //Если один елемент, сортировка не требуется
			return;
		} else {
			
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid); //Сортировка нижней половины
			recMergeSort(workSpace, mid + 1, upperBound); //Сортировка верхней половины
			merge(workSpace, lowerBound, mid +1, upperBound); //Слияние
		}
	}
	
	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr -1;
		int n = upperBound - lowerBound + 1; //Ко-во элеменов
		
		while(lowPtr <= mid && highPtr <= upperBound) {
			if(theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];
			
			while(lowPtr <= mid)
				workSpace[j++] = theArray[lowPtr++];
			
			while(highPtr <= upperBound)
				workSpace[j++] = theArray[highPtr++];
			
			for(j = 0; j < n; j++) {
				theArray[lowerBound + j] = workSpace[j];
			}
		}
	}

}
