package ex3;

public class ContaPoupanca extends DadosPessoais {

	private double desconto;

	public ContaPoupanca() {
		super();
	}

	// gets e sets //
	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	// fim gets e sets //
	@Override
	public double saldo_total(double gastos) {
		return getSaldo() - (getGastos() - getDesconto());
	}

	@Override
	public void extrato(double gastos) {
		System.out.println("-- EXTRATO DA CONTA POUPANÇA --");
		System.out.println("Dados do cliente: " + getNome());
		System.out.println("SALDO ANTES DO SAQUE: " + getSaldo());
		System.out.println("VALOR DO SAQUE: " + (getSaldo() - saldo_total(gastos)));
		System.out.println("SALDO APÓS O SAQUE: " + saldo_total(gastos));
	}

}
