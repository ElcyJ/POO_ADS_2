package models;


public class ContaCorrente extends ContaBancaria {

    private double limite;

    public ContaCorrente(Titular titular, double limite){

        super(titular);

        this.limite = limite;

    }

    @Override

    public double obterSaldo() {

        return super.obterSaldo() + this.limite;

    }

}