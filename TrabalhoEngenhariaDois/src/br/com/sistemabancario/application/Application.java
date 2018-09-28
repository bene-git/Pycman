package br.com.sistemabancario.application;

import java.util.Locale;
import java.util.Scanner;

import br.com.sistemabancario.entities.conta.Conta_Corrente;
import br.com.sistemabancario.entities.conta.Conta_Corrente_Poupanca;
import br.com.sistemabancario.entities.conta.Conta_Poupanca;
import br.com.sistemabancario.entities.usuarios.Gerente;

public class Application {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		System.out.println("-------------------------------------");
		System.out.println();
		System.out.println("    Sistema gerenciador Banc�rio");
		System.out.println();
		System.out.println("-------------------------------------");
		
		int opcao = 0;
		do {			
			System.out.println("Acesso ao Banco:");
            System.out.println("1 - Gerente");
            System.out.println("2 - Cliente");
            System.out.println("0 - Sair");
            System.out.print("OPCAO: ");
             
            try{
                opcao = sc.nextInt();
            }catch(Exception erro){
                System.out.println("ATENCAO: Somente Numeros!");
            }
            
            switch(opcao) {
            
            	case 0:
            		System.out.println("Encerrando o programa...");
            		break;
            	case 1:
            		System.out.println("-------------------------------------");
            		System.out.println("          Login do Gerente: ");
            		System.out.println("-------------------------------------");
            		boolean flag = false;
            		
            		do {
	            		System.out.print("Usuario: ");
	            		String log = sc.next();
	            		System.out.print("Senha: ");
	            		String senha = sc.next();
	            		
	            		Gerente gerente = new Gerente(/*log, senha*/);
	            		flag = gerente.validaLoginGerente();
	            		
	            		if(flag) {
	            			
	            			
	            			while(true) {
	            				int subOp = menuGerente();
	            				switch(subOp) {
	            					case 0:
	            						System.out.println("Saindo da conta...");
	            						break;
	            					case 1:
	            						int tipo = tipoConta();
	            						System.out.println("Numero da conta: ");
	            						String numConta = sc.nextLine();
	            						System.out.println("Nome do Cliente");
	            						sc.nextLine();
                                        String nome = sc.nextLine();
                                        System.out.println("Senha da Conta");
                                        String senhaCad = sc.next();
                                        criarConta(tipo, numConta, nome, senhaCad);	            						
	            				}
	            			}
         			            			
	            		}else {
	            			System.out.println("Dados inv�lidos! ");
	            		}
            		}while(!flag);            		
              		
            		
            		break;
            	case 2:
            		break; 
            	default:
            		System.out.println("ATENCAO: Opcao Inv�lida! ");
            		break;
            }
        }while(opcao != 0);
		
		sc.close();
	}
	
	public static int menuGerente() {
        System.out.println("\n ------> 1 - Cadastrar ");
        System.out.println(" ------> 2 - Remover            ");
        System.out.println(" ------> 3 - Atualizar          ");
        System.out.println(" ------> 4 - Mostrar contas     ");
        System.out.println(" ------> 0 - Sair               ");
        return sc.nextInt();
	}
	
	public static int tipoConta() {
        System.out.println("\n		Informe tipo da conta: ");
        System.out.println(" 		------> 1 - Conta Normal");
        System.out.println(" 		------> 2 - Conta Poupanca");
        System.out.println(" 		------> 3 - Conta Corrente  ");
        System.out.println(" 		------> 4 -Conta Corrente-Poupanca");

        return sc.nextInt();
	}
	
	 public static int menuCliente(){
         System.out.println("\n ------> 1 - Sacar");
         System.out.println(" ------> 2 - Transferencia");
         System.out.println(" ------> 3 - Depositar");
         System.out.println(" ------> 4 - Sair");
         System.out.println("OPCAO: ");
         return sc.nextInt();
     }
	 
	  public static void MostrarDados(){
          System.out.println("\n ------> n 1 - Listar todas as contas      ");
          System.out.println(" ------> 2 - Mostrar uma conta especifica ");
      }
	  
	  public static void criarConta(int tipoConta, String numConta, String nome, String senhaCad) {
		  if(tipoConta == 1) {
			  Conta_Poupanca conta = new Conta_Poupanca(numConta,nome,senhaCad);
			  conta.cadastroBD();			  
		  }else if (tipoConta == 2) {
			  Conta_Corrente conta = new Conta_Corrente(numConta,nome, senhaCad);
			  conta.cadastroBD();
		  }else {
			  Conta_Corrente_Poupanca conta = new Conta_Corrente(numConta,nome, senhaCad);
			  conta.cadastroBD();
		  }
	  }
	
}
