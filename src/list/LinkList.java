package list;
/**
 * Реализация связного списка
 * @author Dima Ropay
 *
 */
public class LinkList {

	private Link first;
	
	public LinkList() {
		
	}
	
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	public Link find(int key) {
		Link current = first;
		while(current.iData != key) {
			if(current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previos = first;
		while(current.iData != key) {
			if(current.next == null) {
				return null;
			} else {
				previos = current;
				current = current.next;
			}
		}
		
		if(current == first)
			first = first.next;
		else 
			previos.next = current.next;
		return current;
	}
	
	public void displayList() {
		System.out.print("List (first --> last: )");
		Link current = first;
		while (current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
