package ex3;

public class Orcamento {

	private String tituloDaCompra;
	private double gastos;
	private double saldo;
	private int qtdItens;

	public Orcamento() {

	}

	// gets e sets //
	public String getTituloDaCompra() {
		return tituloDaCompra;
	}

	public void setTituloDaCompra(String tituloDaCompra) {
		this.tituloDaCompra = tituloDaCompra;
	}

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}
	// fim gets e sets //

	public double saldo_total(double impostos) {
		return getSaldo() - (getGastos() * getQtdItens() + impostos);
	}

	public void extrato(double impostos) {
		System.out.println("-- EXTRATO ORÇAMENTO --");
		System.out.println("IMPOSTOS: será cobrado 5% de gastos!");
		System.out.println("Título da compra: " + getTituloDaCompra());
		System.out.println("Gastos com 5% taxa: " + (getSaldo() - saldo_total(impostos)));
		System.out.println("Saldo final: " + saldo_total(impostos));
	}

}
