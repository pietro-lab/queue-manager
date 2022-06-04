package main.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrioritayQueueManagement {

	private List<Integer> filaNormal = new ArrayList<>();   
	private List<Integer> filaPrior = new ArrayList<>();
	private int contPrior = 0;
	private int contNormal = 0;
	private int senha = 0;
	private int prior = 0;
	
	public PrioritayQueueManagement(int contPrior, int contNormal, int senha, int prior) {
		this.contPrior = contPrior;
		this.contNormal = contNormal;
		this.senha = senha;
		this.prior = prior;
	}
	
	
	public  void addQueueLowPriority() {
		senha++;
		filaNormal.add(senha);
		System.out.println("Sua senha é: NOR-" + senha);
		System.out.println("");
	}
	public void removeQueue() {
		if(contPrior <= filaPrior.size()) {
    		System.out.println("Senha Prioridade: "+ contPrior);
    		contPrior++;
    	}
    	else if(contNormal <= filaNormal.size()){
    		System.out.println("Senha Normal: " + contNormal);
    		contNormal++;
    	}
    	else {
    		System.out.println("Nao ha ninguem na fila!!!!!");
    	}

    	System.out.println("");
    	

	}
	public void addQueueHightPrioritary() {
		prior++;
        filaPrior.add(prior);
        System.out.println("Sua Senha é: Prior-" + prior);
        System.out.println("");
		
	}


	public void showQueues() {
		System.out.println("fila prioritaia = " + filaPrior.toString());
		System.out.println("fila normal = " + filaNormal.toString());
        System.out.println("");
		
	}
	
	
}
