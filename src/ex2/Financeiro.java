package ex2;

public class Financeiro extends Hotelaria {

    private double saldo;

    public Financeiro() {
        super();
    }

    public Financeiro(double saldo, String nomeHotel) {
        super(nomeHotel);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double extrato() {//modelo para as subclasses seguirem
        System.out.println("EXTRATO DO SETOR FINANCEIRO");
        return 0.0;
    }
}
