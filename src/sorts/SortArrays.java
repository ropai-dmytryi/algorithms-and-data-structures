package sorts;

public class SortArrays {
	private static long start;
	private static long finish;
	private static long[] arr = new long[10];
	public static void main(String[] args) {

		
		for(int i = 0; i < 10; i++) {
			int randomNumber = 0 + (int)(Math.random() * 99);
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
	}
	
	
	public static void displayMass() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	
	

}
