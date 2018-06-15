package threes.three234;
/**
 * Представляет собой дерево
 * @author dima
 *
 */
public class Tree234 {

	private Node root = new Node();
	
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while(true) {
			if((childNumber = curNode.findItem(key)) != -1)
				return childNumber;
			else if(curNode.isLeaf())
				return -1;
			else 
				curNode = getNextChild(curNode, key);
		}
	}
	/**
	 * Вставка элемента данных
	 * @param dValue
	 */
	public void inser(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while(true) {
			if(curNode.isFull()) {						//Если узел полон
				split(curNode);							//разбить его
				curNode = curNode.getParent();			//Возврат уровня выше
				curNode = getNextChild(curNode, dValue);//Поиск
			} else if(curNode.isLeaf()) {				//Если узел листовой
				break;									//Переход к вставке
				//Узел не полный и не листовой;спуститься уровнем ниже
			} else {
				curNode = getNextChild(curNode, dValue);
			}
		}
		curNode.insertItem(tempItem);					//Вставка нового объекта DataItem
	}
	/**
	 * Разбиение узла
	 * @param thisNode
	 */
	public void split(Node thisNode) {
		
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		
		itemC = thisNode.removeItem();					//Удаление элементов из текущего узла
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);			//Отсоединение потомков
		child3 = thisNode.disconnectChild(3);
		Node newRight = new Node();						//Создание нового узла
		
		if(thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		} else {
			parent = thisNode.getParent();
		}
		//Разбиение с родителем
		itemIndex = parent.insertItem(itemB);			//Вставляется с родителем			
		int n = parent.getNumItems();					//Всего элементов
		
		for(int i = n - 1; i > itemIndex; i--) {		//Перемещение связей родителя
			Node temp = parent.disconnectChild(i);		//на одного потомка вправо
			parent.connectChild(i+1, temp);
		}
		
		parent.connectChild(itemIndex + 1, newRight);	//Связывание newRight с родителем
		
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	/**
	 * Получение соответствующего потомка при поиске значения
	 * @param theNode
	 * @param theValue
	 * @return
	 */
	public Node getNextChild(Node theNode, long theValue) {
		int i;
		int numItems = theNode.getNumItems();
		for(i = 0; i < numItems; i++) {
			if(theValue < theNode.getItem(i).dData) {
				return theNode.getChild(i);
			}
		}
		return theNode.getChild(i);
	}
	
	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level = " + level + " child = " + childNumber + " ");
		thisNode.dislayNode();
		
		int numItems = thisNode.getNumItems();
		for(int i = 0; i < numItems + 1; i++) {
			Node nextNode = thisNode.getChild(i);
			if(nextNode != null) {
				recDisplayTree(nextNode, level+1, i);
			} else {
				return;
			}
		}
	}
}
