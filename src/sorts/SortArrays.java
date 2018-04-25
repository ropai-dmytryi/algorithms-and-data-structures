package sorts;

public class SortArrays {
	private static long start;
	private static long finish;
	private static long[] arr = new long[100];
	public static void main(String[] args) {

		
		for(int i = 0; i < 100; i++) {
			int randomNumber = 0 + (int)(Math.random() * 100);
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
		
		QuickSort1 quickSort1 = new QuickSort1(arr);
		
		start = System.nanoTime();
		quickSort1.quickSort();
		finish = System.nanoTime();
		
		System.out.println("Быстрая сортировка (Хоара) выполнилась за: " + (finish - start) + " мс!");
		quickSort1.display();
		System.out.println("\n");
		
		QuickSort2 quickSort2 = new QuickSort2(arr);
		
		start = System.nanoTime();
		quickSort2.quickSort();
		finish = System.nanoTime();
		
		System.out.println("Быстрая сортировка с определением медианы по трем точкам выполнилась за: " + (finish - start) + " мс!");
		quickSort2.display();
		System.out.println("\n");
		
		QuickSort3 quickSort3 = new QuickSort3(arr);
		
		start = System.nanoTime();
		quickSort3.quickSort();
		finish = System.nanoTime();
		
		System.out.println("Быстрая сортировка с применением сортировки методом вставки выполнилась за: " + (finish - start) + " мс!");
		quickSort3.display();
		System.out.println("\n");
	}
	
	
	public static void displayMass() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	
	

}
