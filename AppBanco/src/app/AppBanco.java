package app;

import service.Agencia;

import java.util.ArrayList;

import java.util.Scanner;


public class AppBanco {


    public static void main(String[] args) {

        ArrayList<Object> contas = new ArrayList<>();

        Agencia agencia = new Agencia(contas);

        Scanner input = new Scanner(System.in);

        String menu = "*** MENU ***\n" +
                    "1 - Abrir conta\n" +
                    "2 - Depósito\n" +
                    "3 - Entrar";

        print(menu);

        int opcao = input.nextInt();

        while (opcao != 0){

            switch (opcao){

                case 1:

                    print("Nome: ");

                    String nome = input.next();

                    print("CPF: ");

                    int cpf = input.nextInt();

                    print("Senha: ");

                    String senha = input.next();

                    print("Confirme a senha: ");

                    String senhaConfirma = input.next();

                    if (senha.equals(senhaConfirma)){

                        print("** Tipo de conta **\n" +
                                "1 - Conta Corrente\n" +
                                "2 - Conta Poupança\n" +
                                "3 - Conta Digital\n" +
                                "4 - Conta Investimento\n" +
                                "5 - Conta Capitalização");

                        int tipoConta = input.nextInt();

                        if (tipoConta == 1 || tipoConta == 3 ){

                            print("Digite o limite: ");

                            double limite = input.nextDouble();

                            agencia.novaConta(nome, cpf, senha, tipoConta, limite);

                            print("Conta criada com sucesso\n" +

                                    "Numero da sua conta: " + agencia.obterNumConta());

                        }

                        if (tipoConta == 2){

                            agencia.novaConta(nome, cpf, senha, tipoConta);

                            print("Conta criada com sucesso\n" +

                                    "Numero da sua conta: " + agencia.obterNumConta());
                        }

                        if (tipoConta == 4){

                            print("Digite a quantidade de prazos: ");

                            int prazos = input.nextInt();

                            agencia.novaConta(nome, cpf, senha, tipoConta, prazos);

                            print("Conta criada com sucesso\n" +

                                    "Numero da sua conta: " + agencia.obterNumConta());
                        }

                        if (tipoConta == 5){

                            print("Digite o valor dos depósitos: ");

                            double deposito = input.nextDouble();

                            agencia.novaConta(nome, cpf, senha, tipoConta, deposito);

                            print("Conta criada com sucesso\n" +

                                    "Numero da sua conta: " + agencia.obterNumConta());

                        }

                        break;
                    }


                case 2:

                    print("Número da conta a se depositar: ");

                    int num = input.nextInt();

                    print("Valor a se depositar: ");

                    double valor = input.nextDouble();

                    if (agencia.depositar(num, valor)){

                        print("Depósito realizado");

                    }

                    else {

                        print("Falha no depósito");
                    }

                    break;

                case 3:

                print("Número da conta: ");

                int numConta = input.nextInt();

                print("Senha: ");

                String senhaConta = input.next();

                if (agencia.logarConta(numConta, senhaConta)){

                    String menuConta = "* Opções *\n" +
                                    "1 - Sacar\n" +
                                    "2 - Depositar\n" +
                                    "3 - Trasferir\n" +
                                    "4 - Consultar saldo\n" +
                                    "5 - Sair";

                    print(menuConta);

                    int opcaoConta = input.nextInt();

                    while(opcaoConta != 0){

                        switch (opcaoConta){

                            case 1:
                                print("Digite o número da sua conta: ");

                                num = input.nextInt();

                                print("Digite o valor a se sacar: ");

                                valor = input.nextDouble();

                                if (agencia.sacar(num, valor)){

                                    print("Saque realizado");
                                }
                                else{

                                    print("Falha no saque");

                                }
                                break;

                            case 2:

                                print("Digite o número da conta: ");

                                num = input.nextInt();

                                print("Digite o valor a se depositar: ");

                                valor = input.nextDouble();

                                if (agencia.depositar(num, valor)){

                                    print("Depósito realizado");
                                }
                                else{

                                    print("Falha no depósito");

                                }
                                break;

                            case 3:

                                print("Digite o número da conta para qual tranferir: ");

                                num = input.nextInt();

                                print("Digite o valor a transferir: ");

                                valor = input.nextDouble();

                                agencia.transferir(num, valor);

                                break;

                            case 4:

                                System.out.println(agencia.consultarSaldo());

                                break;

                            case 5:

                                if (agencia.sairConta()){

                                    print("Saiu");
                                }
                                else {

                                    print("Error");
                                }

                                break;

                        }

                        opcaoConta = input.nextInt();

                        print(menuConta);

                        break;
                    }
                }

            }



            print(menu);

            opcao = input.nextInt();

        }

    }

    private static void print(String msg){

        System.out.println(msg);

    }

}
