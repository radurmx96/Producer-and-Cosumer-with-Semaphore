package model;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread {

	public Stack stack;
	private Semaphore semFull;
	private Semaphore semFree; 
	
	public Consumer(Stack stack1, Semaphore semFull, Semaphore semFree) {
		super();
		this.stack = stack1;
		this.semFree = semFree;
		this.semFull = semFull;
	}

	@Override
	public void run() {

		while (true) {
			
			try {
				semFull.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			synchronized (stack) {
	
				stack.pop();
			}
			
			semFree.release();
			
			try {
				sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print("Element removed --- ");
			stack.printEmptySlotsAndElement();
			System.out.println(" removed");
			//stack.pop();
				
			}
		}
	

}
