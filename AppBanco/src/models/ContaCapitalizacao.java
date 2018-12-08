package models;

public class ContaCapitalizacao extends ContaPoupanca {

    private int prazos = 3;

    private double deposito;

    public ContaCapitalizacao(Titular titular, double deposito){

        super(titular);

        this.deposito = deposito;

    }

    @Override

    public boolean sacar(double valor) {

        if (this.prazos > 0){

            this.prazos -= 1;

            return super.sacar(valor);

        }

        else {
            double saldo = super.obterSaldo() * 0.9;

            super.alterarSaldo(saldo);

            return super.sacar(valor);

        }

    }

    @Override

    public void depositar(double valor) {
        if (valor == deposito){

            super.depositar(deposito);

        }

    }

}
