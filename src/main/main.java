package main;

import java.util.Scanner;

import main.domain.CicleQueueManagement;
import main.domain.PrioritayQueueManagement;
import main.exception.EmptyQueueException;
import main.exception.InvalidOptionException;

public class main {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Selecione a fila que quer executar (circular/prioridade)");
		final var decision = scanner.next();
		if ("circular".equalsIgnoreCase(decision))
			circularQueueInititalizer(scanner);
		else
			prioritaryQueueInititalizer(scanner);

	}

	private static void prioritaryQueueInititalizer(Scanner scanner) throws Exception {
		Scanner sv = new Scanner(System.in);
		int opcao = 0;

		PrioritayQueueManagement queueManagement = new PrioritayQueueManagement(1, 1, 0, 0);
		do {
			System.out.println("1- Retira Senha Convencional");
			System.out.println("2-Chama Senha");
			System.out.println("3-Fim");
			System.out.println("4- Retira Senha Prioridade");
			System.out.println("5 - printar as filas");

			opcao = sv.nextInt();

			switch (opcao) {

			case 1:
				queueManagement.addQueueLowPriority();
				break;
			case 2:
				queueManagement.removeQueue();
				break;

			case 3:
				System.out.println("Finalizado");
				break;
			case 4:
				queueManagement.addQueueHightPrioritary();
				break;
			case 5:
				queueManagement.showQueues();
			default:
				throw new InvalidOptionException("selecione uma opção valida");

			}

		} while (opcao != 3);
		sv.close();
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
