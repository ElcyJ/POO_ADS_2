package models;

public class ContaBancaria {

    private static int contadorNumero = 1;

    private int numero;

    Titular titular;

    private double saldo;

    private boolean logada = false;


    public ContaBancaria(Titular titular, double saldo){

        this.numero = ContaBancaria.proximoNumero();

        this.titular = titular;

        this.saldo = saldo;

    }

    public ContaBancaria(Titular titular){

        this(titular, 0);

    }

    private static int proximoNumero(){

        return ContaBancaria.contadorNumero++;

    }

    public void depositar(double valor){

        this.saldo += valor;

    }

    public boolean sacar(double valor){

        if (this.temSaldoSuficiente(valor)){

            this.saldo -= valor;

            return true;

        }

        return false;

    }

    public boolean logarConta (){

        this.logada = true;

        return logada;
    }

    public boolean sairConta(){

        this.logada = false;

        return logada;
    }

    public boolean isLogada(){

        return logada;
    }

    /*public static boolean transferir(ContaBancaria origem, ContaBancaria destino, double valor){

        return origem.transferir(destino, valor);

    }


    public boolean transferir(ContaBancaria contaDestino, double valor){

        if (this.sacar(valor)){

            contaDestino.depositar(valor);

            return true;

        }

        return false;

    }*/



    private boolean temSaldoSuficiente(double valor) {

        return this.obterSaldo() >= valor;

    }



    public double obterSaldo(){

        return this.saldo;

    }

    public void alterarSaldo(double saldo){
        this.saldo = saldo;
    }


    public int getNumero() {
        return numero;
    }

    public String getSenha(){

        return this.titular.senha;
    }


    @Override

    public String toString() {

        return "ContaBancaria [" +

                "numero=" + numero +

                ", titular='" + titular.nome + '\'' +

                ", saldo=" + obterSaldo() +

                ']';

    }

}


/*package
        import javax.swing.*;

public static void main(String [] args){

        String nome;

        nome = JOptionPane.showInputDialog("Qual seu nome?");

        String msg = "Olá\n"
        }

}

*/