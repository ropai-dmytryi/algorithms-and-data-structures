package threes.three234;
/**
 * Реализация элементов данных хранящихся в узлах
 * @author dima
 *
 */
public class DataItem {
	
	public long dData;//Один объем данных
	
	public DataItem(long dd) {
		this.dData = dd;
	}
	
	public void displayItem() {
		System.out.print("/" + dData);
	}

}
