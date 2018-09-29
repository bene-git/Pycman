package br.com.sistemabancario.entities;

public class Pessoa {

	protected int numeroConta;
	protected String nome;
	protected double saldo;
	protected String senha;
	protected int tipo;
	
	/* CRIAR CONSTRUTORES E GETTERS AND SETTERS */	
	
	
	public String toString() {
		return "NumeroConta: " + 
				getNumeroConta() +
				"\nNome:" +
				getNome() +
				"\nSaldo=" +
				String.format("%.2f R$",getSaldo()) +
				"\nTipo=" +
				getTipo();
	}
	
}