package main.domain;

import java.util.Arrays;

import main.exception.EmptyQueueException;
import main.exception.FullQueueException;

public class QueueManagement {

	private String[] queue;
	private int inicio, fim, size;

	public String[] getQueue() {
		return this.queue;

	}

	public QueueManagement(String[] filaCiruclar) {
		this.queue = filaCiruclar;
		this.inicio = this.fim = -1;
		this.size = queue.length;
	}

	public void addCicleQueue(String data) throws FullQueueException {

		if ((inicio == 0 && fim == size - 1) || ((inicio - 1) % (size - 1) == fim)) {
			throw new FullQueueException("Fila cheia");
		} else if (fim == -1 && inicio <= 0) {
			inicio = 0;
			fim = 0;
			queue[fim] = data;
		} else if (fim == -1 && inicio >= 0) {
			if (fim == size - 1) {
				fim = 0;
			} else {
				fim++;
			}
			queue[fim] = data;
		}

		else if (fim == size - 1 && inicio != 0) {
			fim = 0;
			queue[fim] = data;
		} else {
			fim = (fim + 1);

			if (inicio <= fim) {
				queue[fim] = data;
			} else {
				queue[fim] = data;
			}

		}

		System.out.println(Arrays.toString(queue));
	}

	public void removeCicleQueue() throws EmptyQueueException {
		if (inicio == -1) {
			throw new EmptyQueueException("Fila vazia");
		}

		queue[inicio] = null;

		if (inicio == fim) {
			inicio = -1;
			fim = -1;
		}

		else if (inicio == size - 1 ) {

			if (fim == -1) {
				inicio = -1;
			} else if(inicio == 0 )   { // mudar esse if
				fim = inicio - 2;
				inicio = 0; // mudar essa atribuição
			}
			else {
				fim = -1;
				inicio--;
			}
		} else if (fim == size - 1) {

			inicio = inicio + 1;
			fim = inicio - 2;
		} else {
			inicio = inicio + 1;
		}
		System.out.println(Arrays.toString(queue));
	}

}
