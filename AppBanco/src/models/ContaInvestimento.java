package models;

public class ContaInvestimento extends ContaPoupanca {

    private int prazos;

    public ContaInvestimento(Titular titular, int prazos){

        super(titular);
        this.prazos = prazos;

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

}
