package main;

import java.util.Scanner;

import main.domain.CicleQueueManagement;
import main.exception.EmptyQueueException;

public class main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		final var decision = scanner.next();
		if (decision.equalsIgnoreCase("circular"))
			circularQueueInititalizer(scanner);
		else
			prioritaryQueueInititalizer(scanner);

	}

	private static void prioritaryQueueInititalizer(Scanner scanner) {
		// TODO Auto-generated method stub

	}

	private static void circularQueueInititalizer(Scanner scanner) throws EmptyQueueException {
		System.out.println("Digite o tamanho da fila maior que 2");
		final var validate = scanner.nextInt();
		String[] filaCiruclar = new String[validate > 2 ? validate : 6];
		CicleQueueManagement queueManagement = new CicleQueueManagement(filaCiruclar);

		while (true) {
			if (queueManagement.getQueue().length > 1) {
				System.out.println("Deseja adicionar ou remover um elemento da fila?(Adicionar/remover/N)");
			} else {
				System.out.println("Deseja adicionar na fila?(Adicionar/N)");
			}
			String decision = scanner.next();
			if ("n".equalsIgnoreCase(decision)) {
				break;
			} else if ("adicionar".equalsIgnoreCase(decision)) {
				System.out.println("digite o valor da fila");
				queueManagement.addCicleQueue(scanner.next());

			} else if ("remover".equalsIgnoreCase(decision)) {
				queueManagement.removeCicleQueue();

			}

		}
	}

}
