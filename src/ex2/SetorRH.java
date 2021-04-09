package ex2;

public class SetorRH extends Financeiro {

    private double ganhosTotal;
    private double gastoTotal;

    public SetorRH() {
    }

    public SetorRH(double ganhosTotal, double gastoTotal, double saldo, String nomeHotel) {
        super(saldo, nomeHotel);
        this.ganhosTotal = ganhosTotal;
        this.gastoTotal = gastoTotal;
    }

    public double getGanhosTotal() {
        return ganhosTotal;
    }

    public void setGanhosTotal(double ganhosTotal) {
        this.ganhosTotal = ganhosTotal;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }
    
     public void atualizaSaldo() {
        setSaldo (getSaldo() + getGanhosTotal()- getGastoTotal());
    }

    @Override
    public double extrato() {
        double varia = getGastoTotal() + getGanhosTotal();
        System.out.println(" - - - - RH - - - - -");
        System.out.println("EXTRATO DO SETOR FINANCEIRO");
        System.out.println("Nome do HOTEL: " + getNomeHotel());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Gasto foi : " + getGastoTotal()+ ", lucro foi: " + getGanhosTotal());
        atualizaSaldo();
        if (getGastoTotal() < getGanhosTotal()) {
            System.out.println("HOUVE LUCRO!");
        } else {
            System.out.println("HOUVE PREJUÍZO!");
        }
        System.out.println("Saldo ATUALIZADO: " + getSaldo());
        return varia;
    }

}
