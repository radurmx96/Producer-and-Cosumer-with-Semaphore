package model;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread {

	public Stack stack;
	private Semaphore semFull;
	private Semaphore semFree;

	public Consumer(Stack stack1, Semaphore semFree, Semaphore semFull) {
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
				System.out.println("1");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			synchronized (stack) {
				System.out.println("2");
				stack.pop();
				System.out.println("3");
			}
			System.out.println("4");
			semFree.release();
			System.out.println("5");
			
			try {
				sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.print("Element removed --- ");
			stack.printEmptySlotsAndElement();
			System.out.println(" removed");
			// stack.pop();

		}
	}
}
