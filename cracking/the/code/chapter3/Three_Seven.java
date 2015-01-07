package cracking.the.code.chapter3;

import java.util.LinkedList;

abstract class Animal{
	private int order;
	protected String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	public void setOrder(int order){
		this.order = order;
	}
	
	public int getOrder(){
		return order;
	}
		
	public boolean isOlderThan(Animal a){
		return this.getOrder() < a.getOrder();
	}
}

class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
}

class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}

public class Three_Seven{
	LinkedList<Dog> dog = new LinkedList<Dog>();
	LinkedList<Cat> cat = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog)
			dog.addLast((Dog) a);
		else if(a instanceof Cat)
			cat.addLast((Cat) a);
	}
	
	public Animal dequeueAny(){
		if(dog.size() == 0)
			return dequeueCat();
		else if(cat.size() == 0)
			return dequeueDog();
		Dog d = dog.peek();
		Cat c = cat.peek();
		if(d.isOlderThan(c))
			return dequeueDog();
		else
			return dequeueCat();
	}
	
	public Dog dequeueDog(){
		return dog.poll();
	}
	
	public Cat dequeueCat(){
		return cat.poll();
	}
	public static void main(String args[]){
		Dog d = new Dog("first Dog");
		Cat c = new Cat("first Cat");
		Three_Seven obj = new Three_Seven();
		obj.enqueue(d);
		obj.enqueue(c);
		System.out.println(obj.dequeueDog().name);
	}
}