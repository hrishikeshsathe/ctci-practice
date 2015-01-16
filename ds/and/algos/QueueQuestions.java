package ds.and.algos;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import data.structures.MyQueue;
import data.structures.QueueUsingStack;
import data.structures.StackUsingQueue;

public class QueueQuestions{
	public static void main(String args[]){
//		reverseQueueTest();
//		testQueueUsingStack();
//		testStackUsingQueue();
//		stackPairWiseOrder();
		interweave();
	}
	
	public static void interweave(){
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		for(int i = 1; i<=10; i++)
			q1.add(i);
		for(int i=0; i<5; i++)
			q2.add(q1.poll());
		while(!q2.isEmpty()){
			q1.add(q2.poll());
			q1.add(q1.poll());
		}
		while(!q1.isEmpty())
			System.out.println(q1.poll());
	}
	
	public static void stackPairWiseOrder(){
		Stack<Integer> s = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean flag = true;
		for(int i = 1; i<=10; i++)
			s.push(i*2);
		while(!s.isEmpty())
			q.add(s.pop());
		while(!q.isEmpty())
			s.push(q.poll());
		while(!s.isEmpty()){
			int x = s.pop();
			q.add(x);
			if(!s.isEmpty()){
				int y = s.pop();
				q.add(y);
				if(Math.abs(x-y) == 0)
					flag = false;
			}
		}
		while(!q.isEmpty())
			s.push(q.poll());
		System.out.println(flag);
	}
	
	public static void testStackUsingQueue(){
		StackUsingQueue s = new StackUsingQueue();
		for(int i = 0; i < 10; i++)
			s.push(i+1);
		for(int i = 0; i < 10; i++)
			System.out.println(s.pop());
		
	}
	
	public static void testQueueUsingStack(){
		QueueUsingStack q = new QueueUsingStack();
		for(int i = 0; i < 10; i++)
			q.enqueue(i+1);
		for(int i = 0; i < 10; i++)
			System.out.println(q.dequeue());
		
	}
	
	public static void reverseQueueTest(){
		MyQueue queue = new MyQueue();
		for(int i = 1; i<=5; i++)
			queue.enqueue(i);
		reverseQueue(queue);
		for(int i = 1; i<=5; i++){
			System.out.println(queue.dequeue());
		}
	}
	
	public static void reverseQueue(MyQueue queue){
		if(queue.peek() == -1)
			return;
		int temp = queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(temp);
	}
}