package main;
import java.util.concurrent.Semaphore;

import model.Consumer;
import model.Producer;
import model.Stack;

public class Application {

	public Thread producerThread;
	public Thread consumerThread;
	private final int MAXSIZE = 5;

	public static void main(String[] args) throws InterruptedException {
		
		new Application().start();
	}

	private void start() throws InterruptedException {

		manageThreads();
	}

	public void manageThreads() throws InterruptedException {

		initThreads();
		startThreads();
		joinThreads();
	}

	public void initThreads() {

		Stack stack = new Stack(MAXSIZE);
		
		Semaphore semFree = new Semaphore(MAXSIZE);
		Semaphore semFull = new Semaphore(0);
		
		Producer producedElement = new Producer(stack, semFree, semFull);
		producerThread = new Thread(producedElement);

		Consumer consumedElement = new Consumer(stack, semFree, semFull);
		consumerThread = new Thread(consumedElement);
	}

	private void joinThreads() throws InterruptedException {

		producerThread.join();
		consumerThread.join();
	}

	private void startThreads() {

		producerThread.start();
		consumerThread.start();
	}

}
