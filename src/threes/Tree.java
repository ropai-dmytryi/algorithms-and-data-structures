package threes;

import java.util.Stack;

/**
 * Реализация двоичного дерева
 * 
 * @author dima
 *
 */
class Node {

	public int iData; // Данныые используемые в качестве ключа
	public double dData; // Другие данные
	public Node leftChild;// Левый потомок
	public Node rightChild;// Правый потомок

	public Node(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
	}

	public void displayNode() { // Вывод узла
		System.out.print("{" + iData + ", " + dData + "}");
	}
}

public class Tree {

	private Node root;// Корень

	public Tree() {
		root = null;
	}

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData) // Налево?
				current = current.leftChild;
			else // Или направо?
				current = current.rightChild;
			if (current == null) // Если нет
				return null;
		}
		return current;
	}

	public void insert(int id, double dd) {
		Node newNode = new Node(id, dd); // Новый узел

		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				if (id < current.iData) {// Налево?
					current = current.leftChild;
					if (current == null) {// Если конец - вставить слева
						parent.leftChild = newNode;
						return;
					}
				} else {// Направо?
					current = current.rightChild;
					if (current == null) {// Если конец - вставить справа
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.iData != key) {// Поиск узла
			parent = current;
			if (key < current.iData) {// Налево?
				isLeftChild = true;
				current = current.leftChild;
			} else {// Направо?
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false;// не найден
		}
		/**
		 * Если узел не имеет потомков - то он просто удаляется
		 */
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		/**
		 * Если нет правого потомка узел заменяется левым поддеревом
		 */
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;

		/**
		 * Если нет левого потомка узел заменяется правым поддеревом
		 */
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		else { // Если два потомка, узел заменяется приемником
				// Поиск приемника для удаляемого узла(current)
			Node successor = getSuccessor(current);

			// Родитель current связывается с посредником
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			// Преемник связывается с левым потомком current
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	/**
	 * Метод возвращает узел со следующим значением после delNode. Дляя этого он
	 * сначала переходит к правому потомку, затем отслеживает цепочку левых потомком
	 * этого узла.
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;// Переход к правому потомку
		while (current != null) {// Пока остаются левые потомки
			successorParent = successor;
			successor = current;
			current = current.leftChild;// Переход к левому потомку
		}
		/**
		 * Если преемник не является правым потомком, создать связи между ними
		 */
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void traverse(int traverseType) {

		switch (traverseType) {
		case 1:
			System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder traversal: ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostOrder travesal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	public void displayTree() {
		Stack<Node> globalStack = new Stack<>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(".................................................");
		while (isRowEmpty == false) {
			Stack<Node> localStack = new Stack<>();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');
			while (globalStack.isEmpty() == false) {
				Node temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);

					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println(".................................................");

	}
}
