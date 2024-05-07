package DesafioControleFluxo.src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("## Contador, Esse programa conta do número A até o número B e aceita somente inteiros! ### \n");
        
        int parametroUm = lerInteiro("Digite o primeiro parâmetro: ", terminal);
        int parametroDois = lerInteiro("Digite o segundo parâmetro: ", terminal);
        
        try {
            // Chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
            System.out.println("Deseja corrigir os parâmetros? (Digite 'sim' para corrigir ou 'nao' para sair)");
            String escolha = terminal.next();
            if (escolha.equalsIgnoreCase("sim") || escolha.equalsIgnoreCase("s")) {
                // Inverte os parâmetros e tenta novamente
                try {
                    contar(parametroDois, parametroUm);
                } catch (ParametrosInvalidosException ex) {
                    System.out.println("Erro ao corrigir os parâmetros. Finalizando o programa.");
                }
            } else {
                // Solicitar novamente os valores de entrada
                parametroUm = lerInteiro("Digite o primeiro parâmetro: ", terminal);
                parametroDois = lerInteiro("Digite o segundo parâmetro: ", terminal);
                
                try {
                    // Tentar novamente com os novos valores de entrada
                    contar(parametroUm, parametroDois);
                } catch (ParametrosInvalidosException ex) {
                    System.out.println("Erro ao corrigir os parâmetros. Finalizando o programa.");
                }
            }
        }
        
        terminal.close();
    }
    
    static int lerInteiro(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
    }
    
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro para a contagem ocorrer!");
        }
        
        int contagem = (parametroDois - parametroUm);
        System.out.println("A contagem foi de " + contagem + " números!");
        // Realizar o for para imprimir os números com base na variável contagem
    }
}
