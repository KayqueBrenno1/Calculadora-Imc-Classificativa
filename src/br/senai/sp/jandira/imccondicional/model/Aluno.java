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
        if (imc <= 18.6) {
            status = "Abaixo do peso";
        } else if (imc >= 18.6 && imc < 25.0) {
            status = "Peso ideal (parabéns)";
        } else if (imc >= 25.0 && imc < 30.0) {
            status = "Levemente acima do peso";
        } else if (imc >= 30.0 && imc < 35.0) {
            status = "Obesidade grau I";
        } else if (imc >= 35.0 && imc < 40.0) {
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
