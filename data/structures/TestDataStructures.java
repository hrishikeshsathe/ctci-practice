package data.structures;

public class TestDataStructures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testSinglyLinkedList();
//		testDoublyLinkedList();
//		testStack();
//		testQueue();
//		testBinaryTree();
		testBits();
}

	public static void testBits(){
		int num = 8;
		System.out.println(Bits.getBit(num, 3));
		System.out.println(Bits.setBit(num, 4));
		System.out.println(Bits.clearBit(num, 3));
		System.out.println(Bits.updateBit(num, 5, 1));
		
	}
	public static void testBinaryTree() {
		// TODO Auto-generated method stub
		MyTree root = new MyTree(1);
		MyTree a = new MyTree(2);
		MyTree b = new MyTree(3);
		MyTree c = new MyTree(4);
		MyTree d = new MyTree(5);
		MyTree e = new MyTree(6);
		MyTree f = new MyTree(7);
		
		root.setLeft(a);
		root.setRight(b);
		a.setLeft(c);
		c.setRight(d);
		d.setLeft(e);
		e.setRight(f);
		
		System.out.println("Pre-order traversal");
		root.preOrder(root);
		System.out.println("\nIn-order traversal");
		root.inOrder(root);
		System.out.println("\nPost-order traversal");
		root.postOrder(root);
		System.out.println("\nBFS");
		root.BFS(root);
		System.out.println("\nMax - recursive "+root.getMaxRecursive(root));
		System.out.println("Search - recursive 6 "+root.searchRecursive(root, 6));
		System.out.println("Search - iterative 4 "+root.searchBFS(root, 4));
	
	}

	public static void testQueue(){
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		int dequeue = queue.dequeue();
		while(dequeue != -1){
			System.out.println(dequeue);
			dequeue = queue.dequeue();
		}
	}
	public static void testStack(){
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		int pop = stack.pop();
		while(pop != -1){
			System.out.println(pop);
			pop = stack.pop();
		}
	}
	public static void testDoublyLinkedList(){
		DoublyLinkedList head = new DoublyLinkedList(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(5);
		System.out.println("Initial list");
		head.printList();
		head.delete(2);
		head.delete(3);
		head.delete(4);
		System.out.println("\nDelete 2,3,4");
		head.printList();
		head = head.deleteHead();
		head.append(1);
		head.insert(5, 2);
		head.insert(2, 3);
		head.insert(3, 4);
		System.out.println("\nInsert 4,3,2,1");
		head.printList();
		head.delete(1);
		head = head.insertHead(6);
		System.out.println("\nNew head 6");
		head.printList();
		
		
	}
	public static void testSinglyLinkedList(){
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(6);
		System.out.println("Initial list");
		head.printList(head);
		head = head.deleteHead(head);
		System.out.println("\nDelete head");
		head.printList(head);
		System.out.println("\nInsert 5");
		head.insert(4, 5);
		head.printList(head);
		System.out.println("\nDelete node 3");
		head.delete(3);
		head.printList(head);
		System.out.println("\nDelete end");
		head.delete(6);
		head.printList(head);
		System.out.println("\nInsert head");
		head = head.insertHead(1);
		head.printList(head);
	}
}
