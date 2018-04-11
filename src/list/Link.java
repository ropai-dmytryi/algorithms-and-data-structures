package list;

public class Link {

	public int iData; //key
	public double dData; //value
	public Link next;
	
	public Link(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
	}
	
	public void displayLink() {
		System.out.println("{" + iData + ", " + dData + "}");
	}
}
