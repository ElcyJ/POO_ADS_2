package models;

public class ContaDigital extends ContaCorrente {

    public ContaDigital(Titular titular, double limite){

        super(titular, limite);

    }

    @Override

    public boolean sacar(double valor){
        return false;
    }

    @Override

    public void depositar(double valor){}

}
