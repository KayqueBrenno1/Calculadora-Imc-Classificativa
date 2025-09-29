package br.senai.sp.jandira.imccondicional.model;

import java.util.Scanner;

public class Aluno {
    String nome;
    String status;
    double peso;
    double imc;
    double altura;

    public void obterDados(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("---------- CALCULADORA IMC ----------");
        System.out.print("Digite o seu nome: ");
        nome = leitor.nextLine();

        System.out.print("Digite o seu peso (em kilogramas): ");
        peso = leitor.nextDouble();

        System.out.print("Digite a sua altura (em metros): ");
        altura = leitor.nextDouble();

        calcularImc();
    }
    public void calcularImc(){
        double alturaAoQuadrado = altura * altura;

        imc = peso / alturaAoQuadrado;

        classificarCondicao();
    }
    public void classificarCondicao() {
        if (imc <= 18.5) {
            status = "Abaixo do peso";
        } else if (imc <= 24.9) {
            status = "Peso ideal (parabéns)";
        } else if (imc <= 29.9) {
            status = "Levemente acima do peso";
        } else if (imc <= 34.9) {
            status = "Obesidade grau I";
        } else if (imc <= 39.9) {
            status = "Obesidade grau II (severa)";
        } else {
            status = "Obesidade III (mórbida)";
        }

        exibirResultados();
    }
    public void exibirResultados(){
        String imcDecimal = String.format("%.2f", imc);
        System.out.println("------------- RESULTADO -------------");
        System.out.println("Nome: " + nome);
        System.out.println("IMC: " + imcDecimal);
        System.out.println("Status: " + status);
        System.out.println("-------------------------------------");
    }
}
