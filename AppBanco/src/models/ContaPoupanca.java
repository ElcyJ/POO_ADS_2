package models;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(Titular titular){

        super(titular);

    }

    public void  render(double porcentagem){

        double saldo = super.obterSaldo() * 1 + porcentagem/100;

        super.alterarSaldo(saldo);

    }
}
