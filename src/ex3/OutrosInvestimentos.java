package ex3;

public class OutrosInvestimentos extends ContaBancaria {

	private double valorDosInvestimentos;

	public OutrosInvestimentos() {
		super();
	}

	public double getValorDosInvestimentos() {
		return valorDosInvestimentos;
	}

	public void setValorDosInvestimentos(double valorDosInvestimentos) {
		this.valorDosInvestimentos = valorDosInvestimentos;
	}

	@Override
	public double saldo_total(double impostos) {
		return getSaldo() - (valorDosInvestimentos + impostos);

	}

	@Override
	public void extrato(double impostos) {
		System.out.println("-- EXTRATOS DE OUTROS INVESTIMENTOS -- ");
		System.out.println("Dados do cliente: " + getNome());
		System.out.println("SALDO ANTES DO SAQUE: " + getSaldo());
		System.out.println("VALOR DO SAQUE c/ 5% de taxa: " + (getSaldo() - saldo_total(impostos)));
		System.out.println("SALDO APÓS O SAQUE: " + saldo_total(impostos));
	}

}
