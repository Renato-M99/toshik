package ex3;

public class ContaBancaria extends DadosPessoais {

	private double taxaSaque;

	public ContaBancaria() {
		super();
	}

	public double getTaxaSaque() {
		return taxaSaque;
	}

	public void setTaxaSaque(double taxaSaque) {
		this.taxaSaque = taxaSaque;
	}

	@Override
	public double saldo_total(double gastos) {
		return getSaldo() - (gastos + taxaSaque);
		//
	}

	@Override
	public void extrato(double saque) {
		System.out.println("-- EXTRATO DA CONTA BANCÁRIA --");
		System.out.println("Dados do cliente: " + getNome());
		System.out.println("SALDO ANTES DO SAQUE: " + getSaldo());
		System.out.println("VALOR DO SAQUE: " + (getSaldo() - saldo_total(saque)));
		System.out.println("SALDO APÓS O SAQUE: " + saldo_total(saque));

	}
}