package threes.three234;

/**
 * Реализация узла
 * @author dima
 *
 */
public class Node {

	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER - 1];
	/**
	 * Связывание узла с потомком
	 * @param childNum
	 * @param child
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}
	/**
	 * Метод отсоеденяет потомка от узла и возвращает его
	 * @param childNum
	 * @return
	 */
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	public Node getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}

	public int getNumItems() {
		return numItems;
	}

	public DataItem getItem(int index) {
		return itemArray[index];
	}

	public boolean isFull() {
		return (numItems == ORDER - 1) ? true : false;
	}

	public int findItem(long key) {

		for (int i = 0; i < ORDER - 1; i++) {
			if (itemArray[i] == null) {
				break;
			} else if (itemArray[i].dData == key) {
				return i;
			}
		}
		return -1;
	}

	public int insertItem(DataItem newItem) {
		
		numItems++;								//Добавление нового элемента
		long newKey = newItem.dData;			//Получения его ключа
		
		for(int i = ORDER - 2; i>=0; i--) {		//Начиная справа проверяем элементы
			if(itemArray[i] == null) {			//Если ячейка пуста, перейти на одну ячейку
				continue;
			} else {
				long itsKey = itemArray[i].dData;
				if(newKey < itsKey) {
					itemArray[i+1] = itemArray[i];
				} else {
					itemArray[i+1] = newItem;
					return i+1;
				}
			}
		}
		itemArray[0] = newItem; //Все элементы сдвинуты, вставка нового элемента
		return 0;
	}
	/**
	 * Удаление найбольшего элемента
	 * @return
	 */
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}
	
	public void dislayNode() {
		for(int i = 0; i < numItems; i++) {
			itemArray[i].displayItem();
		}
		System.out.println("/");
	}
}
