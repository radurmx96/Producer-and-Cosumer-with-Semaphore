package model;

import java.util.concurrent.Semaphore;

public class Producer extends Thread {

	public Stack stack;
	private Semaphore semFree;
	private Semaphore semFull;

	public Producer(Stack stack1, Semaphore semFree, Semaphore semFull) {
		this.stack = stack1;
		this.semFree = semFree;
		this.semFull = semFull;
	}

	@Override
	public void run() {
		
		try {
			sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true) {

			try {
				semFree.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			synchronized (stack) {

				stack.push();
			
			}
			
			semFull.release();

			System.out.print("Element added --- ");
			stack.printEmptySlotsAndElement();
			System.out.println(" added");
			// stack.push();

		}
	}

}