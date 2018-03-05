package model;
import java.util.LinkedList;
import java.util.Queue;

public class Stack {
	
	private int maxSize;
	private int sizeCounter = 0;
	private Queue<Integer> queue;
	private Integer ongoingElement = 1; 
	
	public Stack(int maxSize) {
		super();
		this.maxSize = maxSize;
		queue = new LinkedList<>();
	}

	public boolean isFull() {
		return queue.size() == maxSize;
	}

	public void push() {
		queue.add(ongoingElement);
		sizeCounter ++;
		//notifyAll();
	}

	public void pop() {
		queue.remove();
		//notifyAll();
		sizeCounter --;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public void printEmptySlotsAndElement() {
		System.out.print(maxSize - sizeCounter + " slots left --- " + ongoingElement);
		
	}
	
}
