package ex2;

public class Almoxarifado_Materiais extends Financeiro{
    
    private double taxa;
    private double vendas;

    public Almoxarifado_Materiais() {
    }

    public Almoxarifado_Materiais(double taxa, double vendas, double saldo, String nomeHotel) {
        super(saldo, nomeHotel);
        this.taxa = taxa;
        this.vendas = vendas;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
    
     public void atualizaSaldo() {
        setSaldo (getSaldo() + getVendas() - getTaxa());
    }
    
    @Override
    public double extrato() {
        double varia = getVendas() + getTaxa();
        System.out.println(" - - - - Almoxarifado e Materiais - - - - -");
        System.out.println("EXTRATO DO SETOR FINANCEIRO");
        System.out.println("Nome do HOTEL: " + getNomeHotel());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Gasto foi : " + getTaxa()+ ", lucro foi: " + getVendas());
        atualizaSaldo();
        if (getTaxa() < getVendas()) {
            System.out.println("HOUVE LUCRO!");
        } else {
            System.out.println("HOUVE PREJUÍZO!");
        }
        System.out.println("Saldo ATUALIZADO: " + getSaldo());
        return varia;
    }
    }  
    
    
    

