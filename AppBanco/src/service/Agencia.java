package service;

import models.*;

import java.util.ArrayList;

public class Agencia {

    private ArrayList<ContaBancaria> contas;


    public Agencia(ArrayList contas){

        this.contas = contas;

    }

    public void novaConta(String nome, int cpf, String senha, int tipoConta){

        if (tipoConta == 2) {

            Titular titular = new Titular(nome, cpf, senha);

            ContaBancaria contaPoupanca = new ContaPoupanca(titular);

            this.contas.add(contaPoupanca);

        }

    }

    public void novaConta(String nome, int cpf, String senha, int tipoConta, double limiteOuDeposito){

        Titular titular = new Titular(nome, cpf, senha);

        switch (tipoConta){

            case 1:

                ContaBancaria contaCorrente = new ContaCorrente(titular, limiteOuDeposito);

                this.contas.add(contaCorrente);

                break;

            case 3:

                ContaBancaria contaDigital = new ContaDigital(titular, limiteOuDeposito);

                this.contas.add(contaDigital);

                break;

            case 5:

                ContaBancaria contaCapitalizacao = new ContaCapitalizacao(titular, limiteOuDeposito);

                this.contas.add(contaCapitalizacao);

                break;
        }

    }

    public void novaConta(String nome, int cpf, String senha, int tipoConta, int prazos){

        if (tipoConta == 4) {

            Titular titular = new Titular(nome, cpf, senha);

            ContaBancaria contaInvestimento = new ContaInvestimento(titular, prazos);

            this.contas.add(contaInvestimento);

        }

    }

    public boolean depositar(int num, double valor){

        for (ContaBancaria conta : contas){

            if (conta.getNumero() == num){

                conta.depositar(valor);

                return true;

            }
        }
        return false;
    }

    public boolean sacar(int num, double valor){

        for (ContaBancaria conta : contas){

            if (conta.getNumero() == num){

                conta.sacar(valor);

                return true;

            }
        }
        return false;
    }

    public void transferir(int num, double valor){

        for (ContaBancaria conta : contas){

            if (conta.isLogada()){

                conta.sacar(valor);

            }
        }

        for (ContaBancaria conta : contas){

            if (conta.getNumero() == num){

                conta.depositar(valor);

            }
        }

    }

    public double consultarSaldo(){

        for (ContaBancaria conta : contas){

            if (conta.isLogada()){

                return conta.obterSaldo();

            }
        }

        return 0;

    }

    public boolean logarConta(int num, String senha){

        for (ContaBancaria conta : contas){

            if (conta.getNumero() == num && conta.getSenha().equals(senha)){

                conta.logarConta();

                return true;

            }
        }

        return false;
    }

    public boolean sairConta(){

        for (ContaBancaria conta : contas){

            if (conta.isLogada()){

                conta.sairConta();

                return true;
            }
        }

        return false;
    }

    public int obterNumConta(){

        if (contas.size() == 1){

            return contas.get(0).getNumero();

        }
        else{

            return contas.get(contas.size() - 1).getNumero();

        }
    }

}
