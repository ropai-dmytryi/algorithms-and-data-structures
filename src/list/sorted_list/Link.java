package list.sorted_list;

public class Link {
	
		public double dData; //value
		public Link next;
		
		public Link(long dData) {
			this.dData = dData;
		}
		
		public void displayLink() {
			System.out.println(dData + " ");
		}
}
