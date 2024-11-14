package main;

import java.io.IOException;
import java.util.Scanner;

import controller.ProdutoController;
import model.Alimento;
import model.Blusa;
import model.Eletronico;

public class Menu {


	public static void main(String[] args) {		
	
		Scanner scan = new Scanner(System.in);
		
		ProdutoController produtos = new ProdutoController();
		
		System.out.println("Seja bem vindo ao Ecommerce do Ornitorrinco Vendedor!");
	
		String nome, validade;
		int op, garantia, quantidade, duracaoMediaHoras;
		float valor;
		boolean led, ziper, capuz;
		
		//Teste
		produtos.cadastrarProduto(new Alimento(produtos.gerarNumero(), 
				"Frango", 12.90f , 1, 200, "12/07/2024"));
		produtos.cadastrarProduto(new Blusa(2, 
				"Blusa", 12.90f , 1, 200, "12/07/2024", "GG", true, true));
		
		boolean menu = true;
		
		while(menu) {
			System.out.println(
					 "~".repeat(20) 
					 + "\nMenu Principal\n" 
					 + "~".repeat(20)
					 + "\n[1] - Cadastrar Novo Produto"
					 + "\n[2] - Listar todos os Produtos"
					 + "\n[3] - Buscar Produto por Id"
					 + "\n[4] - Excluir um Produto"
					 + "\n[5] - Sair"
					);
			System.out.print("Opção: ");
			op = scan.nextInt();
			
			if(op == 5) {
				scan.close();
				menu = false;
				break;
			}
			
			switch(op) {
			case 1 -> 	{
				try {
					System.out.print("Cadastrar Novo Produto: ");
					System.out.println("Nome: ");
					scan.nextLine();
					nome = scan.nextLine();
					
					System.out.print("Valor: ");
					valor = scan.nextFloat();
					
					System.out.print("Quantidade em Estoque: ");
					quantidade = scan.nextInt();
					
					System.out.print("Tempo de Garantia em Meses: ");
					garantia = scan.nextInt();
					
					System.out.print("Categoria: "
							+ "\n[1] - Alimento "
							+ "\n[2] - Eletronico "
							+ "\n[3] - Roupa");
					int categoria = scan.nextInt();
	
					switch(categoria) {
					case 1 -> {
						System.out.print("Expira (formato 00/00/00) em: ");
						scan.nextLine();
						validade = scan.nextLine();
						produtos.cadastrarProduto(new Alimento(produtos.gerarNumero(), 
								nome, valor , quantidade, garantia, validade));
					}
					case 2 -> {
						System.out.print("Possui Led? true ou false: ");
						led = scan.nextBoolean();
						
						System.out.println("Duração esperada em Horas: ");
						duracaoMediaHoras = scan.nextInt();
						produtos.cadastrarProduto(new Eletronico(produtos.gerarNumero(), 
								nome, valor , quantidade, garantia, led, duracaoMediaHoras));
					}
					case 3 -> {
						System.out.println("Qual tipo de roupa: "
								+ "[1] Blusa ");
						int tipo = scan.nextInt();
						switch(tipo) {
						case 1 -> {
							System.out.println("Qual o tamanho(G, GG): ");
							scan.nextLine();
							String tamanho = scan.nextLine();
							
							System.out.print("Tem ziper? true ou false: ");
							ziper = scan.nextBoolean();
							
							System.out.print("Tem capuz? true or false: ");
							capuz = scan.nextBoolean();
							
							System.out.println("Tipo de tecido: ");
							scan.nextLine();
							String tecido = scan.nextLine();
							
							produtos.cadastrarProduto(new Blusa(produtos.gerarNumero(), 
									nome, valor , quantidade, garantia, tecido, tamanho, ziper, capuz));
								}
							}
						}
					}
				}catch(Exception e) {
					e.getMessage();
				}
				System.out.println("");
				pressKey();
				}
			case 2 -> 	{
				System.out.println("Listar todos os Produtos: ");
				produtos.listarProdutos();
				pressKey();
				}
			case 3 -> 	{
				System.out.println("Buscar Produto por ID");
				System.out.print("Id: ");
				produtos.buscarProdutoPorId(scan.nextInt());
				pressKey();
				}
			case 4 -> 	{
				System.out.println("Excluir Produto");
				System.out.print("Id: ");
				produtos.excluirProduto(scan.nextInt());
				pressKey();
				}
			}
		}
	}
	
	public static void pressKey() {
		System.out.println("Pressione Enter para Continuar...");
		
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println("Tecla invalida, Pressione Enter.");
		}
	}
}
