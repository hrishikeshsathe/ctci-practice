package ds.and.algos;

import java.util.Stack;

import data.structures.Node;

public class LinkedListQuestions{
	static Node testNode1, testNode2;
	
	public static void main(String args[]){
		testNode1 = new Node(1);
		testNode2 = new Node(1);
		for(int i = 2; i <= 10; i++)
			testNode1.append(i);
		testNode2.append(3);
		testNode2.returnNode(2).next = testNode1.returnNode(5);

//		checkForLoopAndLength(testNode);
//		testNode1 = reverse(testNode1);
//		testNode1.printList(testNode1);
//		System.out.println(findMergePoint(testNode1,testNode2).getData());
//		reverseLinkedList(testNode1);
//		evenOrOdd(testNode1);
		testNode1 = reversePairs(testNode1);
		testNode1.printList(testNode1);
	}
	
	public static Node reversePairs(Node head){
		Node temp1 = null, temp2 = null;
		while(head != null && head.getNext() != null){
			if(temp1 != null){
				temp1.next.next = head.next;
			}
			temp1 = head.next;
			head.next = head.next.next;
			temp1.next = head;
			if(temp2 == null)
				temp2 = temp1;
			head = head.next;
		}
		return temp2;
	}
	
	public static void evenOrOdd(Node head){
		while(true){
			if(head == null){
				System.out.println("Odd");
				break;
			}
			else if(head.getNext() == null){
				System.out.println("Even");
				break;
			}
			head = head.getNext();			
		}
	}
	
	public static void reverseLinkedList(Node head){
		if(head == null)
			return;
		reverseLinkedList(head.getNext());
		System.out.println(head.getData());
	}
	
	public static Node findMergePoint(Node head1, Node head2){
		Stack<Node> firstStack = new Stack<Node>();
		Stack<Node> secondStack = new Stack<Node>();
		Node mergePoint = null;
		while(head1 != null){
			firstStack.push(head1);
			head1 = head1.getNext();
		}
		while(head2 != null){
			secondStack.push(head2);
			head2 = head2.getNext();
		}
		while(!firstStack.isEmpty() && !secondStack.isEmpty()){
			if(firstStack.peek() != secondStack.peek())
				return mergePoint;
			mergePoint = firstStack.pop();
			secondStack.pop();
		}
		return null;
	}
	
	public static void lengthOfLoop(Node head, Node fastPointer){
		int length = 0;
		while(head != fastPointer){
			head = head.getNext();
			length++;
		}
		System.out.println("Length of Loop "+length);
		
	}
	public static void checkForLoopAndLength(Node root){
		Node last = root.returnNode(10);
		last.next = root.returnNode(5);
		Node slowPointer = checkLoop(root);
		if(slowPointer != null){
			System.out.println("Starting Node of Loop "+getStartNode(slowPointer, root));
			lengthOfLoop(root, slowPointer);
		}
		else
			System.out.println("No loop");
	}
	public static Node checkLoop(Node root){
		if(root == null){
			return null;
		}
		Node slowPointer = root;
		Node fastPointer = root;
		while(slowPointer != null && fastPointer != null){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if(slowPointer == fastPointer)
				return slowPointer;
		}
		return null;
	}
	
	public static int getStartNode(Node slowPointer, Node head){
		Node fastPointer = head;
		while(fastPointer != slowPointer){
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
		}
		return slowPointer.getData();
	}
	
	public static Node reverse(Node head){
		Node nextNode = null, temp = null;
		while(head != null){
			nextNode = head.getNext();
			head.next = temp;
			temp = head;
			head = nextNode;
		}
		return temp;
	}
}