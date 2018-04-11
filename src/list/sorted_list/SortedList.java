package list.sorted_list;
/**
 * Сортированный список
 * Вставка/удаление - O(N) в среднем О(N/2)
 * @author dima
 *
 */
public class SortedList {

	private Link first;
	
	public SortedList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insert(long key) {
		Link newLink = new Link(key);
		Link previos = null;
		Link current = first;
		
		while(current != null && key > current.dData) {
			previos = current;
			current = current.next;
		}
		if(previos == null) {
			first = newLink;
		} else {
			previos.next = newLink;
		}
		newLink.next = current;
	}
	
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	public void displayList() {
		System.out.println("List (first --> last): ");
		Link current = first;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
