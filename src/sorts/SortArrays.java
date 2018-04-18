package sorts;

public class SortArrays {
	private static long start;
	private static long finish;
	private static long[] arr = new long[1000];
	public static void main(String[] args) {

		
		for(int i = 0; i < 1000; i++) {
			int randomNumber = 0 + (int)(Math.random() * 1000);
			arr[i] = randomNumber;
		}
		
		
		
		ArraySel arraySel = new ArraySel(arr);
		arraySel.display();
		System.out.println("");
		
		start = System.nanoTime();
		arraySel.selectionSort();
		finish = System.nanoTime();
		
		System.out.println("Сортировка методом выборки выполнилась за: " + (finish - start) + " мс!");
		arraySel.display();
		
		System.out.println("\n");
		ArrayIns arrayIns = new ArrayIns(arr);
		
		start = System.nanoTime();
		arrayIns.insertionSort();
		finish = System.nanoTime();
		
		System.out.println("Сортировка методом вставки выполнилась за: " + (finish - start) + " мс!");
		arrayIns.display();
		System.out.println("\n");
		
		MergeSort mergeSort = new MergeSort(arr);
		
		start = System.nanoTime();
		mergeSort.mergeSort();
		finish = System.nanoTime();
		
		System.out.println("Сортировка слиянием выполнилась за: " + (finish - start) + " мс!");
		arrayIns.display();
		System.out.println("\n");
		
		ShellSort shellSort = new ShellSort(arr);
		
		start = System.nanoTime();
		shellSort.shellSort();
		finish = System.nanoTime();
		
		System.out.println("Сортировка Шелла выполнилась за: " + (finish - start) + " мс!");
		shellSort.display();
		System.out.println("\n");
	}
	
	
	public static void displayMass() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	
	

}
